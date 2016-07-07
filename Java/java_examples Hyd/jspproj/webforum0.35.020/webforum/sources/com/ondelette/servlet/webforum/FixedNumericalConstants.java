/**
 *  WebForum (c) 2000 Daniel Lemire ,  
 *  This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation (version 2). This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program; if not, write to the
 *  Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package com.ondelette.servlet.webforum;

/**
 *  Description of the Interface
 *
 * @author     lemire
 * @created    March 12th 1999
 */
public interface FixedNumericalConstants {

	final int MAX_NUMBER_OF_MESSAGES_PER_FORUM = 65000;
	final int MAX_MESSAGE_SIZE_IN_BYTES = 64 * 1024;// limit the message to 64K
	final int NUMBER_OF_CHARS_TO_COMPARE = 100;
	final int DEFAULT_NUMBER_OF_RECENT_MESSAGES = 10;
	final int MAX_TEXTFIELD_SIZE = 128;// shouldn't be here at all!

}

