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
 *  A ForumLocal factory (i18n support)
 *
 *@author     Daniel Lemire
 *@created    March 12th 1999
 */
public class ForumLocaleFactory {

	static Hashtable mForumLocaleTable = new Hashtable();


	/**
	 *  Gets the forumLocale attribute of the ForumLocaleFactory class
	 *
	 *@param  file
	 *@return       The forumLocale value
	 *@since        0.30
	 */
	public static ForumLocale getForumLocale(File file) {
		if(mForumLocaleTable == null) mForumLocaleTable = new Hashtable();
		Object o = mForumLocaleTable.get(file);
		if (o == null) {
			ForumLocale forumlocale = new ForumLocale(file);
			mForumLocaleTable.put(file, forumlocale);
			return (forumlocale);
		}
		ForumLocale forumlocale = (ForumLocale) o;
		return (forumlocale);
	}


	/**
	 *  
	 *
	 *@since    0.30
	 */
	public static void destroy() {
                // no need to save the data here
		mForumLocaleTable = null;// new Hashtable();
	}
}

