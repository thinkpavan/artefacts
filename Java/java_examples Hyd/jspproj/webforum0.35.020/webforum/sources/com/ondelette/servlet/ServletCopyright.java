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
package com.ondelette.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 *  Description of the Class
 *
 *@author     lemire
 *@created    March 12th 1999
 */
public final class ServletCopyright {

	private final static String mCopyrigthURL = "http://webforum.sourceforge.net/ ";
	private final static String mProductName = "WebForum";
	private final static String mHomePage = "http://webforum.sourceforge.net/";
	private final static String mCopyrightString = "&copy; 2000-2003 WebForum project (GPL) ";
	private final static String mVersion = "version 0.35.019 (2003-10-06) ";


	/**
	 *  Gets the copyright attribute of the ServletCopyright class
	 *
	 *@return    The copyright string
	 *@since 0.30
	 */
	public static String getCopyright() {
		return (mCopyrightString);
	}


	/**
	 *  This footer gives copyright info in HTML.
	 *
	 *@param  out              
	 *@exception  IOException  
	 *@since 0.30
	 */
	public static void printFooter(PrintWriter out) throws IOException {
		out.print("<HR>");

		out.print("<P CLASS=\"FOOTER\"><A HREF=\"");
		out.print(mHomePage);
		out.print("\">");
		out.print(mProductName);
		out.print("</A> ");
		out.print(mVersion);
		out.println("</P>");

		out.print("<P CLASS=\"FOOTER\"><A HREF=\"");
		out.print(mCopyrigthURL);
		out.print("\">");
		out.print(mCopyrightString);
		out.print("</A> ");
		out.println("</P>");
		//out.println("<P CLASS=\"FOOTER\"><a href=\"http://validator.w3.org/check/referer\"><img src=\"http://www.w3.org/Icons/valid-html401\" alt=\"Valid HTML 4.01!\" height=\"31\" width=\"88\" /></a> <a href=\"http://jigsaw.w3.org/css-validator\"><img src=\"http://jigsaw.w3.org/css-validator/images/vcss.gif\" alt=\"Valid CSS!\" width=\"88\" height=\"31\" /></a></p>");
		out.println("</BODY></HTML>");
	}

}


