package com.submersion.jspshop.typenametag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Creates a new TypeName and returns it
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.typenametag.CreateTEI
 * @version $Revision$
 * @created: September 25, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class CreateTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String name;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
	
	public void setName(String name)
	{
	    this.name = name;
	}
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        
        createTypeName(name);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void createTypeName(String name) throws JspTagException
	{
	    // initialise collection for creating
	    TypeNames typeNames = new TypeNames();
	    
	    try
	    {
    	    // create the classProperty
    	    TypeName typeName = typeNames.create(name);
    
            // return it in pageContext
            pageContext.setAttribute(getId(), typeName);
        }
        catch (CreateException e)
        {
            throw new JspTagException("Could not create TypeName, CreateException: " + e.getMessage());
        }        
    }		
}
