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
 *@author     lemire
 *@created    3 mars 2002
 */
public class User implements AutorizationConstants, Serializable {

	private final static String mMagicNumberCookie = "001";

	private int mAutorizationLevel = ILLEGAL;
	private String mLogin = null;
	private String mPassword = null;
	private String mEmail = null;

	//ID for crypto


	/*
	 *  private int mBonusPoints;
	 *  private String mCountry;
	 *  private String mPostalCode;
	 *  private String mStreetAddress;
	 *  private String mCity;
	 *  private String mAge;
	 *  private String mOccupation;
	 *  private String mTitle;
	 *  private Date mLastLogin;
	 *  private boolean mIsMale;
	 *  private String mUrl;
	 *  private String mImageUrl;
	 *  private String mDescription;
	 */
	/**
	 *  Constructor for the User object
	 *
	 *@param  login     
	 *@param  password  
	 *@param  email     
	 *@param  level     
	 *@since            0.30
	 */
	public User(String login, String password, String email, int level) {
		mAutorizationLevel = level;
		if (login != null) {
			mLogin = HTMLUtil.makeStringHTMLSafe(login.trim());
		}
		if (password != null) {
			mPassword = HTMLUtil.makeStringHTMLSafe(password.trim());
		}
		if (email != null) {
			mEmail = HTMLUtil.makeStringHTMLSafe(email.trim());
		}
	}


	/**
	 *  Constructor for the User object
	 *
	 *@since    0.30
	 */
	private User() { }



	/**
	 *  
	 *
	 *@param  in               
	 *@return                  
	 *@exception  IOException  
	 *@since                   0.30
	 */
	public static User read(InputStreamReader in) throws IOException {
		while (in.ready() ) {
			String buf = HTMLUtil.readString(in);
			if (buf.equals("USER")) {
				User user = null;
				user = parseUser(in);
				return (user);
			}
		}
		return (null);
	}


	/**
	 *@param  cookiestring
	 *@return                              The loginAndPasswordFromCookieString
	 *      value
	 *@exception  BadForumCookieException
	 *@since                               0.30
	 */
	protected static String[] getLoginAndPasswordFromCookieString(String cookiestring) throws BadForumCookieException {
		String[] answer = new String[2];
		String input = rot13(fromNumbers(cookiestring));
		java.util.StringTokenizer st = new java.util.StringTokenizer(input, "_");
		if (st.hasMoreElements()) {
			if (st.nextElement().equals(mMagicNumberCookie)) {
				if (st.hasMoreElements()) {
					try {
						int len = Integer.parseInt(st.nextToken());
						if (st.hasMoreElements()) {
							String data = st.nextToken();
							answer[0] = data.substring(0, len);
							answer[1] = data.substring(len, data.length());

						} else {
							throw new BadForumCookieException("Missing data login/parseUser : " + cookiestring);
						}
					} catch (NumberFormatException nfe) {
						nfe.printStackTrace();
						throw new BadForumCookieException("Bad Magic Number found : " + cookiestring);
					}
				}
			} else {
				throw new BadForumCookieException("Bad Magic Number found : " + cookiestring);
			}
		} else {
			throw new BadForumCookieException("No Magic Number found: " + cookiestring);
		}
		return answer;
	}


	/**
	 *  
	 *
	 *@param  in               
	 *@return                  
	 *@exception  IOException  
	 *@since                   0.30
	 */
	private static User parseUser(InputStreamReader in) throws IOException {
		User user = new User();
		String header;
		while (in.ready()) {
			header = HTMLUtil.readNextString(in);
			if (header.equals("/USER")) {
				break;
			}
			if (header.equals("LOGIN")) {
				user.mLogin = HTMLUtil.readNextString(in).trim();
				HTMLUtil.readNextString(in);
			} else if (header.equals("PASSWORD")) {
				user.mPassword = HTMLUtil.readNextString(in).trim();
				HTMLUtil.readNextString(in);
			} else if (header.equals("EMAIL")) {
				user.mEmail = HTMLUtil.readNextString(in).trim();
				HTMLUtil.readString(in);
			} else if (header.equals("LEVEL")) {
				user.mAutorizationLevel = Integer.parseInt(HTMLUtil.readNextString(in).trim());
				HTMLUtil.readNextString(in);
			}
		}
		if ((user.mPassword == null) || (user.mLogin == null) || (user.mAutorizationLevel == ILLEGAL)) {
			user = null;
		}
		return (user);
	}


	/*
	 *  for cookies
	 */
	/**
	 *  
	 *
	 *@param  input  
	 *@return        
	 *@since         0.30
	 */
	private static String toNumbers(String input) {
		if (input == null) {
			return null;
		}
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < input.length(); ++i) {
			char ichar = input.charAt(i);
			output.append('%' + Integer.toHexString((int) ichar));
		}
		return output.toString();
	}


	/*
	 *  for cookies
	 */
	/**
	 *  
	 *
	 *@param  input  
	 *@return        
	 *@since         0.30
	 */
	private static String fromNumbers(String input) {
		if (input == null) {
			return null;
		}
		StringBuffer output = new StringBuffer();
		java.util.StringTokenizer st = new java.util.StringTokenizer(input, "%");
		while (st.hasMoreTokens()) {
			try {
				output.append((char) Integer.parseInt(st.nextToken(), 16));
			} catch (NumberFormatException nfe) {
				System.err.println("Error while parsing cookie");
				System.err.println("from Numbers on : " + input);
				nfe.printStackTrace();
				// we try our best to recover from the error, hoping it was a fluke
			}
		}
		return output.toString();
	}


	/*
	 *  for cookies
	 */
	/**
	 *  
	 *
	 *@param  input  
	 *@return        
	 *@since         0.30
	 */
	private static String rot13(String input) {
		if (input == null) {
			return null;
		}
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < input.length(); ++i) {
			char ichar = input.charAt(i);
			// +13 modulo 26 A-Z
			if ((ichar >= 'A') & (ichar <= 'Z')) {
				ichar += 13;
				if (ichar > 'Z') {
					ichar -= 26;
				}
			}
			// +13 modulo 26 a-z
			if ((ichar >= 'a') & (ichar <= 'z')) {
				ichar += 13;
				if (ichar > 'z') {
					ichar -= 26;
				}
			}
			// don't modify otherwise
			output.append(ichar);
		}
		return output.toString();
	}


	/**
	 *  Sets the Login attribute of the User object
	 *
	 *@param  login  The new Login value
	 *@since         0.30
	 */
	public void setLogin(String login) {
		if (login != null) {
			mLogin = HTMLUtil.makeStringHTMLSafe(login.trim());
		}
	}


	/**
	 *  Sets the Email attribute of the User object
	 *
	 *@param  email  The new Email value
	 *@since         0.30
	 */
	public void setEmail(String email) {
		if (email != null) {
			mEmail = HTMLUtil.makeStringHTMLSafe(email.trim());
		}
	}


	/**
	 *  Gets the Login attribute of the User object
	 *
	 *@return    The Login value
	 *@since     0.30
	 */
	public String getLogin() {
		return (mLogin);
	}


	/**
	 *  Gets the Email attribute of the User object
	 *
	 *@return    The Email value
	 *@since     0.30
	 */
	public String getEmail() {
		return (mEmail);
	}


	/**
	 *  Gets the AutorizationLevel attribute of the User object
	 *
	 *@return    The AutorizationLevel value
	 *@since     0.30
	 */
	public int getAutorizationLevel() {
		return (mAutorizationLevel);
	}


	/**
	 *  
	 *
	 *@param  o  
	 *@return    
	 *@since     0.30
	 */
	public boolean equals(Object o) {
		if (o instanceof User) {
			User u = (User) o;
			return areEquals(u.mLogin,mLogin);// if you have the same name, you are the same person!
/*
			return ((areEquals(u.mEmail, mEmail))
					 && (areEquals(u.mLogin, mLogin))
					 && (areEquals(u.mPassword, mPassword))
					 && (u.mAutorizationLevel == mAutorizationLevel));*/
		}
		return (false);
	}


	/**
	 *  
	 *
	 *@param  password  
	 *@return           
	 *@since            0.30
	 */
	public boolean checkPassword(String password) {
		if (mPassword == null) {
			return (true);
		}
		if ((password == null) && (mPassword.length() == 0)) {
			return (true);
		}
		if (mPassword.equals(password)) {
			return (true);
		}
		if (mPassword.equals(password.trim())) {
			return (true);
		}
		return (false);
	}


	/**
	 *  
	 *
	 *@param  out              
	 *@exception  IOException  
	 *@since                   0.30
	 */
	public void write(OutputStreamWriter out) throws IOException {
		PrintWriter writer = new PrintWriter(out);
		writer.print("<USER>");
		if (mLogin != null) {
			writer.print("<LOGIN>");
			writer.print(mLogin);
			writer.print("</LOGIN>");
		}
		if (mPassword != null) {
			writer.print("<PASSWORD>");
			writer.print(mPassword);
			writer.print("</PASSWORD>");
		}
		if (mEmail != null) {
			writer.print("<EMAIL>");
			writer.print(mEmail);
			writer.print("</EMAIL>");
		}
		writer.print("<LEVEL>");
		writer.print(Integer.toString(mAutorizationLevel));
		writer.print("</LEVEL>");
		writer.print("</USER>");
		writer.flush();
	}


	/**
	 *  Gets the Password attribute of the User object
	 *
	 *@return    The Password value
	 *@since     0.30
	 */
	protected String getPassword() {
		return (mPassword);
	}


	/*
	 *  Totally unsafe encryption, but will do for must puposes.
	 */
	/**
	 *  Gets the CookieString attribute of the User object
	 *
	 *@return    The CookieString value
	 *@since     0.30
	 */
	protected String getCookieString() {
		// first 3 'letters' represent the version number, hence we can
		// change the encryption and still remain backward compatible with
		// older cookies
		return toNumbers(rot13(mMagicNumberCookie + '_' + Integer.toString(mLogin.length()) + '_' + mLogin + mPassword));
	}


	/**
	 *@param  s1
	 *@param  s2
	 *@return
	 *@since      0.30
	 */
	private boolean areEquals(String s1, String s2) {
		if (s1 == null) {
			if (s2 == null) {
				return (true);
			}
			return (false);
		}
		if (s2 == null) {
			return (false);
		}
		return (s1.equals(s2));
	}

	public int hashCode() {
		return mLogin.hashCode(); // store only one user with 
		// a given name in any hashmap
	}

}

