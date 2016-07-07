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

/**
 *  A few useful methods (post/session management and all)
 *
 *@author     lemire
 *@author     Raj Bhaskar
 *@created    3 mars 2002
 */
public final class ServletUtil implements ParameterNames, AutorizationConstants {

    /**
     *  Gets the User attribute of the ServletUtil class
     *
     *@param  request               
     *@param  response              
     *@param  forum                 
     *@return                       The User value
     *@exception  ServletException  
     *@exception  IOException       
     *@since                        0.30
     */
    public static User getUser(HttpServletRequest request,
			       HttpServletResponse response, Forum forum)
	throws ServletException, IOException 
    {
	User user = null;
	// we process the login in case it is going on
	// in case it works, we forget about the rest!
	if (request.getParameter(LOGINPARAM) != null) {
	    user = processLoggingIn(request, response, forum);
	    if ((user == null) || (user.getAutorizationLevel() < 0)) {
		response.sendRedirect(forum.mFailedLoginURL);
		return (null);
		// we could try to proceed, but why?
		// if user tried to logon unsuccesfully, better
		// let him try again
	    }
	    return (user);
	}
	// sessions are more convenient, try to look for user info there first
	if (user == null) {// this if is not necessary
	    HttpSession session = request.getSession(true);
	    // on vérifie s'il y a déjà un user de défini
	    if (session.getValue(USERPARAM) != null) {
		try {
		    user = (User) session.getValue(USERPARAM);
		    if (user == null) {
					session.removeValue(USERPARAM);
		    } else if ((user.getAutorizationLevel() >= 0) && (!forum.mUserList.isInList(user))) {
					// if the user is not in the list, discard it! 
					session.removeValue(USERPARAM);
					user = null;
		    } else {
					// it looks like it will do
					return user;
				}
		} catch (ClassCastException cce) {
		    session.removeValue(USERPARAM);
		}
	    }
	}
	// if session fails us, try to look for cookie!
	Cookie[] cookie = request.getCookies();
	if (cookie == null)
	    return user;// abort, no cookies to check!
	for (int k = 0; k < cookie.length; ++k) {
	    if (cookie[k].getName().equals(USERPARAM)) {
				// possible suspect!
		try {
		    String[] data = User.getLoginAndPasswordFromCookieString(cookie[k].getValue());
		    user = forum.mUserList.getUser(data[0], data[1]);
		} catch (BadForumCookieException bfce) {
		    bfce.printStackTrace();
		}
	    }
	}
	return user;

    } // end method getUser()

	public static User subscribing( HttpServletRequest request,
			       HttpServletResponse response, Forum forum)
	throws ServletException, IOException 
 {
					// if the user doesn't fill out the form properly, you sent him/her
				// back to enter the info, this could be improved
		if ((request.getParameter(NEWUSERNAME) == null)
		    || (request.getParameter(NEWUSERPASSWORD) == null)
		    || (request.getParameter(NEWUSERPASSWORD2) == null)) {
		    response.sendRedirect(forum.mWelcomeURL);
		    return null;
		}
		String name = HTMLUtil.makeStringHTMLSafe(request.getParameter(NEWUSERNAME).trim());
		if (name.length() == 0) {// make sure the name is not blank!
		    response.sendRedirect(forum.mWelcomeURL);
		    return null;
		}
		if (forum.mUserList.isInList(name)) {// make sure the name is not already taken!
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    forum.showWarningNameInUse(name, out);
		    out.flush();
		    return null;
		}
		String password1 = request.getParameter(NEWUSERPASSWORD).trim();
		String password2 = request.getParameter(NEWUSERPASSWORD2).trim();
		if (!password1.equals(password2)) {
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    forum.showWarningPasswordsDontMatch(name, out);
		    out.flush();
		    return null;
		}
		String email = request.getParameter(NEWUSEREMAIL);
		if (email != null) {
		    email = email.trim();
		}
		int level = IDENTIFIEDGUEST;
		User user = new User(name, password1, email, level);
		ServletUtil.storeUser(request, response, user);
		forum.mUserList.add(user);
		return user;
	}

    /**
     *@param  request
     *@param  response
     *@param  forum
     *@param  out
     *@param  user
     *@exception  IOException
     *@since                   0.30
     */
    public static void processNewMessage(HttpServletRequest request, HttpServletResponse response, 
					 Forum forum, PrintWriter out, User user) throws IOException 
    {
	String subjectString = request.getParameter(SUBJECTPARAM);
	if (subjectString != null) {
	    subjectString = subjectString.trim();
	}
	String messageString = request.getParameter(MESSAGEPARAM);
	if (messageString != null) {
	    messageString = messageString.trim();
	}
	String authorString = request.getParameter(AUTHORPARAM);
	if (authorString != null) {
	    authorString = HTMLUtil.makeStringHTMLSafe(authorString.trim());
	}
	String emailString = request.getParameter(EMAILPARAM);
	if (emailString != null) {
	    emailString = emailString.trim();
	}
	/* Added by Raj to add proper support for URL strings */
	String optionalURLString= request.getParameter(OPTURLPARAM);
	if (optionalURLString != null)
	    optionalURLString= optionalURLString.trim();
	/* Added by Raj to add proper support for URL strings */
	String linkTitleString= request.getParameter(LINKTITLEPARAM);
	if (linkTitleString != null)
	    linkTitleString= linkTitleString.trim();
	
	// mise à jour de la session
	user = updateUserStatus(forum, request, response, authorString, emailString, user);
	if (user != null) {
	    authorString = user.getLogin();
	}
	// on traite maintenant les deux types de posts
	if (request.getParameter(MESSAGEIDPARAM) != null) {
	    final int messageNumber = Integer.parseInt(request.getParameter(MESSAGEIDPARAM));
	    forum.addReply(messageNumber, subjectString, messageString, authorString, 
			   emailString, optionalURLString, linkTitleString, user);
	    forum.showMessage(messageNumber, out, user, request.getServletPath());
	    out.flush();
	    return;
	}
	// warning: this may return null!
	forum.addMessage(subjectString, messageString, authorString, emailString, 
			 optionalURLString, linkTitleString, user);
	forum.getPage(0, out, user, request.getServletPath());
		out.flush();
    } // end method processNewMessage()


    /**
     *  Store cookies in browser for user identity
     *
     *@param  request
     *@param  response
     *@param  user
     *@since            0.35
     */
    public static void storeUser(HttpServletRequest request, HttpServletResponse response, User user) 
    {
	// session
	HttpSession session = request.getSession(true);
	session.putValue(USERPARAM, user);
	Cookie cookie = new Cookie(USERPARAM, user.getCookieString());
	cookie.setMaxAge(2147483647);
	response.addCookie(cookie);

    } // end method storeUser()

    /**
     *@param  request
     *@param  response
     *@param  forum
     *@return
     *@since            0.30
     */
    public static User processLoggingIn(HttpServletRequest request, HttpServletResponse response, 
					Forum forum) 
    {
	String login = request.getParameter(LOGINPARAM);
	if (login != null) {
	    login = login.trim();
	}
	String password = request.getParameter(PASSWORDPARAM);
	if (password != null) {
	    password = password.trim();
	}
	User user = forum.mUserList.getUser(login, password);
	if (user != null) {
	    storeUser(request, response, user);
	}
	return (user);
    }


    /**
     * Logs the current user out
     *
     * @param request
     * @param response
     * @param user
     * @return the logged out user (ie null)
     */
    public static User processLoggingOut(HttpServletRequest request, HttpServletResponse response, 
					 User user)
    {
	// remove from the session
	HttpSession session= request.getSession(true);
	session.removeValue(USERPARAM);

	// remove the cookie as well
	Cookie[] cookies= request.getCookies();
	if (cookies != null)
	    {
		for (int i=0; i<cookies.length; i++)
		    {
			if (cookies[i].getName().equals(USERPARAM))
			    {
				cookies[i].setMaxAge(0); // delete it now
				response.addCookie(cookies[i]);
			    }
		    } // end loop
	    } // end if

	return null; // always return null, since the user has been destroyed

    } // end method processingLoggingOut()


    /**
     *@param  forum
     *@param  request
     *@param  response
     *@param  AuthorString
     *@param  EmailString
     *@param  user
     *@return
     *@since                0.35
     */
    private static User updateUserStatus(Forum forum, HttpServletRequest request, 
					 HttpServletResponse response, String authorString, 
					 String emailString, User user) 
    {
	if (user == null) {
			if(forum.mUserList.isInList(authorString)) 
				authorString = authorString+ " (?)";// they try to pass off as someone on the list, but they haven't logged in!
	    user = new User(authorString, null, emailString, NORMAL);
	} else if (forum.mUserList.isInList(authorString)) {
	    user.setEmail(emailString);
	    forum.mUserList.save();
	} else {
	    user.setEmail(emailString);
	    user.setLogin(authorString);
	}
	storeUser(request, response, user);
	return (user);
    } // end method updateUserStatus

} // end class ServletUtil

