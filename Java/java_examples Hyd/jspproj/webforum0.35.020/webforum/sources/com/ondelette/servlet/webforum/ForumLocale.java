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
 *         Added extra 'Post msg' button under Message: label so do not have
 *         to scroll down to hit button below.
 */

package com.ondelette.servlet.webforum;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import com.ondelette.servlet.*;

/**
 *  Internationalized strings support (i18n code goes here)
 *
 *@author     Daniel Lemire
 *@author     Raj Bhaskar
 *@created    March 12th 1999
 */
public final class ForumLocale implements ParameterNames, AutorizationConstants, FixedNumericalConstants 
{


    final static String mOptionalLinkURLPARAM= "OptionalLinkURL";
    final static String mLinkTitlePARAM= "LinkTitle";
    final static String mImageURLPARAM= "ImageURL";
    final static String mSubjectJavaScriptValue= "document." + SUBMITFORMNAME + "." + SUBJECTPARAM + ".value";
    final static String mAuthorJavaScriptValue= "document." + SUBMITFORMNAME + "." + AUTHORPARAM + ".value";
    final static String mMessageJavaScriptValue= "document." + SUBMITFORMNAME + "." + MESSAGEPARAM + ".value";
    final static String mOptionalLinkURLJavaScriptValue= "document." + SUBMITFORMNAME + "." + mOptionalLinkURLPARAM + ".value";
    final static String mLinkTitleJavaScriptValue= "document." + SUBMITFORMNAME + "." + mLinkTitlePARAM + ".value";
    final static String mImageURLJavaScriptValue= "document." + SUBMITFORMNAME + "." + mImageURLPARAM + ".value";

    /*
     * The defaults are in French, but it doesn't matter
     * since it will always be loaded from a i18n properties
     * file.
     */

    int mSizeOfForumFolders= 20;
    //30= SizeOfForumFolders;
    int mNumberOfFolders= 20;
    //15= NumberOfFolders;
    String mResetString= "Relancer la servlet";
    String mDeleteButtonString= "Effacer ce message";
    String mConfirmDeleteButtonString= "Oui, je veux effacer ce message!";
    String mCancelDeleteButtonString= "Non, je ne veux pas efface ce message!";
    String mInReplyTo= "En réponse à";
    String mSansTitreString= "Sans titre";
    String mAnonymousString= "Anonyme";
    String mByteString= " octet";
    String mBytesString= " octets";
    String mNewMessageString= "Soumettre un nouveau message";
    String mNewReplyString= "Répondre à ce message";
    String mMainString= "Retour au forum";
    String mReplyHeaderString= "En réponse à: ";
    String mFromString= "De";
    String mShortFromString= "par";
    String mSubmitString= "Soumettre mon message";
    String mReplyButtonString= "Soumettre ma réponse";
    String mSubjectString= "Sujet";
    String mMessageString= "Message";
    String mAuthorString= "Nom";
    String mEmailString= "Courriel";
    String mPasswordString= "Mot de passe";
    String mLinesString= "lignes";
    String mLineString= "ligne";
    String mMustEnterNameString= "Vous devez saisir votre nom.";
    String mMustEnterSubjectString= "Vous devez saisir un titre.";
    String mDisplayUserListString= "Liste des usagers";
    String mWelcomePageString= "Page d'accueil du forum (inscription)";
    String mWarningNameInUseString= "Ce nom est déjà utilisé.";
    String mWarningPasswordsDontMatchString= "Vous devez entrer deux fois le même mot de passe.";
    String mWarningAutorizationRequiredString= "Vous n'avez pas l'autorisation nécessaire.";
    String mWarningCannotChangeAdminString= "Vous ne pouvez pas modifier, créer ou effacer un administrateur.";
    String mDeleteUserString= "Effacer cet utilisateur (irréversible).";
    String mAddUserString= "Ajouter cet utilisateur.";
    String mChangeUserString= "Modifier cet utilisateur.";
    String mLastTenString= "Dix messages les plus récents";
    String mOptionalLinkURLString= "Lien URL (optionnel)";
    String mLinkTitleString= "Titre de l'URL";
    String mImageURLString= "URL d'une image (optionnel)";
    String mLocaleLanguage= "fr";
    String mLocaleCountry= "CA";
    String mLocaleVariant= "";
    String mLogout= "Logout";
    String mCharsetEncoding= "ISO-8859-1";
    int mNumberOfRowsForTextArea= 10;
    //int mNumberOfColsForTextArea= 37;
    int mNumberOfColsForTextArea= 75;
    int mNumberOfColsForTextFields= 40;
    Locale mCurrentLocale;
    //= new Locale(mLocaleLanguage,mLocaleCountry,mLocaleVariant);
    //	DateFormat CurrentDateFormat= DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,CurrentLocale);
    DateFormat mDateFormat;

    /**
     *  Constructor for the ForumLocale object
     *
     *@param  LocaleFile
     *@since              0.30
     */
    public ForumLocale(File localeFile) 
    {
	try {
	    readConfig(localeFile);
	} 
	catch (Exception e) {
	    e.printStackTrace();
	}
	mCurrentLocale= new Locale(mLocaleLanguage, mLocaleCountry, mLocaleVariant);
	mDateFormat= DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, mCurrentLocale);
    }




    /**
     *  
     *
     *@param  mr
     *@param  forum
     *@param  out
     *@param  user
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    public void printDeleteConfirmation(int mr, Forum forum, PrintWriter out, User user, String servletPath) 
	throws IOException 
    {
	Message message= forum.mMessageFolder.getMessage(mr);
	if(message == null) {
		printMessageCouldNotBeRetrieved(mr, forum, out, servletPath);
		return;	
	}
	confirmDeleteForm(out, forum, mr, user, servletPath);
	printMessageTable(message, forum, out, servletPath);
	writeRepliesSummaryHTML(message,this, forum, out, mr, servletPath);
    }


    /**
     *
     *@param  locale
     *@param  forum
     *@param  out
     *@param  selfmr
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    public void writeRepliesSummaryHTML(Message message, ForumLocale locale, Forum forum, PrintWriter out, 
					int selfmr, String servletPath) throws IOException 
    {
	Enumeration enum= message.getReplies();
	if (!enum.hasMoreElements()) {
	    return;
	}
	out.print("<ul class=\"REPLIES\">");
	while (enum.hasMoreElements()) 
	    {
		MessageReference mr= (MessageReference) enum.nextElement();
		if (mr == null) continue;
		if (mr.getID() != selfmr) 
		    {
			// on évite ainsi le problème de la boucle infinie
			// c'est en fait le seul instant où le message peut connaître son numéro
			// et c'est ainsi qu'on le veut (de manière à découpler les numéros des
			// messages
			out.print("<li class=\"REPLIES\">");
			locale.printSummary(mr.getID(), forum, out, servletPath);
			// be careful not to get into an infinite loop!
			out.print("</li>");
		    } // end if
	    } // end loop
	out.print("</ul>");
    } // end method writeRepliesSummaryHTML()


    /**
     *  
     *
     *@param  mr
     *@param  forum
     *@param  out
     *@param  user
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    public void printInFull(int mr, Forum forum, PrintWriter out, User user, String servletPath) throws IOException 
    {
	printBackToForum(out, forum, servletPath);
	Message message = forum.mMessageFolder.getMessage(mr);
	if(message == null) {
		printMessageCouldNotBeRetrieved(mr, forum, out, servletPath);
		return;	
	}
	if (user != null) 
	    {
		if (user.getAutorizationLevel() >= EXECUTIVEMEMBER) {
		    deleteForm(out, forum, mr, user, servletPath);
		}
	    } // end if
	printMessageTable(message, forum, out, servletPath);
	writeRepliesSummaryHTML(message, this, forum, out, mr, servletPath);
    } // end method printInFull()


    /**
     *  
     *
     *@param  mr
     *@param  forum
     *@param  out
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    public void printSummary(int mr, Forum forum, PrintWriter out, String servletPath) throws IOException 
    {
	Message message= printSummaryWithoutReplies(mr, forum, out, servletPath);
	if (message != null) 
	    {
		out.println();
		writeRepliesSummaryHTML(message, this, forum, out, mr, servletPath);
	    } // end if
    } // end method printSummary()


    /**
     *  
     *
     *@param  mr
     *@param  forum
     *@param  out
     *@param  servletPath
     *@return
     *@exception  IOException
     *@since                   0.30
     */
    public Message printSummaryWithoutReplies(int mr, Forum forum, PrintWriter out, String servletPath) throws IOException 
    {
	Message message= forum.mMessageFolder.getMessage(mr);
	if (message == null) return message;
	out.println();
	out.print("<a href=\"");
	out.print(servletPath);
	out.print("?");
	out.print(FORUMFILEPARAM);
	out.print("=");
	out.print(forum.mConfigFile.getPath());
	out.print("&amp;");
	out.print(SHOWPARAM);
	out.print("=");
	out.print(Integer.toString(mr));
	out.print("\" class=\"SHOWLINK\">");
	if (message.getSubject() != null) 
	    {
		if (message.getSubject().length() > 0)
		    out.print(message.getSubject());
		else
		    out.print(mSansTitreString);
	    } // end if
	else
	    out.print(mSansTitreString);

	out.print("</a>");
	out.print(" ");
	out.print(mShortFromString);
	out.print(" ");
	String authorClass= getAuthorClass(message.getAutorizationLevel());
	if (message.getAuthor() != null) 
	    {
		if (message.getAuthorEmail() != null) 
		    {
			if (message.getAuthorEmail().length() > 0) 
			    {
				out.print("<a href=\"mailto:");
				out.print(message.getAuthorEmail());
				out.print("\" class=\"");
				out.print(authorClass);
				out.print("\">");
				out.print(message.getAuthor());
				out.print("</a>");
			    } // end if
			else 
			    {
				out.print("<b class=\"");
				out.print(authorClass);
				out.print("\">");
				out.print(message.getAuthor());
				out.print("</b>");
			    } // end else
		    } // end if
		else 
		    {
			out.print("<b class=\"");
			out.print(authorClass);
			out.print("\">");
			out.print(message.getAuthor());
			out.print("</b>");
		    } // end else
	    } // end if
	else 
	    {
		out.print("<b class=\"");
		out.print(authorClass);
		out.print("\">");
		out.print(mAnonymousString);
		out.print("</b>");
	    } // end else
	putStamp(message, out);
	return (message);
    } // end method printSummaryWithoutReplies()


    /**
     *  
     *
     *@param  forum
     *@param  out
     *@param  user
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    public void printButtons(Forum forum, PrintWriter out, User user, String servletPath) throws IOException 
    {
	if (user != null) {
	    if (user.getAutorizationLevel() >= VIPMEMBER) {
		printResetForm(out, forum, servletPath);
		printUserListForm(out, forum, servletPath);
	    }
	}
	printBackToWelcomeURL(out, forum);
    }


    /**
     *  
     *
     *@param  forum
     *@param  out
     *@param  currentpage
     *@param  user
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    public void printMenu(Forum forum, PrintWriter out, int currentpage, User user, String servletPath) throws IOException 
    {
	int pages= forum.mMessageFolder.getNumberOfPages() > mNumberOfFolders ? 
	    mNumberOfFolders : forum.mMessageFolder.getNumberOfPages();
	out.print("<p class=\"MENU\">[ ");
	out.println();
	if (currentpage == 0) {
	    out.print("<b>1</b>");
	} 
	else {
	    out.print("<a href=\"");
	    out.print(servletPath);
	    out.print("?");
	    out.print(FORUMFILEPARAM);
	    out.print("=");
	    out.print(forum.mConfigFile.getPath());
	    out.print("&amp;");
	    out.print(PAGEPARAM);
	    out.print("=0\">1</a>");
	}
	String stringk;
	String stringkMinus;
	for (int k= 1; k < pages; k++) {
	    out.println();
	    out.print(" | ");
	    stringk= Integer.toString(k + 1);
	    stringkMinus= Integer.toString(k);
	    if (k == currentpage) {
		out.print("<b>"
			  + stringk
			  + "</b>");
	    } 
	    else {
		out.print("<a href=\"");
		out.print(servletPath);
		out.print("?");
		out.print(FORUMFILEPARAM);
		out.print("=");
		out.print(forum.mConfigFile.getPath());
		out.print("&amp;");
		out.print(PAGEPARAM);
		out.print("=");
		out.print(stringkMinus);
		out.print("\">");
		out.print(stringk);
		out.print("</a>");
	    }
	}
	out.println(" ] ");
	out.println("</p>");
	out.println("<p class=\"MENU\">");
	out.print("<a href=\"");
	out.print(servletPath);
	out.print("?");
	out.print(FORUMFILEPARAM);
	out.print("=");
	out.print(forum.mConfigFile.getPath());
	out.print("&amp;");
	out.print(LASTMESSAGES);
	out.print("=");
	out.print(10);
	out.print("\">");
	out.print(mLastTenString);
	out.print("</a>");
	out.println("</p>");
    }


    /**
     *  
     *
     *@param  forum
     *@param  out
     *@exception  IOException
     *@since                   0.30
     */
    public void printForumTitle(Forum forum, PrintWriter out) throws IOException {
	if (forum.mForumTitle != null) {
	    out.print("<h1 class=\"TITLE\">");
	    out.print(forum.mForumTitle);
	    out.println("</h1>");
	}
	if (forum.mForumSubTitle != null) {
	    out.print("<h2 class=\"TITLE\">");
	    out.print(forum.mForumSubTitle);
	    out.println("</h2>");
	}
    }

    public void printForumHeader(Forum forum, PrintWriter out) throws IOException 
    {
			printForumHeader(forum,forum.mForumTitle,null,out);
		}	
    /**
     *  
     *
     *@param  forum
     *@param  out
     *@exception  IOException
     *@since                   0.30
     */
    public void printForumHeader(Forum forum,String title, String description, PrintWriter out) throws IOException 
    {
	out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"");
	out.println("\"http://www.w3.org/TR/REC-html40/loose.dtd\">");
	out.println("<html>");
	out.println("<head>");
	if(title != null) {
		out.print("<title>");
		out.print(title);
		out.println("</title>");
	}
	if(description != null) {
		out.print("<meta name=\"Description\" content=\"");
		out.print(description.substring(0,description.length() < 80 ? description.length() : 80));// only use first 80 characters!
		out.println("\" />");
	}
	out.print("<link rel=stylesheet type=\"text/css\" href=\"");
	out.print(forum.mCSSURL);
	out.println("\">");
	out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + mCharsetEncoding + "\">");
	out.println("<meta http-equiv=\"Content-Style-Type\" content=\"text/css\">");
	out.print("<meta http-equiv=\"Content-Language\" content=\"");
	out.print(mLocaleLanguage);
	out.println("\">");
	out.print("<meta name=\"Copyright\" content=\"");
	out.print(ServletCopyright.getCopyright());
	out.println("\">");
	printJavaScriptHeader(forum, out);
	out.print("</head>");
	out.println();
	out.print("<body>");
	out.println();
    }


    /**
     *  
     *
     *@param  mr
     *@param  forum
     *@param  out
     *@param  user
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    public void printReplyForm(int mr, Forum forum, PrintWriter out, User user, String servletPath) throws IOException {
	out.print("<p class=\"REPLY\">");
	out.print(mNewReplyString);
	out.println("&nbsp;:</p>");
	printForm(out, forum, Integer.toString(mr), user, servletPath);
    }


    /**
     *  
     *
     *@param  forum
     *@param  out
     *@param  user
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    public void printPostForm(Forum forum, PrintWriter out, User user, String servletPath) throws IOException {
	out.print("<p class=\"REPLY\">");
	out.print(mNewMessageString);
	out.println("&nbsp;:</p>");
	printForm(out, forum, null, user, servletPath);
    }


    /**
     *  
     *
     *@param  out
     *@param  forum
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    public void printResetForm(PrintWriter out, Forum forum, String servletPath) throws IOException {
	out.print("<div class=\"RESET\">");
	out.print("<form action=\"");
	out.print(servletPath);
	out.println("\" method=\"post\">");
	out.print("<input type=\"hidden\" name=\"");
	out.print(FORUMFILEPARAM);
	out.print("\" value=\"");
	out.print(forum.mConfigFile.getPath());
	out.print("\">");
	out.print("<input type=\"submit\" value=\"");
	out.print(mResetString);
	out.print("\" name=\"");
	out.print(RESETPARAM);
	out.print("\">");
	out.println();
	out.println("</form>");
	out.print("</div>");
	out.println();
    }


    /**
     *  
     *
     *@param  out
     *@param  forum
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    public void printUserListForm(PrintWriter out, Forum forum, String servletPath) throws IOException {
	out.print("<div class=\"USERLIST\">");
	out.print("<form action=\"");
	out.print(servletPath);
	out.println("\" method=\"post\">");
	out.print("<input type=\"hidden\" name=\"");
	out.print(FORUMFILEPARAM);
	out.print("\" value=\"");
	out.print(forum.mConfigFile.getPath());
	out.print("\">");
	out.print("<input type=\"submit\" value=\"");
	out.print(mDisplayUserListString);
	out.print("\" name=\"");
	out.print(DISPLAYUSERLIST);
	out.println("\">");
	out.println("</form>");
	out.println("</div>");
    }


    /**
     *  
     *
     *@param  out
     *@param  forum
     *@since         0.30
     */
    public void printBackToWelcomeURL(PrintWriter out, Forum forum) {
	out.print("<p class=\"BACKTOFORUM\">");
	out.print("<a href=\"");
	out.print(forum.mWelcomeURL);
	out.print("\"  class=\"BACKTOFORUM\">");
	out.print(mWelcomePageString);
	out.print("</a>");
	out.println("</p>");
    }


    /**
     *  
     *
     *@param  out
     *@param  forum
     *@param  servletPath
     *@since               0.30
     */
    public void printBackToForum(PrintWriter out, Forum forum, String servletPath) {
	out.print("<p class=\"BACKTOFORUM\">");
	out.print("<a href=\"");
	out.print(servletPath);
	out.print("?");
	out.print(FORUMFILEPARAM);
	out.print("=");
	out.print(forum.mConfigFile.getPath());
	out.print("\"  class=\"BACKTOFORUM\">");
	out.print(mMainString);
	out.print("</a>");
	out.println("</p>");
    }


    /**
     *  
     *
     *@param  name
     *@param  out
     *@param  forum
     *@since         0.30
     */
    public void showWarningNameInUse(String name, PrintWriter out, Forum forum) {
	printBackToWelcomeURL(out, forum);
	out.println("<p class=\"WARNING\">");
	out.println(mWarningNameInUseString);
	out.println("</p>");
    }


    /**
     *  
     *
     *@param  name
     *@param  out
     *@param  forum
     *@since         0.30
     */
    public void showWarningPasswordsDontMatch(String name, PrintWriter out, Forum forum) {
	printBackToWelcomeURL(out, forum);
	out.println("<p class=\"WARNING\">");
	out.println(mWarningPasswordsDontMatchString);
	out.println("</p>");
    }


    /**
     *  
     *
     *@param  out
     *@param  forum
     *@since         0.30
     */
    public void showWarningAutorizationRequired(PrintWriter out, Forum forum) {
	printBackToWelcomeURL(out, forum);
	out.println("<p class=\"WARNING\">");
	out.println(mWarningAutorizationRequiredString);
	out.println("</p>");
    }


    /**
     *  
     *
     *@param  out
     *@param  forum
     *@since         0.30
     */
    public void showWarningCannotChangeAdmin(PrintWriter out, Forum forum) {
	printBackToWelcomeURL(out, forum);
	out.println("<p class=\"WARNING\">");
	out.println(mWarningCannotChangeAdminString);
	out.println("</p>");
    }


    /**
     *  
     *
     *@param  forum
     *@param  out
     *@param  servletPath
     *@since               0.30
     */
    public void printUserList(Forum forum, PrintWriter out, String servletPath) {
	printBackToForum(out, forum, servletPath);
	Enumeration enum= forum.mUserList.getUsers();
	out.println("<TABLE BORDER=5>");
	while (enum.hasMoreElements()) {
	    User u= (User) enum.nextElement();
	    out.println("<tr><td>");
	    if (u.getAutorizationLevel() < ADMIN) {
		out.print("<form action=\"");
		out.print(servletPath);
		out.println("\" method=\"post\">");
		out.print("<input type=\"hidden\" name=\"");
		out.print(FORUMFILEPARAM);
		out.print("\" value=\"");
		out.print(forum.mConfigFile.getPath());
		out.println("\">");
		out.print("<input type=\"hidden\" name=\"");
		out.print(DISPLAYUSER);
		out.print("\" value=\"");
	    }
	    if (u.getLogin() != null) {
		out.print(u.getLogin());
	    }
	    if (u.getAutorizationLevel() < ADMIN) {
		out.print("\">");
		out.print("<input type=\"SUBMIT\" value=\"");
		if (u.getLogin() != null) {
		    out.println(u.getLogin());
		}
		out.print("\">");
		out.println("</form>");
	    }
	    out.println("</td><td>");
	    out.println("<a href=\"mailto:");
	    if (u.getEmail() != null) {
		out.println(u.getEmail());
	    }
	    out.println("\">");
	    if (u.getEmail() != null) {
		out.println(u.getEmail());
	    }
	    out.println("</a>");
	    out.println("</td><td>");
	    out.println(u.getAutorizationLevel());
	    out.println("</td><td>");
	    if (u.getAutorizationLevel() < ADMIN) {
		out.print("<form action=\"");
		out.print(servletPath);
		out.println("\" method=\"post\">");
		out.print("<input type=\"hidden\" name=\"");
		out.print(FORUMFILEPARAM);
		out.print("\" value=\"");
		out.print(forum.mConfigFile.getPath());
		out.print("\">");
		out.print("<input type=\"hidden\" name=\"");
		out.print(DELETEUSER);
		out.print("\" value=\"");
		if (u.getLogin() != null) {
		    out.print(u.getLogin());
		}
		out.print("\">");
		out.print("<input type=\"SUBMIT\" value=\"");
		out.print(mDeleteUserString);
		out.print("\" onClick=\"return confirm('");
		out.print(mDeleteUserString);
		out.print("')\">");
		out.println("</form>");
	    }
	    out.println("</td></tr>");
	}
	out.println("</TABLE>");
	printUserForm(forum, null, out, servletPath);
    }


    /**
     *  
     *
     *@param  forum
     *@param  name
     *@param  out
     *@param  servletPath
     *@since               0.30
     */
    public void printUser(Forum forum, String name, PrintWriter out, String servletPath) {
	printBackToForum(out, forum, servletPath);
	printUserForm(forum, forum.mUserList.getUser(name), out, servletPath);
    }


    /**
     *  
     *
     *@param  forum
     *@param  u
     *@param  out
     *@param  servletPath
     *@since               0.30
     */
    public void printUserForm(Forum forum, User u, PrintWriter out, String servletPath) {
	out.print("<form action=\"");
	out.print(servletPath);
	out.print("\" method=\"post\">");
	out.println("<TABLE>");
	out.print("<input type=\"hidden\" name=\"");
	out.print(FORUMFILEPARAM);
	out.print("\" value=\"");
	out.print(forum.mConfigFile.getPath());
	out.println("\">");
	if (u != null) {
	    out.print("<input type=\"hidden\" name=\"");
	    out.print(OLDUSERNAME);
	    out.print("\" value=\"");
	    if (u.getLogin() != null) {
		out.print(u.getLogin());
	    }
	    out.println("\">");
	}
	out.println("<tr><td>");
	out.println(this.mAuthorString);
	out.println("</td><td>");
	out.print("<input type=\"text\" name=\"");
	out.print(NEWUSERNAME);
	out.print("\" value=\"");
	if (u != null) {
	    if (u.getLogin() != null) {
		out.print(u.getLogin());
	    }
	}
	out.print("\" size=\"");
	out.print(Integer.toString(mNumberOfColsForTextFields));
	out.print("\" maxlength=\"");
	out.print(MAX_TEXTFIELD_SIZE);
	out.println("\">");
	out.println("</td></tr>");
	out.println("<tr><td>");
	out.println(mPasswordString);
	out.println("</td><td>");
	out.print("<input type=\"text\" name=\"");
	out.print(NEWUSERPASSWORD);
	out.print("\" value=\"");
	if (u != null) {
	    if (u.getPassword() != null) {
		if (u.getAutorizationLevel() < ADMIN) {
		    out.print(u.getPassword());
		}
	    }
	}
	out.print("\" size=\"");
	out.print(Integer.toString(mNumberOfColsForTextFields));
	out.print("\" maxlength=\"");
	out.print(MAX_TEXTFIELD_SIZE);
	out.println("\">");
	out.println("</td></tr>");
	out.println("<tr><td>");
	out.println(mEmailString);
	out.println("</td><td>");
	out.print("<input type=\"text\" name=\"");
	out.print(NEWUSEREMAIL);
	out.print("\" value=\"");
	if (u != null) {
	    if (u.getEmail() != null) {
		out.print(u.getEmail());
	    }
	}
	out.print("\" size=\"");
	out.print(Integer.toString(mNumberOfColsForTextFields));
	out.print("\" maxlength=\"");
	out.print(MAX_TEXTFIELD_SIZE);
	out.println("\">");
	out.println("</td></tr>");
	out.println("<tr><td>");
	out.println("</td><td>");
	out.print("<SELECT NAME=\"");
	out.print(NEWUSERLEVEL);
	out.println("\">");
	if (u != null) {
	    out.print("  <OPTION VALUE=\"");
	    out.print(u.getAutorizationLevel());
	    out.println("\"> " + u.getAutorizationLevel());
	}
	out.print("  <OPTION VALUE=\"");
	out.print(IDENTIFIEDGUEST);
	out.println("\"> IDENTIFIEDGUEST (" + IDENTIFIEDGUEST + ")");
	out.print("  <OPTION VALUE=\"");
	out.print(MEMBER);
	out.println("\"> MEMBER (" + MEMBER + ")");
	out.print("  <OPTION VALUE=\"");
	out.print(EXECUTIVEMEMBER);
	out.println("\"> EXECUTIVEMEMBER (" + EXECUTIVEMEMBER + ")");
	out.print("  <OPTION VALUE=\"");
	out.print(VIPMEMBER);
	out.println("\"> VIPMEMBER");
	out.print("  <OPTION VALUE=\"");
	out.print(ACCOUNTINACTIVE);
	out.println("\"> ACCOUNTINACTIVE (" + ACCOUNTINACTIVE + ")");
	out.println("</SELECT>");
	out.println("</td></tr>");
	out.println("</TABLE>");
	out.print("<input type=\"SUBMIT\" value=\"");
	if (u == null) {
	    out.print(mAddUserString);
	} else {
	    out.print(mChangeUserString);
	}
	out.print("\" name=\"");
	if (u == null) {
	    out.print(ADDUSER);
	} else {
	    out.print(CHANGEUSER);
	}
	out.println("\">");
	
	out.println("</form>");
    }


    /**
     *  Gets the authorClass attribute of the ForumLocale object
     *
     *@param  AutorizationLevel
     *@return                    The authorClass value
     *@since                     0.30
     */
    private String getAuthorClass(int autorizationLevel) {
	String authorClass= "AUTHORNAME";
	if (autorizationLevel >= AutorizationConstants.ADMIN) {
	    authorClass= "ADMINAUTHOR";
	} else if (autorizationLevel >= AutorizationConstants.VIPMEMBER) {
	    authorClass= "VIPMEMBER";
	} else if (autorizationLevel >= AutorizationConstants.EXECUTIVEMEMBER) {
	    authorClass= "EXECUTIVEMEMBERAUTHOR";
	} else if (autorizationLevel >= AutorizationConstants.MEMBER) {
	    authorClass= "MEMBERAUTHOR";
	} else if (autorizationLevel >= AutorizationConstants.IDENTIFIEDGUEST) {
	    authorClass= "GUESTAUTHOR";
	}
	return (authorClass);
    }



    /**
     *  
     *
     *@param  LocaleFile
     *@exception  IOException
     *@since                   0.30
     */
    private void readConfig(File LocaleFile) throws IOException {
	Properties p= new Properties();
	BufferedInputStream fis= new BufferedInputStream(new FileInputStream(LocaleFile));
	p.load(fis);
	fis.close();
	String s= p.getProperty("SizeOfForumFolders");
	if (s != null) {
	    mSizeOfForumFolders= Integer.parseInt(s);
	}
	s= p.getProperty("NumberOfFolders");
	if (s != null) {
	    mNumberOfFolders= Integer.parseInt(s);
	}
	s= p.getProperty("ResetString");
	if (s != null) {
	    mResetString= new String(s);
	}
	s= p.getProperty("DeleteButton");
	if (s != null) {
	    mDeleteButtonString= new String(s);
	}
	s= p.getProperty("ConfirmDeleteButton");
	if (s != null) {
	    mConfirmDeleteButtonString= new String(s);
	}
	s= p.getProperty("CancelDeleteButton");
	if (s != null) {
	    mCancelDeleteButtonString= new String(s);
	}
	s= p.getProperty("InReplyTo");
	if (s != null) {
	    mInReplyTo= new String(s);
	}
	s= p.getProperty("SansTitre");
	if (s != null) {
	    mSansTitreString= new String(s);
	}
	s= p.getProperty("Anonymous");
	if (s != null) {
	    mAnonymousString= new String(s);
	}
	s= p.getProperty("Byte");
	if (s != null) {
	    mByteString= new String(s);
	}
	s= p.getProperty("Bytes");
	if (s != null) {
	    mBytesString= new String(s);
	}
	s= p.getProperty("NewMessage");
	if (s != null) {
	    mNewMessageString= new String(s);
	}
	s= p.getProperty("NewReply");
	if (s != null) {
	    mNewReplyString= new String(s);
	}
	s= p.getProperty("Main");
	if (s != null) {
	    mMainString= new String(s);
	}
	s= p.getProperty("ReplyHeader");
	if (s != null) {
	    mReplyHeaderString= new String(s);
	}
	s= p.getProperty("From");
	if (s != null) {
	    mFromString= new String(s);
	}
	s= p.getProperty("ShortFrom");
	if (s != null) {
	    mShortFromString= new String(s);
	}
	s= p.getProperty("Submit");
	if (s != null) {
	    mSubmitString= new String(s);
	}
	s= p.getProperty("ReplyButton");
	if (s != null) {
	    mReplyButtonString= new String(s);
	}
	s= p.getProperty("Subject");
	if (s != null) {
	    mSubjectString= new String(s);
	}
	s= p.getProperty("Message");
	if (s != null) {
	    mMessageString= new String(s);
	}
	s= p.getProperty("Author");
	if (s != null) {
	    mAuthorString= new String(s);
	}
	s= p.getProperty("Email");
	if (s != null) {
	    mEmailString= new String(s);
	}
	s= p.getProperty("Password");
	if (s != null) {
	    mPasswordString= new String(s);
	}
	s= p.getProperty("Lines");
	if (s != null) {
	    mLinesString= new String(s);
	}
	s= p.getProperty("Line");
	if (s != null) {
	    mLineString= new String(s);
	}
	s= p.getProperty("MustEnterName");
	if (s != null) {
	    mMustEnterNameString= new String(s);
	}
	s= p.getProperty("MustEnterSubject");
	if (s != null) {
	    mMustEnterSubjectString= new String(s);
	}
	s= p.getProperty("DisplayUserList");
	if (s != null) {
	    mDisplayUserListString= new String(s);
	}
	s= p.getProperty("WelcomePage");
	if (s != null) {
	    mWelcomePageString= new String(s);
	}
	s= p.getProperty("WarningNameInUse");
	if (s != null) {
	    mWarningNameInUseString= new String(s);
	}
	s= p.getProperty("WarningPasswordsDontMatch");
	if (s != null) {
	    mWarningPasswordsDontMatchString= new String(s);
	}
	s= p.getProperty("WarningAutorizationRequired");
	if (s != null) {
	    mWarningAutorizationRequiredString= new String(s);
	}
	s= p.getProperty("WarningCannotChangeAdmin");
	if (s != null) {
	    mWarningCannotChangeAdminString= new String(s);
	}
	s= p.getProperty("DeleteUser");
	if (s != null) {
	    mDeleteUserString= new String(s);
	}
	s= p.getProperty("AddUser");
	if (s != null) {
	    mAddUserString= new String(s);
	}
	s= p.getProperty("ChangeUser");
	if (s != null) {
	    mChangeUserString= new String(s);
	}
	s= p.getProperty("LastTen");
	if (s != null) {
	    mLastTenString= new String(s);
	}
	s= p.getProperty("OptionalLinkURL");
	if (s != null) {
	    mOptionalLinkURLString= new String(s);
	}
	s= p.getProperty("LinkTitle");
	if (s != null) {
	    mLinkTitleString= new String(s);
	}
	s= p.getProperty("ImageURL");
	if (s != null) {
	    mImageURLString= new String(s);
	}
	s= p.getProperty("LocaleLanguage");
	if (s != null) {
	    mLocaleLanguage= new String(s);
	}
	s= p.getProperty("LocaleCountry");
	if (s != null) {
	    mLocaleCountry= new String(s);
	}
	s= p.getProperty("LocaleVariant");
	if (s != null) {
	    mLocaleVariant= new String(s);
	}
	s= (String) p.get("Logout");
	if (s != null) mLogout= new String(s);

	s= p.getProperty("charset.encoding");
	if (s != null) mCharsetEncoding= new String(s);

	s= p.getProperty("NumberOfRowsForTextArea");
	if (s != null) mNumberOfRowsForTextArea= Integer.parseInt(s);

	s= p.getProperty("NumberOfColsForTextArea");
	if (s != null) mNumberOfColsForTextArea= Integer.parseInt(s);

	s= p.getProperty("NumberOfColsForTextFields");
	if (s != null) mNumberOfColsForTextFields= Integer.parseInt(s);

    } // end method readConfig

	/**
	* Informs the user that the message could be retrieved.
  * TODO: Add i18n support for this error message.
	*/
	private void printMessageCouldNotBeRetrieved(int mr, Forum forum, PrintWriter out, String servletPath) {
		out.print("<p>");
		out.print("Message Number "+mr+" could not be retrieved off the database.");
		out.print("Nothing further can be done. The message is probably lost.");
		out.print("</p>");
	}


    /**
     * Print the main text of the message 
     *
     *@param  message
     *@param  forum
     *@param  out
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    private void printMessageTable(Message message, Forum forum, PrintWriter out, String servletPath) 
	throws IOException 
    {
	out.print("<div  class=\"FULLMESSAGE\">");
	out.print("<TABLE class=\"FULLMESSAGE\" BORDER=0>");
	out.println();
	try {
	    if (message.getInReplyTo() >= 0) {
		out.print("<tr><td class=\"INREPLYTOID\">");
		out.print(mInReplyTo);
		out.print("&nbsp;: ");
		int parentmr= message.getInReplyTo();
		printSummaryWithoutReplies(parentmr, forum, out, servletPath);
		out.println("</td></tr>");
	    }
	} catch (java.lang.NullPointerException npe) {
	    // this will happen when the database goes out of sync
	    npe.printStackTrace();
	}
	out.print("<tr><td class=\"DISPLAYSUBJECT\">");
	out.print(mSubjectString);
	out.print("&nbsp;: ");
	if (message.getSubject() != null) {
	    out.print(message.getSubject().toString());
	} else {
	    out.print(mSansTitreString);
	}
	out.print("<br>");
	putStamp(message, out);
	out.print("</td></tr>");
	out.println();
	String authorClass= getAuthorClass(message.getAutorizationLevel());
	out.print("<tr><td class=\"");
	out.print(authorClass);
	out.print("\">");
	out.print(mFromString);
	out.print("&nbsp;: ");
	if (message.getAuthor() != null) {
	    if (message.getAuthorEmail() != null) {
		out.print("<a href=\"mailto:");
		out.print(message.getAuthorEmail());
		out.print("\" class=\"");
		out.print(authorClass);
		out.print("\">");
		out.print(message.getAuthor().toString());
		out.print("</a>");
	    } else {
		out.print(message.getAuthor().toString());
	    }
	} else {
	    out.print(this.mAnonymousString);
	}
	out.print("</td></tr>");
	out.println("</TABLE>");
	out.println("</div>");
	if (message.getMessage() != null) {
	    out.println("<div class=\"DISPLAYMESSAGE\">");
	    out.print(mMessageString);
	    out.println("&nbsp;: <br>");
	    out.print(message.getFormattedMessage());
	    out.println("</div>");
	}
	/* Added by Raj to add proper support for URL strings */
	if (message.getOptionalURL() != null)
	    {
		String optionalURL= message.getOptionalURL();
		out.print("<div class=\"optionallink\"><a target=\"_blank\" href=\"" + optionalURL + "\">");
		if (message.getURLLinkTitle() != null)
		    out.print(message.getURLLinkTitle());
		else out.print(optionalURL);
		out.println("</a>\n</div>");
	    } // end if

    }


    /**
     *  
     *
     *@param  message
     *@param  out
     *@exception  IOException
     *@since                   0.30
     */
    private void putStamp(Message message, PrintWriter out) throws IOException {
	out.print(" <small class=\"STAMP\"><em>");
	out.print(mDateFormat.format(message.getDate()));
	out.print("</em>");
	if (false) {
	    out.println(" [");
	    out.print(Integer.toString(message.getNumberOfBytes()));
	    out.print(" ");
	    if (message.getNumberOfBytes() < 2) {
		out.print(mByteString);
	    } else {
		out.print(mBytesString);
	    }
	    out.print("][");
	    out.print(Integer.toString(message.getNumberOfLines()));
	    out.print(" ");
	    if (message.getNumberOfLines() < 2) {
		out.print(this.mLineString);
	    } else {
		out.print(this.mLinesString);
	    }
	    out.print("]");
	}
	out.print("</small>");
    }


    /**
     * Prints a Javascript function that performs validation of messages
     *
     *@param  forum
     *@param  out
     *@exception  IOException
     *@since                   0.30
     */
    private void printJavaScriptHeader(Forum forum, PrintWriter out) throws IOException 
    {
	out.println("<meta http-equiv=\"Content-Script-Type\" content=\"text/javascript\">");
	out.println("<script type=\"text/javascript\">");
	out.println("<!--");
	out.println("function checkMessage(ext) {");
	// they must enter their name
	out.print("if ((" + mAuthorJavaScriptValue + " == null) || (");
	out.print(mAuthorJavaScriptValue + " == ''))");
	out.println("alert('" + mMustEnterNameString + "');");
	// they must enter a subject for their post
	out.print("else if ((" + mSubjectJavaScriptValue + " == null) || (" + mSubjectJavaScriptValue + " == ''))");
	out.print("alert('" + mMustEnterSubjectString + "');");
	out.println("else {");
	out.print("if ((");
	out.print(mImageURLJavaScriptValue);
	out.print(" != null) && (");
	out.print(mImageURLJavaScriptValue);
	out.print(" != 'HTTP://') && (");
	out.print(mImageURLJavaScriptValue);
	out.println(" != '')) { ");
	out.println(mMessageJavaScriptValue + "= " + mMessageJavaScriptValue
		    + " + '<div ALIGN=CENTER><IMG SRC=\"' + " + mImageURLJavaScriptValue + " + '\" ALIGN=CENTER><\\/DIV>';");
	out.println("}");
/*	
	out.print("if ((");
	out.print(mOptionalLinkURLJavaScriptValue);
	out.print(" != 'HTTP://') && (");
	out.print(mOptionalLinkURLJavaScriptValue);
	out.print(" != '') && (");
	out.print(mOptionalLinkURLJavaScriptValue);
	out.print(" != null)) {");
	out.print(" if ((");
	out.print(mLinkTitleJavaScriptValue);
	out.print(" != null) && (");
	out.print(mLinkTitleJavaScriptValue);
	out.println(" != '')) { ");
	out.println(" " + mMessageJavaScriptValue + "= " + mMessageJavaScriptValue
		    + " + '<div ALIGN=CENTER><a href=\"' + " + mOptionalLinkURLJavaScriptValue + "+ '\">' + " + mLinkTitleJavaScriptValue + " + '<\\/A><\\/DIV>';");
	out.println(" } else {");
	out.println(" " + mMessageJavaScriptValue + "= " + mMessageJavaScriptValue
		    + " + '<div ALIGN=CENTER><a href=\"' + " + mOptionalLinkURLJavaScriptValue + "+ '\">' + " + mOptionalLinkURLJavaScriptValue + " + '<\\/A><\\/DIV>';");
	out.println("}");
	out.println("}");
	*/
	out.print("document." + SUBMITFORMNAME + ".submit();}");

	out.println("}");
	out.println("// fin du script -->");
	out.println("</SCRIPT>");
    } // end method printJavaScriptHeader()


    /**
     *  
     *
     *@param  out
     *@param  forum
     *@param  MessageID
     *@param  user
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    private void printForm(PrintWriter out, Forum forum, String MessageID, User user, String servletPath) throws IOException {
	out.print("<form action=\"");
	out.print(servletPath);
	out.print("\" method=\"post\" NAME=\"");
	out.print(SUBMITFORMNAME);
	out.println("\">");
	if (MessageID != null) {
	    out.print("<input type=\"hidden\" name=\"");
	    out.print(MESSAGEIDPARAM);
	    out.print("\" value=\"");
	    out.print(MessageID);
	    out.println("\">");
	}
	out.print("<input type=\"hidden\" name=\"");
	out.print(FORUMFILEPARAM);
	out.print("\" value=\"");
	out.print(forum.mConfigFile.getPath());
	out.println("\">");
	out.println("<div class=\"POSTMESSAGEFORM\">");
	out.println("<TABLE class=\"POSTMESSAGEFORM\">");
	out.println("<tr><td class=\"SUBJECT\">");
	out.print(mSubjectString);
	out.println("&nbsp;:");
	out.println("</td><td class=\"SUBJECTFIELD\">");
	out.print("<input type=\"TEXT\" value=\"");
	out.print("\" name=\"");
	out.print(SUBJECTPARAM);
	out.print("\" size=\"");
	out.print(Integer.toString(mNumberOfColsForTextFields));
	out.print("\" maxlength=\"");
	out.print(MAX_TEXTFIELD_SIZE);
	out.println("\">");
	out.println("</td></tr>");
	out.println("<tr><td class=\"MESSAGE\">");
	out.print(mMessageString);
	out.println("&nbsp;:");

	out.print("<br><input type=\"button\" value=\"");
	if (MessageID == null) {
	    out.print(mSubmitString);
	    out.print("\" name=\"");
	    out.print("toto");
	} else {
	    out.print(mReplyButtonString);
	    out.print("\" name=\"");
	    out.print("toto");
	}
	out.println("\" onClick=\"checkMessage('')\">");
	
	out.println("</td><td class=\"FIELD\">");

	out.print("<textarea rows=\"");
	out.print(Integer.toString(mNumberOfRowsForTextArea));
	out.print("\" name=\"");
	out.print(MESSAGEPARAM);
	out.print("\" cols=\"");
	out.print(Integer.toString(mNumberOfColsForTextArea));
	out.println("\" class=\"MESSAGEPOST\"></textarea>");
	out.println("</td></tr>");
	out.println("<tr><td class=\"AUTHOR\">");
	out.print(mAuthorString);
	out.println("&nbsp;:");
	out.println("</td><td class=\"AUTHORFIELD\">");
	if (user == null) {
	    out.print("<input type=\"TEXT\" value=\"\" name=\"");
	    out.print(AUTHORPARAM);
	    out.print("\" size=\"");
	    out.print(Integer.toString(mNumberOfColsForTextFields));
	    out.print("\" maxlength=\"");
	    out.print(MAX_TEXTFIELD_SIZE);
	    out.println("\">");
	} else {
	    if (user.getAutorizationLevel() > 0) {
		if (user.getLogin() != null) {
		    out.println(user.getLogin());
		}
		out.print("<input type=\"hidden\" value=\"");
		if (user.getLogin() != null) {
		    out.print(user.getLogin());
		}
		out.print("\" name=\"");
		out.print(AUTHORPARAM);
		out.print("\" size=\"");
		out.print(Integer.toString(mNumberOfColsForTextFields));
		out.print("\" maxlength=\"");
		out.print(MAX_TEXTFIELD_SIZE);
		out.println("\">");
	    } else {
		out.print("<input type=\"TEXT\" value=\"");
		if (user.getLogin() != null) {
		    out.print(user.getLogin());
		}
		out.print("\" name=\"");
		out.print(AUTHORPARAM);
		out.print("\" size=\"");
		out.print(Integer.toString(mNumberOfColsForTextFields));
		out.print("\" maxlength=\"");
		out.print(MAX_TEXTFIELD_SIZE);
		out.println("\">");
	    }
	}
	out.println("</td></tr>");
	out.println("<tr><td class=\"EMAIL\">");
	out.print(mEmailString);
	out.println("&nbsp;:");
	out.println("</td><td class=\"EMAILFIELD\">");
	out.print("<input type=\"TEXT\" value=\"");
	if (user != null) {
	    if (user.getEmail() != null) {
		out.print(user.getEmail());
	    }
	}
	out.print("\" name=\"");
	out.print(EMAILPARAM);
	out.print("\" size=\"");
	out.print(Integer.toString(mNumberOfColsForTextFields));
	out.print("\" maxlength=\"");
	out.print(MAX_TEXTFIELD_SIZE);
	out.println("\">");
	out.println("</td></tr>");

	out.println("<tr><td class=\"OPTLINK\">");
	out.print(mOptionalLinkURLString);
	out.println("&nbsp;:");
	out.println("</td><td class=\"OPTLINKFIELD\">");
	out.print("<input type=\"TEXT\" value=\"HTTP://\" name=\"");
	out.print(mOptionalLinkURLPARAM);
	out.print("\" size=\"");
	out.print(Integer.toString(mNumberOfColsForTextFields));
	out.print("\" maxlength=\"");
	out.print(MAX_TEXTFIELD_SIZE);
	out.println("\">");
	out.println("</td></tr>");

	out.println("<tr><td class=\"LT\">");
	out.print(mLinkTitleString);
	out.println("&nbsp;:");
	out.println("</td><td class=\"LTFIELD\">");
	out.print("<input type=\"TEXT\" value=\"\" name=\"");
	out.print(mLinkTitlePARAM);
	out.print("\" size=\"");
	out.print(Integer.toString(mNumberOfColsForTextFields));
	out.print("\" maxlength=\"");
	out.print(MAX_TEXTFIELD_SIZE);
	out.println("\">");
	out.println("</td></tr>");

	out.println("<tr><td class=\"IMAGEURL\">");
	out.print(mImageURLString);
	out.println("&nbsp;:");
	out.println("</td><td class=\"IMAGEURLFIELD\">");
	out.print("<input type=\"TEXT\" value=\"HTTP://\" name=\"");
	out.print(mImageURLPARAM);
	out.print("\" size=\"");
	out.print(Integer.toString(mNumberOfColsForTextFields));
	out.print("\" maxlength=\"");
	out.print(MAX_TEXTFIELD_SIZE);
	out.println("\">");
	out.println("</td></tr>");

	out.println("</table>");
	out.println("</div>");
	out.println("<div class=\"SUBMITBUTTONS\">");
	out.print("<input type=\"hidden\" name=\"");
	out.print(SUBMITMESSAGEPARAM);
	out.println("\" value=\"NADA\">");
   
	out.print("<input type=\"button\" value=\"");
	if (MessageID == null) {
	    out.print(mSubmitString);
	    out.print("\" name=\"");
	    out.print("toto");
	} else {
	    out.print(mReplyButtonString);
	    out.print("\" name=\"");
	    out.print("toto");
	}
	out.println("\" onClick=\"checkMessage('')\">");
	out.println("</div>");
	
	out.print("</form>");
	out.println();
    }


    /**
     *  
     *
     *@param  out
     *@param  forum
     *@param  mr
     *@param  user
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    private void deleteForm(PrintWriter out, Forum forum, int mr, User user, String servletPath) throws IOException {
	out.print("<div class=\"DELETEMESSAGE\">");
	out.print("<form action=\"");
	out.print(servletPath);
	out.println("\" method=\"post\">");
	out.print("<input type=\"hidden\" name=\"");
	out.print(DELETEMESSAGEPARAM);
	out.print("\" value=\"");
	out.print(Integer.toString(mr));
	out.print("\">");
	out.print("<input type=\"hidden\" name=\"");
	out.print(FORUMFILEPARAM);
	out.print("\" value=\"");
	out.print(forum.mConfigFile.getPath());
	out.print("\">");
	out.print("<input type=\"submit\" value=\"");
	out.print(mDeleteButtonString);
	out.print("\" name=\"");
	out.print("SUBMIT");
	out.print("\">");
	out.println();
	out.print("</form>");
	out.println();
	out.print("</div>");
	out.println();
    }


    /**
     *  
     *
     *@param  out
     *@param  forum
     *@param  mr
     *@param  user
     *@param  servletPath
     *@exception  IOException
     *@since                   0.30
     */
    private void confirmDeleteForm(PrintWriter out, Forum forum, int mr, User user, String servletPath) throws IOException {
	out.print("<div class=\"CONFIRMDELETEMESSAGE\">");
	out.print("<form action=\"");
	out.print(servletPath);
	out.println("\" method=\"post\">");
	out.print("<input type=\"hidden\" name=\"");
	out.print(CONFIRMEDDELETEMESSAGEPARAM);
	out.print("\" value=\"");
	out.print(Integer.toString(mr));
	out.print("\">");
	out.print("<input type=\"hidden\" name=\"");
	out.print(FORUMFILEPARAM);
	out.print("\" value=\"");
	out.print(forum.mConfigFile.getPath());
	out.print("\">");
	out.print("<input type=\"submit\" value=\"");
	out.print(mConfirmDeleteButtonString);
	out.print("\" name=\"");
	out.print("SUBMIT");
	out.println("\">");
	out.println("</form>");
	//  out.println("</td></tr><tr><td>");
	out.print("<form action=\"");
	out.print(servletPath);
	out.println("\" method=\"post\">");
	out.print("<input type=\"hidden\" name=\"");
	out.print(SHOWPARAM);
	out.print("\" value=\"");
	out.print(Integer.toString(mr));
	out.print("\">");
	out.println();
	out.print("<input type=\"hidden\" name=\"");
	out.print(FORUMFILEPARAM);
	out.print("\" value=\"");
	out.print(forum.mConfigFile.getPath());
	out.print("\">");
	out.print("<input type=\"submit\" value=\"");
	out.print(mCancelDeleteButtonString);
	out.print("\" name=\"");
	out.print("SUBMIT");
	out.println("\">");
	out.println("</form>");
	out.print("</div>");
    }

		public String getCharsetEncoding() { return mCharsetEncoding;}
} // end class ForumLocale
