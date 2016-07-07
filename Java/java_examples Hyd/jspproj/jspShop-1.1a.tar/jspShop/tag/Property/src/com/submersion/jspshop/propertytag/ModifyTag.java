package com.submersion.jspshop.propertytag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import java.security.*;
import com.submersion.jspshop.rae.*;

/** Modifies a property value
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @version $Revision$
 * @created: September 26, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class ModifyTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String value;
    String propertyName;
    rObject object;
    String objectID;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
	public void setValue(String value)
	{
	    this.value = value;
	}
   
    public void setObject(rObject object)
    {
        this.object = object;
    }
    
    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }
    
    public void setObjectID(String objectID)
    {
        this.objectID = objectID;
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
        
        if (getId() != null)
        {
            modifyProperty(getId(), this.value, userID);
        }
        else if (propertyName != null)
        {            
            modifyPropertyName(propertyName, value, userID); 
        }
        object = null;
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
    private void modifyPropertyName(String propertyName, String value, Long userID) throws JspTagException
    {
        if (object == null)
        {
            object = new rObject(new Long(objectID), userID);
        }
        // list of properties back that match propertyname
        com.submersion.jspshop.rae.Properties properties = object.getProperties(propertyName, com.submersion.jspshop.rae.Properties.PROPERTY);
        
        Iterator iterator = properties.getIterator();
        
        Property property = null;
        if (iterator.hasNext())
        {
            property = (Property)iterator.next();
        }
        else
        {
            try
            {
                // get the class for this name
                ClassProperty classProperty = new ClassProperty(propertyName, object.getClassName());
                property = properties.create(classProperty.getID(), value);
            }
            catch (CreateException e)
            {
                throw new JspTagException("Error occurred creating property!");
            }
        }
                
        String newValue = value;
        if (property.getName().equals("Password"))
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
            
        // change the name
        property.setValue(newValue);                
    }

	private void modifyProperty(String valueID, String value, Long userID) throws JspTagException
	{
	    // get instance of the property value
	    Property property = new Property(new Long(valueID), userID);
        // let's see which property this is

        String newValue = value;
        // if it's the password, crypt it
        if (property.getName().equals("Password"))
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
            
        // change the name
        property.setValue(newValue);
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
