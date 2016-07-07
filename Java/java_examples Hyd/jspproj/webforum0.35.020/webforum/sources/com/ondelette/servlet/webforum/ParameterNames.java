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

/**
 *  HTML/HTTP parameter names
 *
 *@author     Daniel Lemire
 *@author     Raj Bhaskar
 *@created    March 12th 1999
 */
public interface ParameterNames 
{
    //
    // Main parameters
    //
    final String AUTHORPARAM = "Author";
    final String MESSAGEPARAM = "Message";
    final String SUBJECTPARAM = "Subject";
    final String EMAILPARAM = "Email";
    final String SUBMITMESSAGEPARAM = "SubmitMessage";
    final String SHOWPARAM = "_SHOW_";
    final String PAGEPARAM = "_PAGE_";
    final String LASTMESSAGES = "_LASTMESSAGES_";
    final String FORUMFILEPARAM = "_FORUMFILE_";
    final String MESSAGEIDPARAM = "_MESSAGEID_";
    final String LOGINPARAM = "_LOGIN_";
    final String PASSWORDPARAM = "_PASSWORD_";
    final String RESETPARAM = "_RESET_";
    final String DELETEMESSAGEPARAM = "_DELETEMESSAGE_";
    final String CONFIRMEDDELETEMESSAGEPARAM = "_CONFIRMEDDELETEMESSAGE_";
    final String USERPARAM = "USERID";
    final String OPTURLPARAM= "OptionalLinkURL"; // Added by Raj
    final String LINKTITLEPARAM= "LinkTitle";    // ditto
    final String USERFILEPARAM = "_USERFILE_";
    final String LOGOUTPARAM= "_LOGOUT_";
    //
    // JavaScript "Name"
    //
    final String SUBMITFORMNAME = "SUBMITFORM";
    //
    // UserList related
    //
    final String ADDUSER = "_ADDUSER_";
    final String CHANGEUSER = "_CHANGEUSER_";
    final String DELETEUSER = "_DELETEUSER_";
    final String SUBSCRIBEUSER = "_SUBSCRIBEUSER_";
    //
    final String NEWUSERNAME = "_NEWUSERNAME_";
    final String OLDUSERNAME = "_OLDUSERNAME_";
    final String NEWUSERPASSWORD = "_NEWUSERPASSWORD_";
    final String NEWUSERPASSWORD2 = "_NEWUSERPASSWORD2_";
    final String NEWUSEREMAIL = "_NEWUSEREMAIL_";
    final String NEWUSERLEVEL = "_NEWUSERLEVEL_";
    //
    final String DISPLAYUSERLIST = "_DISPLAYUSERLIST_";
    final String DISPLAYUSER = "_DISPLAYUSER_";

} // end interface ParameterNames

