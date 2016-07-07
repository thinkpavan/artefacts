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
 *         1.) In windows java renameTo() gives an error on a file so I changed the logic to
 *         try to delete() it if that happens and then renameTo().
 *         2.) Also renamed tempuserlist so it's always the same so we can find it if
 *         we lose the real mUserListFile file. Also put it's location in same directory as
 *         real mUserListFile file.
 *         3.) In write(), because program could die between delete() and renameTo()
 *         I say if userlist does not exist and tempuserlist does, make tempuserlist
 *         the real mUserListFile file. Put this change in Forum.java
 *         4.) In user list file constructor is was not closing file so I did that.
 */
package com.ondelette.servlet.webforum;

import java.io.*;
import java.util.*;
import java.lang.Runnable;

/**
 *  Description of the Class
 *
 *@author     Daniel Lemire
 *@created    March 12th 1999
 */
public final class UserList implements Runnable {
	private Hashtable mLoginTable = new Hashtable();
	private boolean mHasChanged = false;
	private File mUserListFile;
	private Thread mSaveThread;
	private long mDelay;
	protected String mCharset;
	private boolean mIsShuttingDown = false;

	
	public UserList(File file,String charset) {
		this(file,60*60*1000,charset); // default is a 1 hour delay between saves
	}

	/**
	 *  Constructor for the UserList object
	 *
	 *@param  file
	 *@param  delay
	 *@since         0.30
	 */
	public UserList(File file, long delay, String charset) {
		mDelay = delay;
		mCharset = charset;
		try {
			synchronized (this) {
				InputStreamReader bis = new InputStreamReader(new FileInputStream(file),mCharset);
				while (bis.ready()) {
					User user = User.read(bis);
					if (user != null) {
						mLoginTable.put(user.getLogin(), user);
					}
				}
            bis.close();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			//nothing to do here
		}
		mUserListFile = file;
		mSaveThread = new Thread(this);
		mSaveThread.setPriority(Thread.MIN_PRIORITY);
		mSaveThread.start();
	}


	/**
	 *  Gets the users attribute of the UserList object
	 *
	 *@return    The users value
	 *@since     0.30
	 */
	public Enumeration getUsers() {
		return (mLoginTable.elements());
	}


	/**
	 *  Gets the user attribute of the UserList object and check password.
	 * Return null if password check fails.
	 *@param  login
	 *@param  password
	 *@return           The user value
	 *@since            0.30
	 */
	public User getUser(String login, String password) {
		if (login == null) {
			return (null);
		}
		Object o;
		if ((o = mLoginTable.get(login)) == null) {
			if ((o = mLoginTable.get(HTMLUtil.makeStringHTMLSafe(login))) == null) {
				return (null);
			}
		}
		final User user = (User) o;
		if (user.checkPassword(password)) {
			return (user);
		}
		return (null);
	}


	/**
	 *  Gets the user attribute of the UserList object
	 *
	 *@param  login
	 *@return        The user value
	 *@since         0.30
	 */
	public User getUser(String login) {
		if (login == null) {
			return (null);
		}
		Object o;
		if ((o = mLoginTable.get(login)) == null) {
			if ((o = mLoginTable.get(HTMLUtil.makeStringHTMLSafe(login))) == null) {
				return (null);
			}
		}
		return ((User) o);
	}


	/**
	 * Check to see if the user is in the list
	 *
	 *@param  user
	 *@return       The inList value
	 *@since        0.30
	 */
	public boolean isInList(User user) {
		if (user == null) {
			return (false);
		}
		return isInList(user.getLogin());
//		return (mLoginTable.contains(user));
	}


	/**
	 *  Gets the inList attribute of the UserList object
	 *
	 *@param  login
	 *@return        The inList value
	 *@since         0.30
	 */
	public boolean isInList(String login) {
		if (login == null) {
			return (false);
		}
		if (mLoginTable.containsKey(login)) {
			return (true);
		}
		return (mLoginTable.containsKey(HTMLUtil.makeStringHTMLSafe(login)));
	}


	/**
	 *  
	 *
	 *@param  user
	 *@since        0.30
	 */
	public void add(User user) {
		if (user == null) {
			return;
		}
		mHasChanged = true;
        	mLoginTable.put(user.getLogin(), user);
	}


	/**
	 *  
	 *
	 *@param  login
	 *@since         0.30
	 */
	public void remove(String login) {
		if (login == null) {
			return;
		}
		mHasChanged = true;
        	if (mLoginTable.remove(login) == null) {
			mLoginTable.remove(HTMLUtil.makeStringHTMLSafe(login));
		}
	}


	/**
	 *  
	 *
	 *@since    0.30
	 */
	public void save() {
		mHasChanged = true;
	}


	/**
	 *  Main processing method for the UserList object
	 *
	 *@since    0.30
	 */
	public void run() {
		Thread me = Thread.currentThread();
		while (! mIsShuttingDown ) {
			try {
				mSaveThread.sleep(mDelay);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			try {
				if(! mIsShuttingDown) write();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		mIsShuttingDown = false;// you are shut down now!
	}



	/**
	 *  
	 *
	 *@since    0.30
	 */
	public void destroy() {
		try {
			write();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		mIsShuttingDown = true;
		mSaveThread.interrupt();
		try {
			mSaveThread.join();
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		mSaveThread = null;
	}



	/**
	 *  
	 *
	 *@exception  IOException
	 *@since                   0.30
	 */
	private void write()   throws IOException 
      {
		//System.err.println("\nEntered write() for UserList.");
		synchronized (this) {
			/* here things could go badly if someone were to change this
			when the servlet was being killed.*/
			if (mHasChanged) {
				//File tempuserfile = File.createTempFile(mUserListFile.getName(),"WebForum");
   		   File tempuserfile = new File( mUserListFile.getAbsolutePath() + ".tmp" );
            //System.err.println( "User list file: " + mUserListFile.getAbsolutePath() + ".tmp" );
				OutputStreamWriter bos = null;
				try {
					bos = new OutputStreamWriter(new FileOutputStream(tempuserfile), mCharset);
					Enumeration enum = mLoginTable.elements();
					while (enum.hasMoreElements()) {
						User u = (User) enum.nextElement();
						u.write(bos);
						bos.write('\r');
						//Windows!
						bos.write('\n');
						bos.flush();
					}
					bos.close();

					if( ! tempuserfile.renameTo( mUserListFile ) ) 
                  {
						System.err.println("\nCouldn't copy over real user list file.");
						System.err.println("Temp user list file: "+tempuserfile.getAbsolutePath());
						System.err.println("User list file: "+mUserListFile.getAbsolutePath());
      				System.err.println("Try deleting real user list file first." );

         			if( mUserListFile.exists() ) 
                     {
         	   		if( ! mUserListFile.delete() ) 
                        {
	   			         System.err.println( "Couldn't delete real user list file. Aborting!" );
   						   System.err.println( "User list file: " + mUserListFile.getAbsolutePath() );
				            return;
			               }
   			         if( ! tempuserfile.renameTo( mUserListFile ) ) 
                        {
   	   			      System.err.println("After delete Couldn't rename temp user list file to real user list file, aborting!");
   						   System.err.println("Temp user list file: "+tempuserfile.getAbsolutePath());
   						   System.err.println("User list file: "+mUserListFile.getAbsolutePath());
   				         return;
                        }
		   	         System.err.println("That worked." );
						   return;
                     }
                  else
                     {
  	   			      System.err.println("index file does not exist, aborting!");
  						   System.err.println("Temp user list file: "+tempuserfile.getAbsolutePath());
  						   System.err.println("User list file: "+mUserListFile.getAbsolutePath());
  				         return;
                     }
					   }
					mHasChanged = false;
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} finally {
					if(bos != null) bos.close();
				}
			}
		}

	}

}
