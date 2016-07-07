/**
 *  WebForum (c) 2000 Daniel Lemire , This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation (version 2). This program is distributed in the hope
 *  that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package com.ondelette.servlet.webforum;

import java.io.*;
import java.util.*;

/**
 *  Useful HTML methods
 *
 * @author     Daniel Lemire
 * @created    March 12th 1999
 */
public final class HTMLUtil {

	/**
	 *  These HTML tags can be opened but must be closed. We don't expect browsers toString()
	 * do miracles. This will also block malicious users.
	 *
	 * @since 0.35
	 */
	public static String[] mAllowedHTML = {"b", "i",  "a", "ul", "em", "tt", "strong", "blockquote", "div", "pre"};
	public static String[] mAllowedClosingHTML = {"/b", "/i",  "/a", "/ul", "/em", "/tt", "/strong", "/blockquote", "/div", "/pre"};
	/*
	* These HTML tags are safe and don't have to be closed or can be closed without being open.
	* Basically, we don't attempt to make the HTML too proper. It is up to the browser to take
	* the garbage.
	 *
	 * @since 0.35
	 */
	public static String[] mSafeHTML = { "p",  "li", "ol", "br", "img"};
	public static String[] mSafeClosingHTML = { "/p",  "/li", "/ol", "/br"};

	/**
	 *  Private constructor
	 *
	 * @since    0.30
	 */
	private HTMLUtil() { }


	/**
	 *  Count the number of lines
	 *
	 * @param  s
	 * @return    The numberOfLines value
	 * @since     0.30
	 */
	public static int getNumberOfLines(String s) {
		if (s == null) {
			return (0);
		}
		if (s.length() < 2) {
			return (0);
		}
		int NumberOfLines = 0;
		for (int st = 0; st < s.length() - 1; ++st) {
			if (s.charAt(st) == '\r') {
				if (s.charAt(st + 1) != '\n') {
					++NumberOfLines;
				}
			}
			else if (s.charAt(st) == '\n') {
				++NumberOfLines;
			}
		}
		if ((s.charAt(s.length() - 1) == '\n') || (s.charAt(s.length() - 1) == '\r')) {
			++NumberOfLines;
		}
		return (NumberOfLines + 1);
	}


	/**
	 *  Read a string and use &lt;, &gt; as separators. This is actually used for XML parsing.
         * This specific method keeps reading until it finds an actual string so that
         * when applied to '<>><t' it would read t.
         * I'm not sure why it is needed, readNextString is probably better.
	 *
	 * @param  in
	 * @return
	 * @exception  IOException
	 * @since                   0.30
	 */
	public static String readString(InputStreamReader in) throws IOException {
		// StringWriter sw = new StringWriter();
		StringBuffer ans = new StringBuffer();
		while ((ans.length() == 0) && (in.ready())) {
			for (int r = in.read(); (r != '<') && (r != '>') && (r != -1); r = in.read()) {
				ans.append((char) r);
			}
		}
		return (ans.toString());
	}
	/**
	 *  Read a string and use &lt;, &gt; as separators. This is actually used for XML parsing.
         * This specific method returns the first string it finds
         * so that when applied to  '<>><t' it would return the empty string. This
         * one is useful for parsing user files!
	 *
	 * @param  in
	 * @return
	 * @exception  IOException
	 * @since                   0.35
	 */

	public static String readNextString(Reader in) throws IOException {
		// StringWriter sw = new StringWriter();
		StringBuffer ans = new StringBuffer();
		for (int r = in.read(); (r != '<') && (r != '>') && (r != -1); r = in.read()) {
				ans.append((char) r);
		}
		return (ans.toString());
	}
	

	/**
	 *  Replace \r\n or \n by &lt;BR /&gt;
	 *
	 * @param  s
	 * @return
	 * @since     0.30
	 */
	public static String replaceLinesWithParagraphs(String s) {
		if (s == null) {
			return (null);
		}
		if (s.length() < 2) {
			return (s);
		}
		StringBuffer sb = new StringBuffer();
		char c;
		for (int pos = 0; pos < s.length() - 1; ++pos) {
			switch (c = s.charAt(pos)) {
				case '\r':
					if (s.charAt(pos + 1) != '\n') {
						sb.append("<BR />");
						++pos;
					}
					break;
				case '\n':
					sb.append("<BR />");
					break;
				default:
					sb.append(c);
					break;
			}
			//fin du switch
		}
		//fin du for
		sb.append(s.charAt(s.length() - 1));
		return (sb.toString());
	}


	/**
	 *  Make the string HTML safe, removes &lt;,&gt;, " and replace with HTML entities
	 *
	 * @param  str
	 * @return
	 * @since       0.30
	 */
	public static String makeStringHTMLSafe(String str) {
		StringBuffer s = new StringBuffer();
		char c;
		for (int pos = 0; pos < str.length(); ++pos) {
			switch (c = str.charAt(pos)) {
				case '<':
					s.append("&lt;");
					break;
				case '>':
					s.append("&gt;");
					break;
				case '"':
					s.append("&quot;");
					break;
				default:
					s.append(c);
					break;
			}
		}
		return (s.toString());
	}

	public static String recoverHTMLOld(String str) {
		return str;
	}
	/**
	 *  Recover string from HTML by converting HTML entities to chars (&&lt; goes to &lt; and &&gt; goes to &gt; and &quot; goes to ") (Does that comment come out ok in HTML?) It will only allow some HTML tags by default. Can be extended.
	 *
	 * @param  str
	 * @return
	 * @since       0.30
	 */
	public static String recoverHTML(String str) {
		if (str == null) {
			return (null);
		}
		if (str.length() < 3) {
			return (str);
			// no processing required
		}
		StringBuffer outs = new StringBuffer();
		int pos;
		Stack OpenTags = new Stack();// this keep track of open tags
		mainloop:
		for (pos = 0; pos < str.length() - 3; ++pos) {
			if (str.startsWith("&lt;", pos)) {
				// this may be a new tag
				// we first check for opening tags
				// we allow opening new tags without closing them first!
				searchallowedhtml:
				for (int k = 0; k < mAllowedHTML.length; ++k) {
					if (mAllowedHTML[k].length() + pos + 4 >= str.length()) {
						continue searchallowedhtml;
					}
					int endmatch = mAllowedHTML[k].length() + pos + 4;
					if (!str.substring(pos + 4, endmatch).equalsIgnoreCase(mAllowedHTML[k])) {
						continue searchallowedhtml;
					}
					if (!Character.isWhitespace(str.charAt(endmatch)) && str.charAt(endmatch) != '&') {
						continue searchallowedhtml;
					}
					// find next end of bracket
					int nextend = str.indexOf("&gt;", pos + 4);
					int nextbegin = str.indexOf("&lt;", pos + 4);
					if (((nextbegin == -1 ) ||(nextend < nextbegin)) && (nextend != -1)) {
						/*while(!OpenTags.empty()) {
							// we have to close all the opened tags!
							outs.append("</");
							outs.append((String)OpenTags.pop());
							outs.append(">");
						}*/
						// we are now ok!
						OpenTags.push(mAllowedHTML[k]);
						outs.append('<');
						outs.append(mAllowedHTML[k]);// make sure it is lower case!
						outs.append(givebackQuotes(str.substring(endmatch, nextend)));
						outs.append('>');
						pos = nextend + 3;
						continue mainloop;// we found the thing! No need to look further
					}
				}
				searchclosingallowedhtml:
				for (int k = 0; k < mAllowedClosingHTML.length; ++k) {
					if (mAllowedClosingHTML[k].length() + pos + 4 >= str.length()) {
						continue searchclosingallowedhtml;
					}
					int endmatch = mAllowedClosingHTML[k].length() + pos + 4 ;
					//System.out.print("checking ["+str.substring(pos + 4, endmatch)+"] against "+mAllowedClosingHTML[k]);
					if (!str.substring(pos + 4, endmatch).equalsIgnoreCase(mAllowedClosingHTML[k])) {
						continue searchclosingallowedhtml;
					}
					//System.out.print("match!");
					if (!Character.isWhitespace(str.charAt(endmatch)) && str.charAt(endmatch) != '&') {
						continue searchclosingallowedhtml;
					}
					//System.out.print("match!!!");
					// find next end of bracket
					int nextend = str.indexOf("&gt;", pos + 4);
					int nextbegin = str.indexOf("&lt;", pos + 4);
					//System.out.print("nextend = "+nextend+" next begin = "+nextbegin);
					if (((nextbegin == -1 ) || (nextend < nextbegin)) && (nextend != -1)) {
						try {
						while(OpenTags.peek() != mAllowedHTML[k]) {
							// we have to close the opened tags!
							outs.append("</");
							outs.append((String)OpenTags.pop());
							outs.append(">");
						}
						// we are now ok!
						OpenTags.pop();
						outs.append('<');
						outs.append(mAllowedClosingHTML[k]);// make sure it is lower case!
						outs.append(givebackQuotes(str.substring(endmatch, nextend)));
						outs.append('>');

						} catch (EmptyStackException ese) {
							// we closed everything in sight, and no sign of the
							// this tag. superfluous closing tag?
							// we reject!
						}
						pos = nextend + 3;
						//System.out.print("completed");
						continue mainloop;// we found the thing! No need to look further
					}
				}
				searchsafehtml:
				for (int k = 0; k < mSafeHTML.length; ++k) {
					if (mSafeHTML[k].length() + pos + 4 >= str.length()) {
						continue searchsafehtml;
					}
					int endmatch = mSafeHTML[k].length() + pos + 4;
					if (!str.substring(pos + 4, endmatch).equalsIgnoreCase(mSafeHTML[k])) {
						continue searchsafehtml;
					}
					if (!Character.isWhitespace(str.charAt(endmatch)) && str.charAt(endmatch) != '&') {
						continue searchsafehtml;
					}
					// find next end of bracket
					int nextend = str.indexOf("&gt;", pos + 4);
					int nextbegin = str.indexOf("&lt;", pos + 4);
					if (((nextbegin == -1 ) ||(nextend < nextbegin)) && (nextend != -1)) {
						outs.append('<');
						outs.append(mSafeHTML[k]);// make sure it is lower case!
						outs.append(givebackQuotes(str.substring(endmatch, nextend)));
						outs.append('>');
						pos = nextend + 3;
						continue mainloop;// we found the thing! No need to look further
					}
				}
				searchclosingsafehtml:
				for (int k = 0; k < mSafeClosingHTML.length; ++k) {
					if (mSafeClosingHTML[k].length() + pos + 4 >= str.length()) {
						continue searchclosingsafehtml;
					}
					int endmatch = mSafeClosingHTML[k].length() + pos + 4;
					if (!str.substring(pos + 4, endmatch).equalsIgnoreCase(mSafeClosingHTML[k])) {
						continue searchclosingsafehtml;
					}
					if (!Character.isWhitespace(str.charAt(endmatch)) && str.charAt(endmatch) != '&') {
						continue searchclosingsafehtml;
					}
					// find next end of bracket
					int nextend = str.indexOf("&gt;", pos + 4);
					int nextbegin = str.indexOf("&lt;", pos + 4);
					if (((nextbegin == -1 ) ||(nextend < nextbegin)) && (nextend != -1)) {
						outs.append('<');
						outs.append(mSafeClosingHTML[k]);// make sure it is lower case!
						outs.append(givebackQuotes(str.substring(endmatch, nextend)));
						outs.append('>');
						pos = nextend + 3;
						continue mainloop;// we found the thing! No need to look further
					}
				}
				//System.out.print(" NOT INCLUDED '"+str.charAt(pos)+"'");
				// if we make it that fact, just dump
				outs.append(str.charAt(pos));// not inside a tag
			}
			else {
				//System.out.print("'"+str.charAt(pos)+"'");
				outs.append(str.charAt(pos));// not inside a tag
			}
		}
		// the last bit has no tags
		for (int k = pos; k < str.length(); k++) {
			outs.append(str.charAt(k));
		}
		// unsafe tags left open must be closed!!!
		while(!OpenTags.empty()) {
			// we have to close all the opened tags!
			outs.append("</");
			outs.append((String)OpenTags.pop());
			outs.append(">");
		}
		return (outs.toString());
	}


	/**
	 *  Used inside tags to revert back from &quot;
	 *
	 * @param  str
	 * @return
	 * @since       0.35
	 */
	protected static String givebackQuotes(String str) {
		if (str == null) {
			return (null);
		}
		if (str.length() < 3) {
			return (str);
			// no processing required
		}
		StringBuffer outs = new StringBuffer();
		int pos;
		for (pos = 0; pos < str.length() - 4; ++pos) {
			if (str.startsWith("&quot;", pos)) {
				outs.append('"');
				pos += 5;
				// careful, there is a ++pos
			}
			else {
				outs.append(str.charAt(pos));
			}
		}
		for (int k = pos; k < str.length(); k++) {
			outs.append(str.charAt(k));
		}
		return (outs.toString());
	}



	public static void main(String [] args) {
	// run a few tests.
		String message = new String(" <BR>A great web page with lots of publications and more!<div ALIGN=CENTER><a HREF=\"http://www.acm.caltech.edu/~demanet/\">http://www.acm.caltech.edu/~demanet/</a></DIV> <div></div> <div center=cda></div> <b></b> <strong>fsdfds <a>fdsf</a></strong> <div>f<a></a>sfdsfds</div> ");
		System.out.println();
		System.out.println(message);
		message=makeStringHTMLSafe(message);
		System.out.println();
		System.out.println(message);
		message=recoverHTML(message);
		System.out.println();
		System.out.println(message);

	}
}


