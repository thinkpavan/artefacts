/**
 *  WebForum (c) 2000 Daniel Lemire ,  
 *  This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation (version 2). This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program; if not, write to the
 *  Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package com.ondelette.servlet.webforum;
/**
 *  An exception thrown when you can't parse a cookie
 *
 * @author     lemire
 * @created    March 3th 2002
 * @since 0.35
 */
public class BadForumCookieException extends Exception {
	/**
	 *  Constructor for the BadForumCookieException object
	 *
	 * @param  message  
	 */
	public BadForumCookieException(String message) {
		super(message);
	}
}

