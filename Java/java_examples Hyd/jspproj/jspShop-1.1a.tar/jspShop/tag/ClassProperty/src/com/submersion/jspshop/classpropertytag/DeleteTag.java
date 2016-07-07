package com.submersion.jspshop.classpropertytag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Deletes a class property
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @version $Revision$
 * @created: September 16, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class DeleteTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        
        deleteClassProperty(getId());
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void deleteClassProperty(String propertyID) throws JspTagException
	{
	    // get instance of classProperty to deltee
	    ClassProperty classProperty = new ClassProperty(new Long(propertyID));
	    try
	    {
    	    // delete the classProperty
    	    classProperty.delete();
        }
        catch (RemoveException e)
        {
            throw new JspTagException("Could not delete ClassProperty, DeleteException: " + e.getMessage());
        }        
    }		
}
