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
 *  A factory for forums
 *
 *@author     Daniel Lemire
 *@created    March 12th 1999
 */
public class ForumFactory {
	private static Hashtable mForumList = new Hashtable();


	/**
	 *  Gets the forum attribute of the ForumFactory class
	 *
	 *@param  ForumFile
	 *@return                  The forum value
	 *@exception  IOException
	 *@since                   0.30
	 */
	public static Forum getForum(File ForumFile) throws IOException {
		if(mForumList == null) mForumList = new Hashtable();
		Forum forum;
		if ((forum = (Forum) mForumList.get(ForumFile)) == null) {
			forum = new Forum(ForumFile);
			mForumList.put(ForumFile, forum);
		}
		return (forum);
	}



	/**
	 *  
	 *
	 *@since    0.30
	 */
	public static void destroy() {
                if(mForumList == null) return;
		Enumeration enum = mForumList.elements();
		while (enum.hasMoreElements()) {
			Forum thisforum = (Forum) enum.nextElement();
			thisforum.destroy();
			thisforum = null;// free memory early
		}
		mForumList = null;//new Hashtable();
	}

}

