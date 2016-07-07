package com.submersion.jspshop.propertytypetag;

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
        
        deletePropertyType(getId());
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void deletePropertyType(String propertyTypeID) throws JspTagException
	{
	    // get instance of classProperty to deltee
	    PropertyType propertyType = new PropertyType(new Long(propertyTypeID));
	    try
	    {
    	    // delete the classProperty
    	    propertyType.delete();
        }
        catch (RemoveException e)
        {
            throw new JspTagException("Could not delete PropertyType, DeleteException: " + e.getMessage());
        }        
    }		
}
