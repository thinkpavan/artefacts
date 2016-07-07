package com.submersion.jspshop.classtag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Deletes a class
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
        
        deleteClass(getId());
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void deleteClass(String className) throws JspTagException
	{
	    // get instance of class to delete
	    com.submersion.jspshop.rae.Class newClass = new com.submersion.jspshop.rae.Class(className);
	    try
	    {
    	    // delete the class
    	    newClass.delete();
        }
        catch (RemoveException e)
        {
            throw new JspTagException("Could not delete class, DeleteException: " + e.getMessage());
        }        
    }		
}
