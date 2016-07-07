/**
 *  WebForum (c) 2000 Daniel Lemire , This program is free software; you can
 *  redistribute it and/or modify it under the terms of the GNU General Public
 *  License as published by the Free Software Foundation (version 2). This
 *  program is distributed in the hope that it will be useful, but WITHOUT ANY
 *  WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 *  FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 *  details. You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software Foundation,
 *  Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package com.ondelette.servlet.webforum;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.ondelette.servlet.*;

/**
 *  Main servlet serving HTML
 *
 *@author     Daniel Lemire
 *@author     Raj Bhaskar
 *@created    March 12th 1999
 */
public final class WebForumServlet extends HttpServlet implements ParameterNames, AutorizationConstants {


    /**
     *  
     *
     *@param  config
     *@exception  ServletException
     *@since                        0.30
     */
    public void init(ServletConfig config)
	throws ServletException {
	super.init(config);
    }


    /**
     *  
     *
     *@param  request
     *@param  response
     *@exception  ServletException
     *@exception  IOException
     *@since                        0.30
     */
    public void doGet(HttpServletRequest request,  HttpServletResponse response)
	throws ServletException, IOException {
	doPost(request, response);
    }


    /**
     *  
     *
     *@param  request
     *@param  response
     *@exception  ServletException
     *@exception  IOException
     *@since                        0.30
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	try {
	    if (request.getParameter(RESETPARAM) != null) {
		destroy();
				// this is a possible security flaw, leaving as it is for convenience
	    }
	    // there must be a forum specified, no go otherwise!
	    String s;
	    if ((s = request.getParameter(FORUMFILEPARAM)) == null) {
		ServletErrorHandling.printErrorMessage(request, response, null);
		return;
	    }
	    // ok, we keep going
	    Forum forum = ForumFactory.getForum(new File(s));
	    User user = ServletUtil.getUser(request, response, forum);
	    if ((s = request.getParameter(SUBSCRIBEUSER)) != null) {
				user = ServletUtil.subscribing(request,response,forum);
				if(user == null) return;
	    }
	    // ok, user is now defined
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    if (forum.mAuthorizationLevel > NORMAL) {
		if (user == null) {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		} else if (user.getAutorizationLevel() < forum.mAuthorizationLevel) {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		}
	    }
	    // we check if we are deleting a message
	    if ((s = request.getParameter(DELETEMESSAGEPARAM)) != null) {
		if (user == null) {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		} else if (user.getAutorizationLevel() >= EXECUTIVEMEMBER) {
		    final int messagenumber = Integer.parseInt(s);
		    forum.askForConfirmationOnDeletingMessage(messagenumber, out, user, request.getServletPath());
		    out.flush();
		    return;
		}
	    }
	    if ((s = request.getParameter(CONFIRMEDDELETEMESSAGEPARAM)) != null) {
		if (user == null) {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		} else if (user.getAutorizationLevel() >= EXECUTIVEMEMBER) {
		    final int messagenumber = Integer.parseInt(s);
		    forum.deleteMessage(messagenumber, out, user, request.getServletPath());
		    out.flush();
		    return;
		}
	    }
	    if ((s = request.getParameter(DELETEUSER)) != null) {
		if (user.getAutorizationLevel() >= VIPMEMBER) {
		    User currentuser = forum.mUserList.getUser(s);
		    if (currentuser != null) {
			if (currentuser.getAutorizationLevel() == ADMIN) {
			    forum.showWarningCannotChangeAdmin(out);
			    out.flush();
			    return;
			}
		    } else {
			// System.out.println("cannot find user "+s);
		    }
		    forum.mUserList.remove(s);
		    forum.displayUserList(out, request.getServletPath());
		    out.flush();
		    return;
		} else {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		}
	    }
	    if (request.getParameter(DISPLAYUSERLIST) != null) {
		if (user == null) {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		} else if (user.getAutorizationLevel() >= VIPMEMBER) {
		    forum.displayUserList(out, request.getServletPath());
		    out.flush();
		    return;
		} else {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		}
	    }
	    if ((s = request.getParameter(DISPLAYUSER)) != null) {
		if (user == null) {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		} else if (user.getAutorizationLevel() >= VIPMEMBER) {
		    forum.displayUser(s, out, request.getServletPath());
		    out.flush();
		    return;
		} else {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		}
	    }
	    if (((request.getParameter(ADDUSER) != null) || (request.getParameter(CHANGEUSER) != null))) {
		if (user == null) {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		} else if (user.getAutorizationLevel() >= VIPMEMBER) {
		    if ((request.getParameter(NEWUSERNAME) == null)
			|| (request.getParameter(NEWUSERPASSWORD) == null)) {
			forum.displayUserList(out, request.getServletPath());
			out.flush();
			return;
		    }
		    String name = HTMLUtil.makeStringHTMLSafe(request.getParameter(NEWUSERNAME).trim());
		    if (name.length() == 0) {
			forum.displayUserList(out, request.getServletPath());
			out.flush();
			return;
		    }
		    User currentuser = forum.mUserList.getUser(name);
		    if (currentuser != null) {
			if (currentuser.getAutorizationLevel() == ADMIN) {
			    forum.showWarningCannotChangeAdmin(out);
			    out.flush();
			    return;
			}
		    }
		    String password = request.getParameter(NEWUSERPASSWORD).trim();
		    String email = request.getParameter(NEWUSEREMAIL);
		    if (email != null) {
			email = email.trim();
		    }
		    int level = Integer.parseInt(request.getParameter(NEWUSERLEVEL).trim());
		    if (level >= ADMIN) {
			level = VIPMEMBER;
		    }
		    User u = new User(name, password, email, level);
		    forum.mUserList.add(u);
		    String oldname;
		    if ((oldname = request.getParameter(OLDUSERNAME)) != null) {
			if (!oldname.equals(name)) {
			    forum.mUserList.remove(oldname);
			}
		    }
		    forum.displayUserList(out, request.getServletPath());
		    out.flush();
		    return;
		} else {
		    forum.showWarningAutorizationRequired(out);
		    out.flush();
		    return;
		}
	    }
	    // as new message has been posted
	    if (request.getParameter(SUBMITMESSAGEPARAM) != null) {
		ServletUtil.processNewMessage(request, response, forum, out, user);
		out.flush();
		return;
	    } else if ((s = request.getParameter(SHOWPARAM)) != null) {
		// Display a particular message
		int k = Integer.parseInt(s);
		forum.showMessage(k, out, user, request.getServletPath());
		out.flush();
		return;
	    } else if ((s = request.getParameter(PAGEPARAM)) != null) {
		// display a particular page of messages (20 threads per page)
		int k = Integer.parseInt(s);
		forum.getPage(k, out, user, request.getServletPath());
		out.flush();
		return;
	    } else if ((s = request.getParameter(LASTMESSAGES)) != null) {
		// display the last k messages
		int k = Integer.parseInt(s);
		forum.getLastMessages(k, out, user, request.getServletPath());
		out.flush();
		return;
	    } 
	    else if ((s= request.getParameter(LOGOUTPARAM)) != null)
		{
		    // log the currently logged in user out
		    user= ServletUtil.processLoggingOut(request, response, user);
		    forum.getPage(0, out, user, request.getServletPath());
		    out.flush();
		    return;
		} // end if
	    else 
		{
		    // if in doubt, get the first page (default behaviour)
		    forum.getPage(0, out, user, request.getServletPath());
		    out.flush();
		    return;
		}
	    /*
	     *
	     */
	} catch (Exception ioe) {
	    ServletErrorHandling.printErrorMessage(request, response, ioe);
	}
    }



    /**
     *  
     *
     *@since    0.30
     */
    public void destroy() {
	ForumLocaleFactory.destroy();
	ForumFactory.destroy();
	UserListFactory.destroy();
	super.destroy();
    } // end method destroy

} // end class WebForumServlet


