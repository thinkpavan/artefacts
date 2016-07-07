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
 *  Description of the Interface
 *
 *@author     lemire
 *@created    March 12th 1999
 */
public interface AutorizationConstants {

	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static int NORMAL = 0;
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static int IDENTIFIEDGUEST = 2;
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static int MEMBER = 32;
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static int EXECUTIVEMEMBER = 64;
	// permission d'effacer des messages
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static int VIPMEMBER = 128;
	// remise à zéro du forum, permission d'ajouter et de bannir des utilisateurs
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static int ADMIN = 256;
	// permanent
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static int ACCOUNTINACTIVE = -1;
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static int DELETED = -2;
	/**
	 *  Description of the Field
	 *
	 *@since    0.30
	 */
	public final static int ILLEGAL = -99;
}

