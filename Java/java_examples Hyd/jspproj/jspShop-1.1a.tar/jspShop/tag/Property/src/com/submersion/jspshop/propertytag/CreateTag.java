package com.submersion.jspshop.propertytag;

import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import java.security.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Creates a new ClassProperty and returns it
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.propertytag.CreateTEI
 * @version $Revision$
 * @created: September 26, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class CreateTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String objectID;
    String value;
    String propertyID;
    String propertyName;
    rObject object;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
	public void setObjectID(String objectID)
	{
	    this.objectID = objectID;
	}
	
	public void setValue(String value)
	{
	    this.value = value;
	}
	
    public void setPropertyID(String propertyID)
    {
        this.propertyID = propertyID;
    }
    
    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }
    
    public void setObject(rObject object)
    {
        this.object = object;
    }
    
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        // get the ID of the current person logged in
        HttpSession session = pageContext.getSession();
        Long userID = (Long)session.getAttribute("jspShop.userID");
        
        if (userID == null)
        {
            throw new JspTagException("You are not logged in.");
        }        
        if (propertyID != null)
        {
            createProperty(objectID, value, propertyID, userID);
        }
        else
        {
            createPropertyName(objectID, value, propertyName, userID);
        }
        
        object = null;
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
    private void createPropertyName(String objectID, String value, String propertyName, Long userID) throws JspTagException
    {        
        if (object == null)
        {
            object = new rObject(new Long(objectID), userID);
        }
        // get the class for this name
        ClassProperty classProperty = new ClassProperty(propertyName, object.getClassName());
        
        String newValue = value;
        // if it's the password, crypt it
        if (classProperty.getName().equals("Password"))
        {
            try
            {
                // get new instance of MessageDigest
                MessageDigest crypt =  MessageDigest.getInstance("MD5");
                // add the byte stream from string
                crypt.update(value.getBytes());
                // return bytes from digest
                byte digest[] = crypt.digest();
                // for our new value
                StringBuffer hexString = new StringBuffer();
                
                
                for (int i = 0; i < digest.length; i++) 
                {
                    hexString.append(hexDigit(digest[i]));
                }                

                // set the value
                newValue = hexString.toString();
                // reset digest
                crypt.reset();
            }
            catch (NoSuchAlgorithmException e)
            {
                System.err.println("jspShop: Could not get instance of MD5 algorithm. Please fix this!" + e.getMessage());
                e.printStackTrace();
                throw new JspTagException("Error crypting password!: " + e.getMessage());
            }                
        }
            
	    // initialise collection for creating
        Properties properties = object.getProperties("==!(Don't get anything)!==", Properties.PROPERTY);
	    try
	    {
    	    // create the classProperty
    	    Property property = properties.create(classProperty.getID(), newValue);                

            // return it in pageContext
            pageContext.setAttribute(getId(), property);
        }
        catch (CreateException e)
        {
            throw new JspTagException("Could not create PropertyValue, CreateException: " + e.getMessage());
        }        
    }
	
	private void createProperty(String objectID, String value, String propertyID, Long userID) throws JspTagException
	{
        // let's see which property this is
        ClassProperty classProperty = new ClassProperty(new Long(propertyID));
        String newValue = value;
        // if it's the password, crypt it
        if (classProperty.getName().equals("Password"))
        {
            try
            {
                // get new instance of MessageDigest
                MessageDigest crypt =  MessageDigest.getInstance("MD5");
                // add the byte stream from string
                crypt.update(value.getBytes());
                // return bytes from digest
                byte digest[] = crypt.digest();
                // for our new value
                StringBuffer hexString = new StringBuffer();
                
                
                for (int i = 0; i < digest.length; i++) 
                {
                    hexString.append(hexDigit(digest[i]));
                }                

                // set the value
                newValue = hexString.toString();
                // reset digest
                crypt.reset();
            }
            catch (NoSuchAlgorithmException e)
            {
                System.err.println("jspShop: Could not get instance of MD5 algorithm. Please fix this!" + e.getMessage());
                e.printStackTrace();
                throw new JspTagException("Error crypting password!: " + e.getMessage());
            }                
        }
            
	    // initialise collection for creating
	    Properties properties = new Properties(new Long(objectID),userID);
	    try
	    {
    	    // create the classProperty
    	    Property property = properties.create(new Long(propertyID), newValue);                

            // return it in pageContext
            pageContext.setAttribute(getId(), property);
        }
        catch (CreateException e)
        {
            throw new JspTagException("Could not create PropertyValue, CreateException: " + e.getMessage());
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
