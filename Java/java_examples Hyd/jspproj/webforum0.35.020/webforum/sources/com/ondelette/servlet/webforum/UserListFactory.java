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

import java.util.*;
import java.io.*;

/**
 *  Description of the Class
 *
 *@author     Daniel Lemire
 *@created    March 12th 1999
 */
public class UserListFactory {

	static Hashtable mUserListTable = new Hashtable();
	static final String mUserListCharset = "ISO-8859-1";


	/**
	 *  Gets the userList attribute of the UserListFactory class
	 * 
	 *
	 *@param  file
	 *@return       The userList value
	 *@since        0.30
	 */
	public static UserList getUserList(File file) {
		if(mUserListTable == null) mUserListTable = new Hashtable();
		Object o = mUserListTable.get(file);
		if (o == null) {
			UserList userlist = new UserList(file,mUserListCharset);
			mUserListTable.put(file, userlist);
			return (userlist);
		}
		UserList userlist = (UserList) o;
		return userlist;
	}

	public static UserList removeUserList(File file) {
		return (UserList) mUserListTable.remove(file);
	}

	public static void destroy() {
                if(mUserListTable == null) return;
                Enumeration enum = mUserListTable.elements();
                while(enum.hasMoreElements()) {
                    ((UserList) enum.nextElement()).destroy();
                }
		mUserListTable = null;//new Hashtable();
	}

}


