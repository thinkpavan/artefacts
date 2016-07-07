package com.submersion.jspshop.logintag;

import java.util.*;
import java.rmi.RemoteException;
import javax.servlet.jsp.*;
import javax.naming.*;
import javax.rmi.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import java.security.*;
import javax.ejb.*;
import com.submersion.jspshop.ejb.ValueHome;
import com.submersion.jspshop.ejb.Value;
import com.submersion.jspshop.ejb.ValueBean;

/** Checks if a email and password are correct
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.classtag.LoginTEI
 * @version $Revision$
 * @created: September 27, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class LoginTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String email;
    String password;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
	public void setEmail(String email)
	{
	    this.email = email;
	}
	
	public void setPassword(String password)
	{
	    this.password = password;
	}
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        checkLogin(email,password);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void checkLogin(String email, String password) throws JspTagException
	{
        String cryptedPassword;
        try
        {
            // get new instance of MessageDigest
            MessageDigest crypt =  MessageDigest.getInstance("MD5");
            // add the byte stream from string
            crypt.update(password.getBytes());
            // return bytes from digest
            byte digest[] = crypt.digest();
            // for our new value
            StringBuffer hexString = new StringBuffer();
            
            
            for (int i = 0; i < digest.length; i++) 
            {
                hexString.append(hexDigit(digest[i]));
            }                

            // set the value
            cryptedPassword = hexString.toString();
            // reset digest
            crypt.reset();

            // get context from container
            InitialContext context = new InitialContext();
            
            // get reference to Value bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Value");
            
            // get instance of value home interface
            ValueHome valueHome = (ValueHome)PortableRemoteObject.narrow(homeRef, ValueHome.class);
            // find the property value we're looking for.
            Iterator iterator = valueHome.findByPasswordCheck(email, cryptedPassword).iterator();
            if (iterator.hasNext())
            {
                Value value = (Value)iterator.next();
                // valid login
                pageContext.setAttribute("validLogin", new Boolean(true));
                // get the ID of the current person logged in, and set it in session
                HttpSession session = pageContext.getSession();
                session.setAttribute("jspShop.userID", value.getObjectID());
            }
            else
            {
                // invalid login
                pageContext.setAttribute("validLogin", new Boolean(false));                
            }                                    
        }
        catch (NoSuchAlgorithmException e)
        {
            System.err.println("jspShop: Could not get instance of MD5 algorithm. Please fix this!" + e.getMessage());
            e.printStackTrace();
            throw new JspTagException("Error crypting password!: " + e.getMessage());
        }                
        catch (NamingException e)
        {
            System.err.println("jspShop: Could not initialise context in LoginTag");
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Could not connect to container in LoginTag");
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finderQuery in LoginTag");
            e.printStackTrace();
        }                        
    }	

    private String hexDigit(byte x) 
    {   
        /* this code and the other MD5 stuff I got off of http://developer.java.sun.com/developer/onlineTraining/Security/Fundamentals/Security.html */
        StringBuffer sb = new StringBuffer();
        
        char c;
        // First nibble
        c = (char) ((x >> 4) & 0xf);
        if (c > 9) 
        {
            c = (char) ((c - 10) + 'a');
        } 
        else 
        {
            c = (char) (c + '0');
        }        
        sb.append (c);
        
        // Second nibble
        c = (char) (x & 0xf);
        if (c > 9) 
        {
            c = (char)((c - 10) + 'a');
        } 
        else 
        {
            c = (char)(c + '0');
        }
        sb.append (c);
        
        return sb.toString();		
    }	
}
