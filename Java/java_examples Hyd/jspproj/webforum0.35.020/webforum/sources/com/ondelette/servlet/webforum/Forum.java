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
 *
 *  Notes: enhancement - Oct 2003 - Stan Towianski
 *         Goes with change in UserList.java
 *         3.) In write(), because program could die between delete() and renameTo()
 *         I say if userlist does not exist and tempuserlist does, make tempuserlist
 *         the real mUserListFile file.
 */
package com.ondelette.servlet.webforum;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import java.net.*;
import com.ondelette.servlet.*;

/**
 *  A forum object containing posts and folder of posts
 *
 *@author     Daniel Lemire
 *@created    March 12th 1999
 */
public final class Forum {

	/**
	 *  The title to be displayed in HTML
	 *
	 *@since    0.30
	 */
	protected String mForumTitle;
	/**
	 *  A subtitle to be displayed in HTML
	 *
	 *@since    0.30
	 */
	protected String mForumSubTitle;

	/**
	* If non null, will parse the content of this URL
	* and append the content of body before the actual
	* output of the servlet.
	*/
	protected URL mPrefixURL;
	
	/**
	* If non null, will parse the content of this URL
	* and append the content of body after the actual
	* output of the servlet.
	*/
	protected URL mSuffixURL;

	/**
	 *  The object which determines how things are displayed (including language, charset encoding...)
	 *
	 *@since    0.30
	 */
	protected ForumLocale mForumLocale;
	/**
	 *  How often messages are written to disk.
	 *
	 *@since    0.30
	 */
	protected long mSaveDelay;
	/**
	 *  Threshold on user level for post privilege (default is 0).
	 *
	 *@since    0.30
	 */
	protected int mPostPrivilege = 0;
	/**
	 *  MessageFolder object, maintains a database of sorts.
	 *
	 *@since    0.30
	 */
	protected MessageFolder mMessageFolder;
	/**
	 *  List of all users registered with this forum.
	 *
	 *@since    0.30
	 */
	protected UserList mUserList;
	/**
	 *  Directory where the database is stored.
	 *
	 *@since    0.30
	 */
	protected File mMessageArchiveDirectory;
	/**
	 *  File containing the configuration parameters of this forum.
	 *
	 *@since    0.30
	 */
	protected File mConfigFile;
	/**
	 *  File containing the parameter of the ForumLocale object.
	 *
	 *@since    0.30
	 */
	protected File mForumLocaleFile;
	/**
	 *  File containing the list of users.
	 *
	 *@since    0.30
	 */
	protected File mUserListFile;
	/**
	 *  Threshold to be able to view the forum.
	 *
	 *@since    0.30
	 */
	protected int mAuthorizationLevel = 0;
	/**
	 *  A string used in the footer of the HTML pages.
	 *
	 *@since    0.30
	 */
	protected String mForumFooter;
	/**
	 *  A URL to the login page.
	 *
	 *@since    0.30
	 */
	protected String mWelcomeURL;

	protected String mFailedLoginURL;
	/**
	 *  URL pointing to the CSS file.
	 *
	 *@since    0.30
	 */
	protected String mCSSURL;


	/**
	 *  Constructor for the Forum object
	 *
	 *@param  forumconfigfile
	 *@exception  IOException
	 *@since                   0.30
	 */
	public Forum(File forumconfigfile) throws IOException {
		if(!forumconfigfile.exists())
			throw new IllegalArgumentException("Config file "+ forumconfigfile.getAbsolutePath()+" could not be found!");
		Properties p = new Properties();
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(forumconfigfile));
		p.load(fis);
		fis.close();
		mConfigFile = forumconfigfile;
		mMessageArchiveDirectory = new File(p.getProperty("MessageArchiveDirectory"));
		// if cannot parse, must fail
		mForumLocaleFile = new File(p.getProperty("ForumLocaleFile"));
		if(!mForumLocaleFile.exists())
			throw new IllegalArgumentException("Locale config file "+ mForumLocaleFile.getAbsolutePath()+" could not be found!");
		//System.out.println( "Locale config file =" + mForumLocaleFile.getAbsolutePath() + "=");
		// if cannot parse, must fail
      
		mUserListFile = new File(p.getProperty("UserListFile"));
   	File tempuserfile = new File( mUserListFile.getAbsolutePath() + ".tmp" );
      //System.err.println( "Temp user list file: " + mUserListFile.getAbsolutePath() + ".tmp" );
		// create the file if it doesn't exist
		if( ! mUserListFile.exists() && tempuserfile.exists() ) 
         {
			System.err.println("\nForum(): user list file does not exist but temp user list file does!");
			System.err.println("Temp user list file is : "+tempuserfile.getAbsolutePath());
			System.err.println("User list file is : "+mUserListFile.getAbsolutePath());
			System.err.println("Use temp user list file as real user list file since it's missing." );

		   if( ! tempuserfile.renameTo( mUserListFile ) ) 
            {
   			System.err.println("Forum(): Couldn't copy temp user file to real user file, aborting!");
    		   System.err.println("Temp user list file is : "+tempuserfile.getAbsolutePath());
	   	   System.err.println("User list file is : "+mUserListFile.getAbsolutePath());
   			throw new IllegalArgumentException("User List config file "+ mUserListFile.getAbsolutePath()+" could not be found!");
            }
         }

		if(!mUserListFile.exists())
			throw new IllegalArgumentException("User List config file "+ mUserListFile.getAbsolutePath()+" could not be found!");
         
		// if cannot parse, must fail
		try {
			mSaveDelay = Long.parseLong(p.getProperty("SaveDelay"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mCSSURL = p.getProperty("CSSURL");
		if (mCSSURL == null) {
			mCSSURL = "";
		}
		mForumTitle = p.getProperty("ForumTitle");
		if (mForumTitle == null) {
			mForumTitle = "";
		}
		mForumSubTitle = p.getProperty("ForumSubTitle");
		if (mForumSubTitle == null) {
			mForumSubTitle = "";
		}
		try {
			mAuthorizationLevel = Integer.parseInt(p.getProperty("AuthorizationLevel"));
		} catch (Exception e) {
		}
		mForumFooter = p.getProperty("ForumFooter");
		if (mForumFooter == null) {
			mForumFooter = "";
		}
		mWelcomeURL = p.getProperty("WelcomeURL");
		if (mWelcomeURL == null) {
			mWelcomeURL = "";
		}
		mFailedLoginURL = p.getProperty("FailedLoginURL");
		if (mFailedLoginURL == null) {
			mFailedLoginURL = mWelcomeURL;
		}
		String prefix = p.getProperty("PrefixURL") ;
		try {
			if(prefix != null) 
				mPrefixURL = new URL ( prefix.trim() );
		} catch (MalformedURLException murle) {
			System.err.println("Is this a URL: '"+prefix+"'");
			murle.printStackTrace();
		}
		String suffix = p.getProperty("SuffixURL") ;
		try {
			if(suffix != null)
				mSuffixURL = new URL ( suffix.trim() );
		} catch (MalformedURLException murle) {
			System.err.println("Is this a URL: '"+suffix+"'");
			murle.printStackTrace();
		}
		try {
			mPostPrivilege = Integer.parseInt(p.getProperty("PostPrivilege"));
		} catch (Exception e) {
		}
		//on tolère cette erreur
		// initialisation des objets
		mForumLocale = ForumLocaleFactory.getForumLocale(mForumLocaleFile);
		mUserList = UserListFactory.getUserList(mUserListFile);
		mMessageFolder = new MessageFolder(this);
	}


	/**
	 *  Gets the page attribute of the Forum object
	 *
	 *@param  k
	 *@param  out
	 *@param  user
	 *@param  servletPath
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void getPage(int k, PrintWriter out, User user, String servletPath) throws IOException {
		mForumLocale.printForumHeader(this, out);
		printBodyFrom(mPrefixURL,out);
		mForumLocale.printForumTitle(this, out);
		mForumLocale.printMenu(this, out, k, user, servletPath);
		mMessageFolder.writePageSummaryHTML(k, out, servletPath);
		mForumLocale.printMenu(this, out, k, user, servletPath);
		if (mPostPrivilege > 0) {
			if (user != null) {
				if (user.getAutorizationLevel() >= mPostPrivilege) {
					mForumLocale.printPostForm(this, out, user, servletPath);
				}
			}
		} else {
			mForumLocale.printPostForm(this, out, user, servletPath);
		}
		mForumLocale.printButtons(this, out, user, servletPath);
		out.print(mForumFooter);
		printBodyFrom(mSuffixURL,out);
		ServletCopyright.printFooter(out);
	}


	/**
	 *  Gets the lastMessages attribute of the Forum object
	 *
	 *@param  k
	 *@param  out
	 *@param  user
	 *@param  servletPath
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void getLastMessages(int k, PrintWriter out, User user, String servletPath) throws IOException {
		mForumLocale.printForumHeader(this, out);
		printBodyFrom(mPrefixURL,out);
		mForumLocale.printForumTitle(this, out);
		mForumLocale.printMenu(this, out, -1, user, servletPath);
		//-1 parce qu'on n'est pas sur une page en particulier
		mForumLocale.printBackToForum(out, this, servletPath);
		mMessageFolder.writeLastMessagesSummaryHTML(k, out, servletPath);
		mForumLocale.printMenu(this, out, -1, user, servletPath);
		if (mPostPrivilege > 0) {
			if (user != null) {
				if (user.getAutorizationLevel() >= mPostPrivilege) {
					mForumLocale.printPostForm(this, out, user, servletPath);
				}
			}
		} else {
			mForumLocale.printPostForm(this, out, user, servletPath);
		}
		mForumLocale.printButtons(this, out, user, servletPath);
		out.print(mForumFooter);
		printBodyFrom(mSuffixURL,out);
		ServletCopyright.printFooter(out);
	}


	/*
	 *  convenience method
	 */
	/**
	 *  Adds a feature to the Message attribute of the Forum object
	 *
	 *@param  subjectString    The subject of this message
	 *@param  messageString    The actual message itself
	 *@param  suthorString     The author of this message
	 *@param  rmailString      The email address of the author of this message
     *@param  optionalURLString A URL that was given along with the message
     *@param  linkTitleString   The title of the link
	 *@param  user             The feature to be added to the Message attribute
	 *@return an index to the message that has just been added
	 *@exception  IOException
	 *@since                   0.30
	 */
	public MessageReference addMessage(String subjectString, String messageString, String authorString, 
					   String emailString, String optionalURLString, String linkTitleString,
					   User user) throws IOException {
		Message message = new Message(authorString, emailString, subjectString, messageString,
					      optionalURLString, linkTitleString);
		if (user != null) {
			message.setAutorizationLevel(user.getAutorizationLevel());
		}
		return (addMessage(message));
	}


	/**
	 *  Adds a feature to the Message attribute of the Forum object
	 *
	 *@param  message          The feature to be added to the Message attribute
	 *@return
	 *@exception  IOException
	 *@since                   0.30
	 */
	public MessageReference addMessage(Message message) throws IOException {
		return (mMessageFolder.addMessage(message));
	}


	/*
	 *  convenience method
	 */
	/**
	 *  Adds a feature to the Reply attribute of the Forum object
	 *
	 *@param k                 The ID of this message
	 *@param subjectString     The subject of this message
	 *@param messageString     The body of this message
	 *@param authorString      The name of the author of this message
	 *@param emailString       The email address of the author of this message
	 *@param optionalURLString The URL of a link that goes at the bottom of the message
	 *@param linkTitleString   The title of the link to be added
	 *@param user              The user posting the message
	 *@return                  A reference to the message just added
	 *@exception  IOException
	 *@since                   0.30
	 */
	public MessageReference addReply(int k, String subjectString, String messageString, String authorString, 
					 String emailString, String optionalURLString,
					 String linkTitleString, User user) throws IOException {
		Message message = new Message(authorString, emailString, subjectString, messageString,
					      optionalURLString, linkTitleString);
		message.setInReplyTo(k);
		if (user != null) {
			message.setAutorizationLevel(user.getAutorizationLevel());
		}
		return (addMessage(message));
	}


	/**
	 *  
	 *
	 *@param  k
	 *@param  out
	 *@param  user
	 *@param  servletPath
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void showMessage(int k, PrintWriter out, User user, String servletPath) throws IOException {
		Message message = mMessageFolder.getMessage(k);
		if(message != null)
			if(message.getMessage() != null) 
				mForumLocale.printForumHeader(this,message.getSubject(),HTMLUtil.makeStringHTMLSafe(message.getMessage()),out);
			else 
				mForumLocale.printForumHeader(this,message.getSubject(),null,out);
		else
			mForumLocale.printForumHeader(this,out);
		printBodyFrom(mPrefixURL,out);
		mForumLocale.printForumTitle(this, out);
		mForumLocale.printMenu(this, out, -1, user, servletPath);
		mForumLocale.printInFull(k, this, out, user, servletPath);
		if (mPostPrivilege > 0) {
			if (user != null) {
				if (user.getAutorizationLevel() >= mPostPrivilege) {
					mForumLocale.printReplyForm(k, this, out, user, servletPath);
				}
			}
		} else {
			mForumLocale.printReplyForm(k, this, out, user, servletPath);
		}
		mForumLocale.printButtons(this, out, user, servletPath);
		out.print(mForumFooter);
		printBodyFrom(mSuffixURL,out);
		ServletCopyright.printFooter(out);
	}


	/**
	 *  
	 *
	 *@param  k
	 *@param  out
	 *@param  user
	 *@param  servletPath
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void deleteMessage(int k, PrintWriter out, User user, String servletPath) throws IOException {
		mMessageFolder.deleteMessage(k);
		getPage(0, out, user, servletPath);
	}


	/**
	 *  
	 *
	 *@param  k
	 *@param  out
	 *@param  user
	 *@param  servletPath
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void askForConfirmationOnDeletingMessage(int k, PrintWriter out, User user, String servletPath) throws IOException {
		mForumLocale.printForumHeader(this, out);
		printBodyFrom(mPrefixURL,out);
		mForumLocale.printForumTitle(this, out);
		mForumLocale.printDeleteConfirmation(k, this, out, user, servletPath);
		out.print(mForumFooter);
		printBodyFrom(mSuffixURL,out);
		ServletCopyright.printFooter(out);
	}


	/*
	 *  Cette méthode pose un problème de sécurité.
	 *  public synchronized void saveConfig() throws IOException {
	 *  Properties p  = new Properties();
	 *  p.put("MessageArchiveDirectory",this.mMessageArchiveDirectory.toString());
	 *  p.put("ForumLocaleFile",this.mForumLocaleFile.toString());
	 *  p.put("UserListFile",this.mUserListFile.toString());
	 *  p.put("SaveDelay",Long.toString(this.mSaveDelay));
	 *  p.put("ForumTitle",mForumTitle);
	 *  p.put("AuthorizationLevel",Integer.toString(mAuthorizationLevel));
	 *  p.put("ServletURL",mServletURL);
	 *  p.put("CSSURL",mCSSURL);
	 *  p.put("WelcomeURL",mWelcomeURL);
	 *  BufferedOutputStream fis = new BufferedOutputStream(new FileOutputStream(mConfigFile));
	 *  p.save(fis,"Configuration file for forum "+mForumTitle+" in file "+mConfigFile.toString());
	 *  fis.close();
	 *  }
	 */
	/**
	 *  
	 *
	 *@since    0.30
	 */
	public void destroy() {
		mMessageFolder.destroy();
	}


	/**
	 *  
	 *
	 *@param  name
	 *@param  out
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void showWarningNameInUse(String name, PrintWriter out) throws IOException {
		mForumLocale.printForumHeader(this, out);
		printBodyFrom(mPrefixURL,out);
		mForumLocale.printForumTitle(this, out);
		mForumLocale.showWarningNameInUse(name, out, this);
		out.print(mForumFooter);
		printBodyFrom(mSuffixURL,out);
		ServletCopyright.printFooter(out);
	}


	/**
	 *  
	 *
	 *@param  name
	 *@param  out
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void showWarningPasswordsDontMatch(String name, PrintWriter out) throws IOException {
		mForumLocale.printForumHeader(this, out);
		printBodyFrom(mPrefixURL,out);
	  mForumLocale.printForumTitle(this, out);
		mForumLocale.showWarningNameInUse(name, out, this);
		out.print(mForumFooter);
		printBodyFrom(mSuffixURL,out);
		ServletCopyright.printFooter(out);
	}


	/**
	 *  
	 *
	 *@param  out
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void showWarningAutorizationRequired(PrintWriter out) throws IOException {
		mForumLocale.printForumHeader(this, out);
		printBodyFrom(mPrefixURL,out);
		mForumLocale.printForumTitle(this, out);
		mForumLocale.showWarningAutorizationRequired(out, this);
		out.print(mForumFooter);
		printBodyFrom(mSuffixURL,out);
		ServletCopyright.printFooter(out);
	}


	/**
	 *  
	 *
	 *@param  out
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void showWarningCannotChangeAdmin(PrintWriter out) throws IOException {
		mForumLocale.printForumHeader(this, out);
		printBodyFrom(mPrefixURL,out);
		mForumLocale.printForumTitle(this, out);
		mForumLocale.showWarningCannotChangeAdmin(out, this);
		out.print(mForumFooter);
		printBodyFrom(mSuffixURL,out);
		ServletCopyright.printFooter(out);
	}


	/**
	 *  
	 *
	 *@param  out
	 *@param  servletPath
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void displayUserList(PrintWriter out, String servletPath) throws IOException {
		mForumLocale.printForumHeader(this, out);
		printBodyFrom(mPrefixURL,out);
		mForumLocale.printForumTitle(this, out);
		mForumLocale.printUserList(this, out, servletPath);
		out.print(mForumFooter);
		printBodyFrom(mSuffixURL,out);
		ServletCopyright.printFooter(out);
	}


	/**
	 *  
	 *
	 *@param  name
	 *@param  out
	 *@param  servletPath
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void displayUser(String name, PrintWriter out, String servletPath) throws IOException {
		mForumLocale.printForumHeader(this, out);
		printBodyFrom(mPrefixURL,out);
		mForumLocale.printForumTitle(this, out);
		mForumLocale.printUser(this, name, out, servletPath);
		out.print(mForumFooter);
		printBodyFrom(mSuffixURL,out);
		ServletCopyright.printFooter(out);
	}
	
	/**
	* This code makes the assumption that lines are not too long
	* and that a string put to lowercase has the same length. Should work fine for
	* most HTML out there.
	*/
	public static void printBodyFrom(URL url, PrintWriter out) {
		if(url == null) return;// obviously
		try {
			URLConnection con = url.openConnection();
			con.setDoInput(true);
			InputStream is = con.getInputStream();
			String ContentType = con.getContentType();
			String ContentEncoding = con.getContentEncoding();
			// determines whether we expect to find <body>
			boolean grabbody = true;
			//System.out.println(ContentType);
			if(ContentType != null) {
				if(!ContentType.equals("text/html")) {
					grabbody = false;
				}
			} else grabbody = false;
			InputStreamReader isr = null;
			if(ContentEncoding != null)
				isr = new InputStreamReader(is,ContentEncoding);
			else 
				isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			boolean MustWrite = ! grabbody;
			String line;
			boolean LookForClosure = false;// whether body tag is finished or not
			while((line = br.readLine())!=null) {
				//System.out.println(line);
				//System.out.println("MustWrite: "+ MustWrite+" grabbody="+grabbody+" LookForClosure:"+LookForClosure);
				if(MustWrite) {
					if(grabbody) {// more complicated if I must monitor of body tags
						String lowercaseline = line.toLowerCase();
						if(LookForClosure) {// <body tag not finished (multiline)
							int beginindex = line.indexOf(">");
							if(beginindex == -1) continue;
							LookForClosure = false;
							if(beginindex + 1 < line.length()) {
								int endindex = lowercaseline.indexOf("</body>");
								if(endindex == -1 )
									out.println(line.substring(beginindex + 1,line.length()));
								else if( beginindex + 1 < endindex) 
									out.println(line.substring(beginindex + 1,endindex));
							}
							continue;
						}
						// next, I will look for the </body> tag!
						int index = lowercaseline.indexOf("</body>");
						if(index == -1) {
				//			System.out.println("Made it:"+line);
							out.println(line);
							continue;
						}
						out.println(line.substring(0,index));
						break;
					}
					out.println(line);
					continue;
				}
				String lowercaseline = line.toLowerCase();
				int index = lowercaseline.indexOf("<body");
				if(index == -1)
					continue;
				MustWrite = true;
				int beginindex = lowercaseline.indexOf(">",index);
				if(beginindex == -1) {
					LookForClosure = true;
					continue;
				}
				if(beginindex + 1 < line.length()) {
					int endindex = lowercaseline.indexOf("</body>");
					if (endindex == -1 )
						out.println(line.substring(beginindex + 1,line.length()));
					else if( beginindex + 1 < endindex)
						out.println(line.substring(beginindex + 1,endindex));
				}
				
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	public static void main(String[] arg) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		printBodyFrom(new URL(arg[0]), pw);
		pw.flush();
	}
}
