package com.submersion.jspshop.typenametag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Deletes a type name
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @version $Revision$
 * @created: September 25, 2001  
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
        
        deleteTypeName(getId());
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void deleteTypeName(String typeID) throws JspTagException
	{
	    // get instance of TypeName to delete
	    TypeName typeName = new TypeName(new Long(typeID));
	    try
	    {
    	    // delete the TypeName
    	    typeName.delete();
        }
        catch (RemoveException e)
        {
            throw new JspTagException("Could not delete TypeName, DeleteException: " + e.getMessage());
        }        
    }		
}
