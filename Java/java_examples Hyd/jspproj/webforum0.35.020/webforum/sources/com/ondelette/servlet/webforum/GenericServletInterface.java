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
 *  Used for optimized servlet/applet communication (protocol) 
 *
 *@author     Daniel Lemire
 *@created    March 12th 1999
 */
public interface GenericServletInterface {

	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static char GET = 'g';
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static char PUT = 'p';
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static char END = 'e';
	//
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static char PAGE = 'P';
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static char MESSAGE = 'M';


}

