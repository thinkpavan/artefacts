package com.submersion.jspshop.classtag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Creates a new class and returns it
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.classtag.CreateTEI
 * @version $Revision$
 * @created: September 16, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class CreateTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String className;
    String description;
    String inheritedFrom;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
	public void setClassName(String className)
	{
	    this.className = className;
	}
	
	public void setDescription(String description)
	{
	    this.description = description;
	}
	
	public void setInheritedFrom(String inheritedFrom)
	{
	    this.inheritedFrom = inheritedFrom;
	}	
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        if (inheritedFrom == null || inheritedFrom.equals(""))
        {
            inheritedFrom = "-1";
        }
        
        if (className.equals(""))
        {
            throw new JspTagException("Invalid className");
        }       
        
        createClass(className, description, inheritedFrom);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void createClass(String className, String description, String inheritedFrom) throws JspTagException
	{
	    // initialise collection for creating
	    Classes classes = new Classes();
	    try
	    {
    	    // create the class
    	    com.submersion.jspshop.rae.Class newClass = classes.create(className, inheritedFrom, description);
    
            // return it in pageContext
            pageContext.setAttribute(getId(), newClass);
        }
        catch (CreateException e)
        {
            throw new JspTagException("Could not create class, CreateException: " + e.getMessage());
        }        
    }		
}
