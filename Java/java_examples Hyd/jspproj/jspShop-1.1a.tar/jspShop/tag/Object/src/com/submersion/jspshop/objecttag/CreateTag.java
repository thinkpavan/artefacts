package com.submersion.jspshop.objecttag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Creates a new object and returns it
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.objecttag.CreateTEI
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
    String parentID;
    String className;
    String name;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
	public void setClassName(String className)
	{
	    this.className = className;
	}
	
	public void setName(String name)
	{
	    this.name = name;
	}
	
	public void setParentID(String parentID)
	{
	    this.parentID = parentID;
	}	
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        if (parentID == null || parentID.equals(""))
        {
            parentID = "-1";
        }
        
        if (className.equals(""))
        {
            throw new JspTagException("Invalid className");
        }       

        // get the ID of the current person logged in
        HttpSession session = pageContext.getSession();
        Long userID = (Long)session.getAttribute("jspShop.userID");
 
        if (userID == null)
        {
            throw new JspTagException("You are not logged in.");
        }
        
        createObject(className, name, parentID, userID);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void createObject(String className, String name, String parentID, Long userID) throws JspTagException
	{
	    // initialise collection for creating
	    Objects objects = new Objects(new Long(parentID), false, userID);
	    try
	    {
    	    // create the object
    	    rObject object = objects.create(className, name);
    
            // return it in pageContext
            pageContext.setAttribute(getId(), object);
        }
        catch (CreateException e)
        {
            throw new JspTagException("Could not create object, CreateException: " + e.getMessage());
        }        
    }		
}
