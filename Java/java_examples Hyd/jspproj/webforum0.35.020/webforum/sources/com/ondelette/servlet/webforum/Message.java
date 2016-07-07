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
import java.net.*;
import java.io.*;
import java.text.*;
import javax.servlet.*;

/**
 *  Message (post) object
 *
 *@author     Daniel Lemire
 *@author     Rajnish Bhaskar
 *@created    March 12th 1999
 */
public final class Message implements AutorizationConstants, Serializable, FixedNumericalConstants {

	// the next line might seem like a mistake but it is not...
	// we use US English as the default for writing to disk...
	// saved message should not depend on the server locale...
	private static DateFormat mDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, 
									       DateFormat.FULL, 
									       new Locale("en", "US"));
	private static DateFormat mDateFormatSecondary = DateFormat.getDateInstance(DateFormat.FULL, 
										    new Locale("en", "US"));

	private Date mPostedDate;
	private String mSubjectString;
	private String mMessageString;
	private String mAuthorString;
	private String mAuthorEmailString;
    private String mOptionalURLString;
    private String mUrlLinkString= null;
	private int mInReplyToID = -1;
	private int mAutorizationLevel = NORMAL;
	private Vector mReplies = new Vector();
	private int mNumberOfLines = 0;
	private int mNumberOfBytes = 0;


    /**
     *  Constructor for the Message object
     *
     *@param  authorString
     *@param  authorEmail
     *@param  subjectString
     *@param  messageString
     *@param  optionalURLString
     *@param  urlLinkString
     *@since                 0.30
     */
    public Message(String authorString, String authorEmail, String subjectString, String messageString,
		   String optionalURLString, String urlLinkString) 
    {
	if (authorString != null) {
	    mAuthorString = HTMLUtil.makeStringHTMLSafe(authorString.trim());
	    if (mAuthorString.length() == 0) {
		mAuthorString = null;
	    }
	}
	if (subjectString != null) {
	    mSubjectString = HTMLUtil.makeStringHTMLSafe(subjectString.trim());
	    if (mSubjectString.length() == 0) {
		mSubjectString = null;
	    }
	}
	if (authorEmail != null) {
	    mAuthorEmailString = HTMLUtil.makeStringHTMLSafe(authorEmail.trim());
	    if (mAuthorEmailString.length() == 0) {
		mAuthorEmailString = null;
	    }
	}
	/* Added by Raj to add proper support for URL strings */
	if (optionalURLString != null)
	    {
		mOptionalURLString= HTMLUtil.makeStringHTMLSafe(optionalURLString.trim());
		if (mOptionalURLString.length() == 0)
		    mOptionalURLString= null;
		else if (mOptionalURLString.equalsIgnoreCase("http://"))
		    mOptionalURLString= null;
	    } // end if
	if (urlLinkString != null)
	    {
		mUrlLinkString= HTMLUtil.makeStringHTMLSafe(urlLinkString.trim());
		if (mUrlLinkString.length() == 0)
		    mUrlLinkString= null;
	    } // end if

	// don't need to base the Date on 'time' since the constructor for Date does
	// the same thing
	// long time = System.currentTimeMillis();
	mPostedDate = new Date(); 
	mAutorizationLevel = NORMAL;
	setMessage(messageString);
    }


	/**
	 *  Constructor for the Message object
	 *
	 *@since    0.30
	 */
	private Message() { }


	/**
	 *  Read a message for XML-like file
	 *
	 *@param  in
	 *@return
	 *@exception  IOException
	 *@since                   0.30
	 */
	public static Message read(InputStreamReader in)
			 throws IOException {
		while (in.ready() ) {
			String buf = HTMLUtil.readString(in);
			if (buf.equals("MESSAGE")) {
				Message message = null;
				message = parseMessage(in);
				return (message);
			}
		}
		return (null);
	}



	/**
	 *  Read a message in XML-like from input stream
	 *
	 *@param  in
	 *@return
	 *@exception  IOException
	 *@since                   0.30
	 */
	private static Message parseMessage(InputStreamReader in) throws IOException {
		Message message = new Message();
		String header;
		while (in.ready()) {
			header = HTMLUtil.readString(in);

			if (header.equals("/MESSAGE")) {
				break;
			}
			if (header.equals("POSTED")) {
				String DateString = HTMLUtil.readString(in).trim();
				try {
					message.mPostedDate = mDateFormat.parse(DateString);
				} catch (ParseException pe) {
					try {
						message.mPostedDate = mDateFormatSecondary.parse(DateString);
					} catch (ParseException pe2) {
						message.mPostedDate = new Date();
					}

				}
				HTMLUtil.readString(in);
			} else if (header.equals("REPLYTOID")) {
				message.mInReplyToID = Integer.parseInt(HTMLUtil.readString(in).trim());
				HTMLUtil.readString(in);
			} else if (header.equals("SUBJECT")) {
				message.mSubjectString = HTMLUtil.readString(in);
				HTMLUtil.readString(in);
			} else if (header.equals("CONTENT")) {
				message.mMessageString = HTMLUtil.recoverHTML(HTMLUtil.readString(in).trim());
				HTMLUtil.readString(in);
			} else if (header.equals("AUTHOR")) {
				message.mAuthorString = HTMLUtil.readString(in).trim();
				HTMLUtil.readString(in);
			} else if (header.equals("EMAIL")) {
				message.mAuthorEmailString = HTMLUtil.readString(in).trim();
				HTMLUtil.readString(in);
			} else if (header.equals("MREF")) {
				message.mReplies.addElement(new MessageReference(HTMLUtil.readString(in)));
				HTMLUtil.readString(in);
			} else if (header.equals("AUTHORIZATION")) {
				message.mAutorizationLevel = Integer.parseInt(HTMLUtil.readString(in).trim());
				HTMLUtil.readString(in);
			}
			/* Added by Raj to add proper support for URL strings */
			else if (header.equals("OPTIONALURL"))
			    {
				message.mOptionalURLString= HTMLUtil.readString(in).trim();
				HTMLUtil.readString(in);
			    } // end if
			else if (header.equals("URLLINKTITLE"))
			    {
				message.mUrlLinkString= HTMLUtil.readString(in).trim();
				HTMLUtil.readString(in);
			    } // end if
		}
		if (message.mPostedDate == null) {
			message.mPostedDate = new Date();
		}
		// in case of corruption
		return (message);
	}


	/**
	 *  Sets the inReplyTo attribute of the Message object
	 *
	 *@param  ID  The new inReplyTo value
	 *@since      0.30
	 */
	public void setInReplyTo(int ID) {
		mInReplyToID = ID;
	}


	/**
	 *  Sets the date attribute of the Message object
	 *
	 *@param  date  The new date value
	 *@since        0.30
	 */
	public void setDate(Date date) {
		mPostedDate = date;
	}


	/**
	 *  Sets the autorizationLevel attribute of the Message object
	 *
	 *@param  level  The new autorizationLevel value
	 *@since         0.30
	 */
	public void setAutorizationLevel(int level) {
		mAutorizationLevel = level;
	}


	/**
	 *  Sets the subject attribute of the Message object
	 *
	 *@param  Subject  The new subject value
	 *@since           0.30
	 */
	public void setSubject(String subject) {
		mSubjectString = HTMLUtil.makeStringHTMLSafe(subject.trim());
		if (mSubjectString.length() == 0) {
			mSubjectString = null;
		}
	}


	/**
	 *  Sets the message attribute of the Message object
	 *
	 *@param  message  The new message value
	 *@since           0.30
	 */
	public void setMessage(String message) {
		mMessageString = HTMLUtil.recoverHTML(HTMLUtil.makeStringHTMLSafe(message.trim()));
		if (mMessageString.length() == 0) {
			mMessageString = null;
		}
		if (mMessageString != null) {
			mNumberOfBytes = message.length();
			if(mNumberOfBytes > MAX_MESSAGE_SIZE_IN_BYTES) {
				mMessageString = mMessageString.substring(0,MAX_MESSAGE_SIZE_IN_BYTES - 10 );// the -10 is arbitrary
				mNumberOfBytes = message.length();
			}
		} else {
			mNumberOfBytes = 0;
		}
		mNumberOfLines = HTMLUtil.getNumberOfLines(message);
	}


	/**
	 *  Sets the author attribute of the Message object
	 *
	 *@param  Author  The new author value
	 *@since          0.30
	 */
	public void setAuthor(String author) {
		mAuthorString = HTMLUtil.makeStringHTMLSafe(author.trim());
		if (mAuthorString.length() == 0) {
			mAuthorString = null;
		}
	}


	/**
	 *  Sets the authorEmail attribute of the Message object
	 *
	 *@param  AuthorEmail  The new authorEmail value
	 *@since               0.30
	 */
	public void setAuthorEmail(String authorEmail) {
		mAuthorEmailString = HTMLUtil.makeStringHTMLSafe(authorEmail.trim());
		if (mAuthorEmailString.length() == 0) {
			mAuthorEmailString = null;
		}
	}


    /**
     *  Sets the optional URL (if any)
     *
     *@param url the URL to set
     *@since     0.35
     */
    public void setOptionalURL(String url) {
	mOptionalURLString= HTMLUtil.makeStringHTMLSafe(url.trim());
	if (mOptionalURLString.length() == 0)
	    mOptionalURLString= null;
    } // end method setOptionalURL()


    /**
     *  Sets the title for the optional URL (if any)
     *
     *@param title the title for the URL
     *@since     0.35
     */
    public void setURLLinkTitle(String title) {
	mUrlLinkString= HTMLUtil.makeStringHTMLSafe(title.trim());
	if (mUrlLinkString.length() == 0)
	    mUrlLinkString= null;
    } // end method setURLLinkTitle()


 	/**
	 *  Gets the replies attribute of the Message object
	 *
	 *@return    The replies value
	 *@since     0.30
	 */
	public Enumeration getReplies() {
		return (mReplies.elements());
	}


	/**
	 *  Gets the inReplyTo attribute of the Message object
	 *
	 *@return    The inReplyTo value
	 *@since     0.30
	 */
	public int getInReplyTo() {
		return (mInReplyToID);
	}


	/**
	 *  Gets the date attribute of the Message object
	 *
	 *@return    The date value
	 *@since     0.30
	 */
	public Date getDate() {
		return (mPostedDate);
	}


	/**
	 *  Gets the autorizationLevel attribute of the Message object
	 *
	 *@return    The autorizationLevel value
	 *@since     0.30
	 */
	public int getAutorizationLevel() {
		return (mAutorizationLevel);
	}


	/**
	 *  Gets the numberOfLines attribute of the Message object
	 *
	 *@return    The numberOfLines value
	 *@since     0.30
	 */
	public int getNumberOfLines() {
		return (mNumberOfLines);
	}


	/**
	 *  Gets the numberOfBytes attribute of the Message object
	 *
	 *@return    The numberOfBytes value
	 *@since     0.30
	 */
	public int getNumberOfBytes() {
		return (mNumberOfBytes);
	}


	/**
	 *  Gets the subject attribute of the Message object
	 *
	 *@return    The subject value
	 *@since     0.30
	 */
	public String getSubject() {
		return (mSubjectString);
	}


	/**
	 *  Gets the message attribute of the Message object
	 *
	 *@return    The message value
	 *@since     0.30
	 */
	public String getMessage() {
		return (mMessageString);
	}


	/**
	 *  Gets the formattedMessage attribute of the Message object
	 *
	 *@return    The formattedMessage value
	 *@since     0.30
	 */
	public String getFormattedMessage() {
		return (HTMLUtil.replaceLinesWithParagraphs(mMessageString));
	}


	/**
	 *  Gets the author attribute of the Message object
	 *
	 *@return    The author value
	 *@since     0.30
	 */
	public String getAuthor() {
		return (mAuthorString);
	}


	/**
	 *  Gets the authorEmail attribute of the Message object
	 *
	 *@return    The authorEmail value
	 *@since     0.30
	 */
	public String getAuthorEmail() {
		return (mAuthorEmailString);
	}


    /**
     *  Gets the optional URL (if any)
     *
     *@return    The optional URL that goes with this message
     *@since     0.35
     */
    public String getOptionalURL() {
	return (mOptionalURLString);
    }


    /**
     *  Gets the title for the optional URL (if any)
     *
     *@return    The title for the optional URL that goes with this message
     *@since     0.35
     */
    public String getURLLinkTitle() {
	return (mUrlLinkString);
    }


	/**
	 *  
	 *
	 *@param  mr
	 *@return
	 *@since      0.30
	 */
	public boolean contains(MessageReference mr) {
		return (mReplies.contains(mr));
	}


	/**
	 *  
	 *
	 *@return
	 *@since     0.30
	 */
	public boolean hasBeenDeleted() {
		return (mAutorizationLevel == DELETED);
	}


	/**
	 *  Adds a feature to the Reply attribute of the Message object
	 *
	 *@param  mr  The feature to be added to the Reply attribute
	 *@since      0.30
	 */
	public void addReply(MessageReference mr) {
		if(mr!=null) mReplies.insertElementAt(mr, 0);
	}


	/**
	 *
	 *
	 *@param  mr
	 *@return
	 *@since      0.30
	 */
	public boolean removeReply(MessageReference mr) {
		return (mReplies.removeElement(mr));
	}




	/**
	 *  
	 *
	 *@param  out
	 *@exception  IOException
	 *@since                   0.30
	 */
	public void write(OutputStreamWriter out)
			 throws IOException {
		PrintWriter writer = new PrintWriter(out);
		writer.println("<MESSAGE>");
		if (this.mAutorizationLevel != NORMAL) {
			writer.println("<AUTHORIZATION>");
			writer.println(Integer.toString(this.mAutorizationLevel));
			writer.println("</AUTHORIZATION>");
		}
		writer.println("<POSTED>");
		writer.println(mDateFormat.format(mPostedDate).toString());
		writer.println("</POSTED>");
		if (mSubjectString != null) {
			writer.println("<SUBJECT>");
			writer.println(mSubjectString);
			writer.println("</SUBJECT>");
		}
		if (mMessageString != null) {
			writer.println("<CONTENT>");
			writer.println(HTMLUtil.makeStringHTMLSafe(mMessageString));
			writer.println("</CONTENT>");
		}
		if (mInReplyToID >= 0) {
			writer.println("<REPLYTOID>");
			writer.println(mInReplyToID);
			writer.println("</REPLYTOID>");
		}
		if (mAuthorString != null) {
			writer.println("<AUTHOR>");
			writer.println(mAuthorString);
			writer.println("</AUTHOR>");
		}
		if (mAuthorEmailString != null) {
			writer.println("<EMAIL>");
			writer.println(mAuthorEmailString);
			writer.println("</EMAIL>");
		}
		/* Added by Raj to add proper support for URL strings */
		if (mOptionalURLString != null)
		    {
			writer.println("<OPTIONALURL>");
			writer.println(mOptionalURLString);
			writer.println("</OPTIONALURL>");
		    }
		if (mUrlLinkString != null)
		    {
			writer.println("<URLLINKTITLE>");
			writer.println(mUrlLinkString);
			writer.println("</URLLINKTITLE>");
		    }
		writer.flush();

		// also write out references to any replies to this message
		if (mReplies.size() > 0) {
			writer.flush();
			Enumeration enum = mReplies.elements();
			while (enum.hasMoreElements()) {
				final MessageReference mr = (MessageReference) enum.nextElement();
				if(mr!=null) mr.write(out);
			}
		}
		writer.println("</MESSAGE>");
		writer.flush();
	}


	/**
	 *
	 *
	 *@return
	 *@since     0.30
	 */
	public String toString() {
	    /*
		if ((mSubjectString != null) && (mAuthorString != null)) {
			return (mSubjectString + " - " + mAuthorString);
		} else if (mSubjectString != null) {
			return (mSubjectString);
		} else if (mAuthorString != null) {
			return ("(" + mAuthorString + ")");
		}
		return ("?");
	    */

	StringBuffer retString= new StringBuffer();
	if (mPostedDate != null) retString.append("Posted On: " + mPostedDate + "\n");
	if (mSubjectString != null) retString.append("Subject: " + mSubjectString + "\n");
	if (mMessageString != null) retString.append("Message: " + mMessageString + "\n");
	if (mAuthorString != null) retString.append("Author: " + mAuthorString + "\n");
	if (mAuthorEmailString != null) retString.append("Author's email address:" + mAuthorEmailString + "\n");
	if (mOptionalURLString != null) retString.append("Optional URL: " + mOptionalURLString + "\n");
	if (mUrlLinkString != null) retString.append("Link title of optional URL: '" + mUrlLinkString + "'\n");
	if (mInReplyToID != -1) retString.append("Message was in reply to message ID: " + mInReplyToID + "\n");
	if (mAutorizationLevel != -1) retString.append("Authorisation level was: " + mAutorizationLevel + "\n");
	if (mReplies.size() > 0) retString.append("This message has replies\n");

	if (retString.length() == 0) return "No information available";

	return retString.toString();
	}

	/*
	* This compares the current message with another one and
	* return true if they appear to be the same. Notice that
	* this implementation is not meant to be entirely safe, but
	* it should run fast!
	*/
	public boolean fastCompare ( Message m) {
		if(compareAuthorSubject(m)) {
			if(mMessageString != null) {
				if (m.mMessageString == null) return false;
				return mMessageString.substring(NUMBER_OF_CHARS_TO_COMPARE).equals(m.mMessageString.substring(NUMBER_OF_CHARS_TO_COMPARE));
			}
			if((mMessageString == null) && (m.mMessageString == null)) return true;
		}
		return false;
	}

	private boolean compareAuthorSubject(Message m) {
		if ((mSubjectString != null) && (mAuthorString != null)) {
			if((m.mSubjectString == null) || (m.mAuthorString == null)) return false;
			return (mSubjectString.equals(m.mSubjectString) && mAuthorString.equals(m.mAuthorString));
		} else if (mSubjectString != null) {
			if(m.mSubjectString == null) return false;
			return (mSubjectString.equals(m.mSubjectString) && (m.mAuthorString == null) );
		} else if (mAuthorString != null) {
			if(m.mAuthorString == null) return false;
			return (mAuthorString.equals(m.mAuthorString)&& (m.mSubjectString == null));
		}
		if((m.mSubjectString == null) && (m.mAuthorString == null)) return true;
		return false;

	}

}


