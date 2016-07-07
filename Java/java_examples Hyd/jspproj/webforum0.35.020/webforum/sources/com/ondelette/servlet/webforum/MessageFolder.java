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
 *         1.) In windows renameTo() gives an error on a file so I changed the logic to
 *         try to delete() it if that happens and then renameTo().
 *         2.) Also renamed tempindexfile so it's always the same so we can find it if
 *         we lose the real index file. Also put it's location in same directory as
 *         real index file.
 *         3.) In readHeaders(), because program could die between delete() and renameTo()
 *         I say if indexfile does not exist and tempindexfile does, make tempindexfile
 *         the real index file.
 *         4.) In testing, left of throws exception in saveHeaders(). Did not put it back.
 *         don't know if that matters.
 */

package com.ondelette.servlet.webforum;

import java.io.*;
import java.util.*;
import javax.servlet.*;

/**
 *  This class manages a bunch of posts and it handles saving and loading
 * them from disk
 *
 *@author     lemire
 *@created    March 12th 1999
 */

public final class MessageFolder implements AutorizationConstants {

	/**
	 *  Host forum
	 *
	 *@since    0.30
	 */
	protected Forum mForum;
	/**
	 *  Archive buffer (buffer for loading posts from disk)
	 *
	 *@since    0.30
	 */
	protected MessageArchiveBuffer mMAB;


	/**
	 *  Constructor for the MessageFolder object
	 *
	 *@param  forum
	 *@exception  IOException
	 *@since                   0.30
	 */
	public MessageFolder(Forum forum) throws IOException {
		mForum = forum;
		mMAB = new MessageArchiveBuffer(mForum.mMessageArchiveDirectory, mForum.mSaveDelay, mForum.mForumLocale.getCharsetEncoding());
	}


	/**
	 *  Gets the Message attribute of the MessageFolder object
	 *
	 *@param  ID
	 *@return                  The Message value
	 *@exception  IOException
	 *@since                   0.30
	 */
	public Message getMessage(int ID) throws IOException {
		return (mMAB.getMessage(new MessageReference(ID)));
	}


	/**
	 *  Gets the NumberOfPages attribute of the MessageFolder object
	 *
	 *@return    The NumberOfPages value
	 *@since     0.30
	 */
	public int getNumberOfPages() {
		int number = (int) Math.ceil(mMAB.mHeaders.size() / (double) mForum.mForumLocale.mSizeOfForumFolders);
		return (number);
	}


	/**
	 *  Gets the Page attribute of the MessageFolder object
	 *
	 *@param  pagenumber
	 *@return             The Page value
	 *@since              0.30
	 */
	public int[] getPage(int pagenumber) {
		if (mForum.mForumLocale.mSizeOfForumFolders * pagenumber > mMAB.mHeaders.size() - 1) {
			return (null);
		}
		int min = mForum.mForumLocale.mSizeOfForumFolders * (pagenumber + 1);
		min = min > mMAB.mHeaders.size() ? mMAB.mHeaders.size() : min;
		int begin = mForum.mForumLocale.mSizeOfForumFolders * pagenumber;
		int[] ans = new int[min - begin];
		for (int messagepointer = begin; messagepointer < min; messagepointer++) {
			MessageReference mr = (MessageReference) mMAB.mHeaders.elementAt(messagepointer);
			ans[messagepointer - begin] = mr.getID();
		}
		return (ans);
	}


	/**
	 *  Gets the CurrentMaxIndex attribute of the MessageFolder object
	 *
	 *@return    The CurrentMaxIndex value
	 *@since     0.30
	 */
	public int getCurrentMaxIndex() {
		return (mMAB.mCurrentMaxIndex);
	}


	/**
	 *  Delete a post
	 *
	 *@param  mr
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void deleteMessage(MessageReference mr) throws IOException {
		mMAB.deleteMessage(mr);
	}


	/**
	 *  Delete a post
	 *
	 *@param  mr
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void deleteMessage(int mr) throws IOException {
		mMAB.deleteMessage(new MessageReference(mr));
	}


	/**
	 *  Write usual summary of titles and dates
	 *
	 *@param  pagenumber
	 *@param  out
	 *@param  ServletPath
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void writePageSummaryHTML(int pagenumber, PrintWriter out, String ServletPath) throws IOException {
		//System.out.println( "mForum.mForumLocale.mSizeOfForumFolders =" + mForum.mForumLocale.mSizeOfForumFolders
      //                    + "   * pagenumber =" + pagenumber
      //                    + "   > mMAB.mHeaders.size() " + mMAB.mHeaders.size() );
		//out.print( "mForum.mForumLocale.mSizeOfForumFolders =" + mForum.mForumLocale.mSizeOfForumFolders
      //                    + "   * pagenumber =" + pagenumber
      //                    + "   > mMAB.mHeaders.size()" + mMAB.mHeaders.size() );
		if (mForum.mForumLocale.mSizeOfForumFolders * pagenumber > mMAB.mHeaders.size() - 1 ) {
			return;
		}
		int min = mForum.mForumLocale.mSizeOfForumFolders * (pagenumber + 1);
		//System.out.println( "1st min =" + min );
		//out.print( "1st min =" + min );
		min = min > mMAB.mHeaders.size() ? mMAB.mHeaders.size() : min;
		//System.out.println( "min =" + min );
		//out.print( "min =" + min );
		out.print("<UL CLASS=\"POSTS\">");
		for (int messagepointer = mForum.mForumLocale.mSizeOfForumFolders * pagenumber;
				messagepointer < min; messagepointer++) {
   		//System.out.println( "will print line for messagepointer =" + messagepointer + " and min =" + min );
			out.print("<LI CLASS=\"POSTS\">");
			MessageReference mr = (MessageReference) mMAB.mHeaders.elementAt(messagepointer);
			mForum.mForumLocale.printSummary(mr.getID(), mForum, out, ServletPath);
			out.print("</LI>");
		}
		out.print("</UL>");
	}


	/**
	 *  Something like last 10 messages
	 *
	 *@param  NumberOfMessages
	 *@param  out
	 *@param  ServletPath
	 *@exception  IOException
	 *@since                    0.30
	 */
	public void writeLastMessagesSummaryHTML(int NumberOfMessages, PrintWriter out, String ServletPath) throws IOException {
		Vector LastMessages = mMAB.lastMessages(NumberOfMessages);
		out.print("<UL CLASS=\"POSTS\">");
		int NumberPrinted = 0;
		ListIterator iter = LastMessages.listIterator(0);
		while (iter.hasNext() && NumberPrinted < NumberOfMessages) {
			out.print("<LI CLASS=\"POSTS\">");
			mForum.mForumLocale.printSummaryWithoutReplies(((MessageReference)iter.next()).getID(), mForum, out, ServletPath);
			out.print("</LI>");
		}
		out.print("</UL>");
	}


	/**
	 *  Add a message (post)
	 *
	 *@param  message          The feature to be added to the Message attribute
	 *@return
	 *@exception  IOException
	 *@since                   0.30
	 */
	public MessageReference addMessage(Message message) throws IOException {
		if (message.getInReplyTo() < 0) {
			if (mMAB.mHeaders.size() / mForum.mForumLocale.mSizeOfForumFolders >= mForum.mForumLocale.mNumberOfFolders + 1) {
				deleteLastPage();
			}
			return (mMAB.addMessage(message, true));
		}
		// we're adding a reply
		MessageReference parentmr = new MessageReference(message.getInReplyTo());
		Message parentmessage = parentmr.getMessage(this);
		MessageReference newmr = null;
		if(parentmessage != null) {
			synchronized (this) {// can't delete while we reply
				if(parentmessage.getAutorizationLevel() != DELETED) {
					newmr = mMAB.addMessage(message, false);
					parentmessage.addReply(newmr);
					mMAB.replaceMessage(parentmr, parentmessage);
					return (newmr);
				}
			}
		}
		// not much we can do here...
		// there was a post to something that just got deleted...
		// best scenario is to post it as a new post
		message.setInReplyTo(-1);
		addMessage(message);
		return (newmr);//return null in fact
	}


	/**
	 *  Call this when the servlet dies
	 *
	 *@since    0.30
	 */
	public void destroy() {
		mMAB.destroy();
	}


	/**
	 *  Delete the last few messages (there is a max. number of messages)
	 *
	 *@since    0.30
	 */
	private synchronized void deleteLastPage() {
		//
		// no archives at this point
		// we simply throw everything away!
		//
		final int pagenumber = getNumberOfPages() - 1;
		final int max = mMAB.mHeaders.size();
		final int begin = mForum.mForumLocale.mSizeOfForumFolders * pagenumber;
		for (int messagepointer = begin;
				messagepointer < max; messagepointer++) {
			MessageReference mr = (MessageReference) mMAB.mHeaders.elementAt(begin);
			try {
				mMAB.deleteMessage(mr);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}

/**
 *  Private classe -- manage low level functions
 *
 *@author     lemire
 *@created    3 mars 2002
 */
final class MessageArchiveBuffer implements Runnable, AutorizationConstants, FixedNumericalConstants {


	/**
	 *  Current max. post index
	 *
	 *@since    0.30
	 */
	protected int mCurrentMaxIndex;
	/**
	 *  The headers
	 *
	 *@since    0.30
	 */
	protected Vector mHeaders = new Vector();
	private boolean mIsShuttingDown = false;
	private File mDirectory;
	private Hashtable mBuffer = new Hashtable();
	private Hashtable mOldBuffer = new Hashtable();
	private Vector mDeleted = new Vector();
	private Vector mModified = new Vector();
	private Thread mMaintenanceThread;
	private long mDelay;
	private boolean mHeaderHasBeenChanged = false;
	protected Vector mMostRecent = new Vector();
	protected String mCharset;

	protected int mMaxBufferSize = 100;// this should limit memory usage to a reasonable amount

	/**
	 *  Constructor for the MessageArchiveBuffer object
	 *
	 *@param  dir
	 *@param  delay
	 *@since         0.30
	 */
	public MessageArchiveBuffer(File dir, long delay, String charset) {
		mDirectory = dir;
		mDelay = delay;
		try {
			readHeaders();
		} catch (IOException ioe) {
			mCurrentMaxIndex = 0;
			mHeaderHasBeenChanged = true;
			doMaintenance();
		}
		mMaintenanceThread = new Thread(this);
		mMaintenanceThread.setPriority(Thread.MIN_PRIORITY);
		mMaintenanceThread.start();
		mCharset = charset;
	}


	/**
	 *  Gets the Headers attribute of the MessageArchiveBuffer object
	 *
	 *@return    The Headers value
	 *@since     0.30
	 */
	public Enumeration getHeaders() {
		return (mHeaders.elements());
	}


	/**
	 *  Gets the Message attribute of the MessageArchiveBuffer object
	 *
	 *@param  mr
	 *@return     The Message value
	 *@since      0.30
	 */
	public Message getMessage(MessageReference mr) {
		Message message;
		if (mr.getID() < 0)  {
			return null;
		}
		final File messagefile = new File(mDirectory, mr.toString());
		if ((message = (Message) mBuffer.get(mr)) == null) {
			if ((message = (Message) mOldBuffer.get(mr)) == null) {
				try {
					InputStreamReader is = new InputStreamReader(new FileInputStream(messagefile),mCharset);

					try {
						message = Message.read(is);
					} finally {
						is.close();
					}
					if(message == null) 
						throw new IOException("File "+ messagefile.getAbsolutePath()+" could not be parsed!");
					// next we verify the message and we also buffer immediately the replies
					if(false) {
						Enumeration enum = message.getReplies();
						boolean modified = false;
						while (enum.hasMoreElements()) {
							final MessageReference repliesmr = (MessageReference) enum.nextElement();
							if( getMessage(repliesmr) == null) {
								message.removeReply(repliesmr);
								modified = true;
							}						
						}
						if(modified) replaceMessage(mr,message);
					}
					// end of the self-healing code
				} catch (IOException ioe) {
					if(mr.getID() < mCurrentMaxIndex) {//only warns verbosely when it is truely a problem
						System.err.println("[Error] IOException retrieving file "+
						 messagefile.getAbsolutePath()+" : "+ioe.getMessage()+".");
						System.err.println("[Error] Message ID "+mr.getID()+" was not found (IOException)");
					}
					if (mHeaders.removeElement(mr)) mHeaderHasBeenChanged = true;
					mMostRecent.remove(mr);
					return (null);
				}
				mBuffer.put(mr, message);
				if(mBuffer.size() > mMaxBufferSize) doMaintenance();
				return (message);
			} else {
				mOldBuffer.remove(mr);
				// free memory since we are moving it over to mBuffer
			}
			mBuffer.put(mr, message);
			if(mBuffer.size() > mMaxBufferSize) doMaintenance();
		}
		return (message);
	}


	/**
	 *  Get few posts
	 *
	 *@param  NumberOfMessages
	 *@return
	 *@since                    0.30
	 */
	public Vector lastMessages(final int NumberOfMessages) {
		if(mMostRecent.size() < NumberOfMessages) { // need to fill it up!
			int index = mCurrentMaxIndex - 1;
			int allocated = mMostRecent.size();
			if(allocated > 0) {
				index = ((MessageReference) mMostRecent.lastElement()).getID() - 1;
			}
			while ((allocated < NumberOfMessages) && (index >= 0)) {
				MessageReference mr = new MessageReference(index);
				Message m = getMessage(mr);
				if (m != null) {
					if (m.getAutorizationLevel() >= 0) {
						mMostRecent.addElement(mr);
						++allocated;
					}
				}
				index--;
			}
		}
		return mMostRecent;

		/*int[] messages = new int[NumberOfMessages];
		int allocated = 0;
		int index = mCurrentMaxIndex - 1;
		while ((allocated < messages.length) && (index >= 0)) {
			Message m = getMessage(new MessageReference(index));
			if (m != null) {
				if (m.getAutorizationLevel() >= 0) {
					messages[allocated++] = index;
				}
			}
			index--;
		}
		if (allocated < messages.length) {
			int[] messages2 = new int[allocated];
			System.arraycopy(messages, 0, messages2, 0, allocated);
			messages = messages2;
		}
		return (messages);*/
	}


	/**
	 *  Adds a feature to the Message attribute of the MessageArchiveBuffer object
	 *
	 *@param  message    The feature to be added to the Message attribute
	 *@param  newHeader  Header here means "primary post" (not a reply!)
	 *@return
	 *@since             0.30
	 */
	public synchronized MessageReference addMessage(Message message, boolean newHeader) {
		// next we check to see if this is a double post!
		if(mMostRecent.size() == 0) lastMessages(DEFAULT_NUMBER_OF_RECENT_MESSAGES);
		ListIterator iter = mMostRecent.listIterator(0);
		while(iter.hasNext()) {
			MessageReference recentmr = (MessageReference) iter.next();
			Message recentmessage = getMessage(recentmr);
			if(recentmessage != null) {
				if (recentmessage.fastCompare(message)) return null;
			} else { // found an error
				try {
					deleteMessage(recentmr);
				} catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		MessageReference mr = new MessageReference(mCurrentMaxIndex);
		// check that ID is not already taken
		while (getMessage(mr) != null) {// this should never be needed
			++mCurrentMaxIndex;
			mCurrentMaxIndex = mCurrentMaxIndex % MAX_NUMBER_OF_MESSAGES_PER_FORUM;
			mr = new MessageReference(mCurrentMaxIndex);
			System.err.println("[Warning] There might be a bug in addMessage(Message, boolean) or data corruption on disk.");
		}
		mBuffer.put(mr, message);
		if (newHeader) 	mHeaders.insertElementAt(mr, 0);
		mHeaderHasBeenChanged = true;
		mCurrentMaxIndex++;
		mCurrentMaxIndex = mCurrentMaxIndex % MAX_NUMBER_OF_MESSAGES_PER_FORUM;
		//if (mCurrentMaxIndex > MAX_NUMBER_OF_MESSAGES_PER_FORUM) {
		//	mCurrentMaxIndex = 0;
		//}
		mModified.addElement(mr);
		mMostRecent.insertElementAt(mr,0);		
		if(mBuffer.size() > mMaxBufferSize) doMaintenance();
		return (mr);
	}


	/**
	 *  Replace a message
	 *
	 *@param  mr
	 *@param  message
	 *@since           0.30
	 */
	public void replaceMessage(MessageReference mr, Message message) {
		mBuffer.put(mr, message);
		mModified.addElement(mr);
		if(mBuffer.size() > mMaxBufferSize) doMaintenance();
	}


	/**
	 *
	 *
	 *@param  mr
	 *@exception  IOException
	 *@since                   0.30
	 */
	public boolean deleteMessage(MessageReference mr) throws IOException {
		if(mDeleted.contains(mr)) return false; // do not recover message, already deleted 
		if (mHeaders.removeElement(mr)) mHeaderHasBeenChanged = true;
		mMostRecent.remove(mr);
		mDeleted.addElement(mr);
		Message message = getMessage(mr);
		if(message == null) {
			return false;// could not recover the message, cannot go further!
		}
		synchronized (this) {// while we delete a message, nobody can reply to it!!!
			Enumeration enum = message.getReplies();
			while (enum.hasMoreElements()) {
				final MessageReference repliesmr = (MessageReference) enum.nextElement();
				deleteMessage(repliesmr);
			}
			message.setAutorizationLevel(DELETED);
			if (message.getInReplyTo() != -1) {
				MessageReference parentmr = new MessageReference(message.getInReplyTo());
				Message parentmessage = getMessage(parentmr);
				if(parentmessage != null) {
					parentmessage.removeReply(mr);
					this.replaceMessage(parentmr, parentmessage);
				} 
			}

		}
		return true; // could recover the message
	}


	/**
	 *  Main processing method for the MessageArchiveBuffer object
	 *
	 *@since    0.30
	 */
	public void run() {
		Thread me = Thread.currentThread();
		while (! mIsShuttingDown ) {
			try {
				me.sleep(mDelay * 1000 * 60);
			} catch (InterruptedException ie) {
			}
			if(! mIsShuttingDown) doMaintenance();// let destroy save
		}
		mIsShuttingDown = false;// you are no longer shutting down!
	}


	/**
	 *
	 *
	 *@since    0.30
	 */
	public void destroy() {
		doMaintenance();
		mIsShuttingDown = true;
		mMaintenanceThread.interrupt();
		try {
			mMaintenanceThread.join();
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		mMaintenanceThread = null;
		// We try to make sure that maintance gets done, no matter what!
	}


	/**
	 *
	 *
	 *@exception  IOException
	 *@since                   0.30
	 */
	private void readHeaders() throws IOException {
		mDirectory.mkdirs();
		File indexfile = new File(mDirectory, "index.txt");
      File tempindexfile = new File(mDirectory, "index.tmp.txt");
	   //File tempindexfile = File.createTempFile("index","WebForum");
		// create the file if it doesn't exist
		if( ! indexfile.exists() && tempindexfile.exists() ) 
         {
			System.err.println("\nreadHeaders(): index file does not exist but tempindex file does!");
			System.err.println("Temp file is : "+tempindexfile.getAbsolutePath());
			System.err.println("Index file is : "+indexfile.getAbsolutePath());
			System.err.println("Use temp index file as real index file since it's missing." );

		   if( ! tempindexfile.renameTo( indexfile ) ) 
            {
   			System.err.println("readHeaders(): Couldn't copy temp index file to real index file, aborting!");
    		   System.err.println("Temp file is : "+tempindexfile.getAbsolutePath());
	   	   System.err.println("Index file is : "+indexfile.getAbsolutePath());
  			   return;
            }
         }

//    FileOutputStream fos = new FileOutputStream(indexfile.getCanonicalPath());
//    fos.close();
		// read the file
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
				new FileInputStream(indexfile)
				)
				);
		try {
	       String line = null;
			 try {
             line = br.readLine();
             //System.out.println( "1st idx line =" + line + "=" );
				 mCurrentMaxIndex = Integer.parseInt( line );
			} catch (NumberFormatException nfe) {
				 mCurrentMaxIndex = 0;
             System.out.println( "1st line is missing. maxIndex set to 0." );
			}
         line = br.readLine();
         System.out.println( "idx line =" + line + "=" );
			while ( line != null ) {
				try {
				   mHeaders.addElement(new MessageReference(Integer.parseInt(line)));
               //System.out.println( "mHeaders.size() =" + mHeaders.size() );
				}
            catch (NumberFormatException nfe) {
               System.out.println( "** Error converting line to an Integer probably." );
				}
            catch (Exception e) {
               System.out.println( "** error addElement to mHeaders =" + e.toString() );
				}
            line = br.readLine();
            //System.out.println( "idx line =" + line + "=" );
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			br.close();
		}
	}


	/**
	 * Save and delete messages on disk.
	 *
	 *@exception  IOException
	 *@since                   0.30
	 */
	private synchronized void doMaintenance() {
			//System.err.println("\nEntered doMaintenance()");
		try {
			// go through the messages
			saveModifiedMessages();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		try {
			deleteDeletedMessages();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		// save headers
		if (mHeaderHasBeenChanged) {
			try {
				saveHeaders();
			} catch (Exception ioe) {
				ioe.printStackTrace();
			}
		}
		// clean up memory
		mOldBuffer = mBuffer;
		mBuffer = new Hashtable();
	}


	/**
	 *
	 *
	 *@exception  IOException
	 *@since                   0.30
	 */
	private synchronized void saveHeaders() { // throws IOException {
		File indexfile = new File(mDirectory, "index.txt");
		PrintWriter pw = null;
		try {
			//System.err.println("\nEntered saveHeaders()");
		   File tempindexfile = new File(mDirectory, "index.tmp.txt");
 			pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(tempindexfile)));
			pw.println(mCurrentMaxIndex);
			Enumeration enum = getHeaders();
			while (enum.hasMoreElements()) {
				final MessageReference mr = (MessageReference) enum.nextElement();
				pw.println(mr.toString());
				pw.flush();
			}
			pw.close();
         /*
			if(! tempindexfile.renameTo(indexfile)) {
				System.err.println("Couldn't copy temp index file to real index file, aborting !");
				System.err.println("Temp file is : "+tempindexfile.getAbsolutePath());
				System.err.println("Index file is : "+indexfile.getAbsolutePath());
				return;
			}
         */
         /**/
			if( ! tempindexfile.renameTo( indexfile ) ) 
            {
				System.err.println("\nCouldn't rename temp index file to real index file!");
				System.err.println("Temp file is : "+tempindexfile.getAbsolutePath());
				System.err.println("Index file is : "+indexfile.getAbsolutePath());
				System.err.println("Try deleting real index file first." );

   			if( indexfile.exists() ) 
               {
   			   if( ! indexfile.delete() ) 
                  {
   	   			System.err.println("Couldn't delete real index file. Aborting!");
		   		   System.err.println("Temp file is : "+tempindexfile.getAbsolutePath());
			   	   System.err.println("Index file is : "+indexfile.getAbsolutePath());
				      return;
			         }
   			   if( ! tempindexfile.renameTo( indexfile ) ) 
                  {
   	   			System.err.println("After delete still could not rename temp index file to real index file, aborting!");
		   		   System.err.println("Temp file is : "+tempindexfile.getAbsolutePath());
			   	   System.err.println("Index file is : "+indexfile.getAbsolutePath());
   				   return;
                  }
   	         System.err.println("That worked." );
				   return;
               }
            else
               {
  	   			System.err.println("index file does not exist, aborting!");
	   		   System.err.println("Temp file is : "+tempindexfile.getAbsolutePath());
		   	   System.err.println("Index file is : "+indexfile.getAbsolutePath());
  				   return;
               }
   			}
         /**/
			mHeaderHasBeenChanged = false;
		} catch (IOException ioe) {
			System.err.println( "*** Error in saveHeaders(): " + ioe.toString() );
			ioe.printStackTrace();
		} catch (Exception e) {
			System.err.println( "*** Error in saveHeaders() 2: " + e.toString() );
			e.printStackTrace();
		} finally {
			if(pw != null) pw.close();
		}
	}


	/**
	 *  Save
	 *
	 *@exception  IOException
	 *@since                   0.30
	 */
	private void saveModifiedMessages() throws IOException {
		Vector OldModified;
		synchronized (this) {
			OldModified = (Vector) mModified.clone();
			mModified = new Vector();
		}
		Enumeration enum = OldModified.elements();
		while (enum.hasMoreElements()) {
			MessageReference mr = (MessageReference) enum.nextElement();
			Message message = getMessage(mr);
			if(message != null) {
				OutputStreamWriter bos = new OutputStreamWriter(
					new FileOutputStream(new File(mDirectory, mr.toString())), mCharset);
				try {
					message.write(bos);
					bos.flush();
				} finally {
					bos.close();
				}
			} else { // found an error, we delete
				System.err.println("[BUG] About to save a deleted message, yet message is not in memory!");
				deleteMessage(mr);
			}
		}
	}


	/**
	 *  Clean up!
	 *
	 *@exception  IOException
	 *@since                   0.30
	 */
	private void deleteDeletedMessages() throws IOException {
		Vector OldDeleted;
		synchronized (this) {
			OldDeleted = (Vector) mDeleted.clone();
			mDeleted = new Vector();
		}
		Enumeration enum = OldDeleted.elements();
		while (enum.hasMoreElements()) {
			MessageReference mr = (MessageReference) enum.nextElement();
			File file = new File(mDirectory, mr.toString());
			if (file.exists()) {
				if (!file.delete()) {
					System.err.println("ERROR: could not delete file " + file.getAbsolutePath());
					if (file.exists()) {
						System.err.println("Yet the file exists! Possible bug?");
						if (file.canWrite()) {
							System.err.println("Yet I can write to the file. Why can't I deleted it?");
						} else {
							System.err.println("File is not writeable. I will never be able to delete it!");
						}
						System.err.println("Aborting. Please delete the file " + file.getAbsolutePath() + " by hand.");
					} else {
						System.err.println("The file doesn't exist! Was probably deleted earlier. It is very unlikely however. Something is wrong.");
					}
				}
			} else {
				System.out.println("WARNING: The following file " + file.getAbsolutePath() + " was scheduled for deletion but it was already deleted. This is not a bug though.");
			}
		}
	}

}


