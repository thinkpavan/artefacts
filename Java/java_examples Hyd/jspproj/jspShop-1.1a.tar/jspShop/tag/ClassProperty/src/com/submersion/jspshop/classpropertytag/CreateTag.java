package com.submersion.jspshop.classpropertytag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Creates a new ClassProperty and returns it
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.classpropertytag.CreateTEI
 * @version $Revision$
 * @created: September 17, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class CreateTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
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
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        
        createClassProperty(className, name);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void createClassProperty(String className, String name) throws JspTagException
	{
	    // initialise collection for creating
	    ClassProperties classProperties = new ClassProperties(className,false);
	    
	    try
	    {
    	    // create the classProperty
    	    ClassProperty classProperty = classProperties.create(name);
    
            // return it in pageContext
            pageContext.setAttribute(getId(), classProperty);
        }
        catch (CreateException e)
        {
            throw new JspTagException("Could not create PropertyType, CreateException: " + e.getMessage());
        }        
    }		
}
