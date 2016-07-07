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

import java.io.*;

/**
 *  An index referring to a message
 *
 *@author     Daniel Lemire
 *@created    March 12th 1999
 */
public final class MessageReference implements Serializable, FixedNumericalConstants {

	private int mMessageID;


	/**
	 *  Constructor for the MessageReference object
	 *
	 *@param  id
	 *@since      0.30
	 */
	public MessageReference(int id) {
		mMessageID = id;
	}


	/**
	 *  Constructor for the MessageReference object
	 *
	 *@param  s
	 *@since     0.30
	 */
	public MessageReference(String s) {
		mMessageID = Integer.parseInt(s.trim());
	}


	/**
	 *  Constructor for the MessageReference object
	 *
	 *@param  s
	 *@since     0.30
	 */
	public MessageReference(StringBuffer s) {
		mMessageID = Integer.parseInt(new String(s));
	}


	/**
	 *  Gets the iD attribute of the MessageReference object
	 *
	 *@return    The iD value
	 *@since     0.30
	 */
	public int getID() {
		return (mMessageID);
	}


	/**
	 *  Gets the message attribute of the MessageReference object
	 *
	 *@param  mf
	 *@return                  The message value
	 *@exception  IOException
	 *@since                   0.30
	 */
	public Message getMessage(MessageFolder mf) throws IOException {
		return (mf.getMessage(mMessageID));
	}


	/**
	 *
	 *
	 *@return
	 *@since     0.30
	 */
	public String toString() {
		return (Integer.toString(mMessageID));
	}


	/**
	 *
	 *
	 *@param  out
	 *@since       0.30
	 */
	public void write(OutputStreamWriter out) {
		PrintWriter pw = new PrintWriter(out);
		pw.println("<MREF>" + toString() + "</MREF>");
		pw.flush();
	}


	/**
	 *
	 *
	 *@param  o
	 *@return
	 *@since     0.30
	 */
	public boolean equals(Object o) {
		if (o instanceof MessageReference) {
			MessageReference mr = (MessageReference) o;
			return (mr.mMessageID == mMessageID);
		}
		return (false);
	}


	/**
	 *
	 *
	 *@return
	 *@since     0.30
	 */
	public int hashCode() {
		return (mMessageID % MAX_NUMBER_OF_MESSAGES_PER_FORUM);
	}
}

