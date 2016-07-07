package com.submersion.jspshop.typetag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Deletes a type value
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @version $Revision$
 * @created: September 26, 2001  
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
        // get the ID of the current person logged in
        HttpSession session = pageContext.getSession();
        Long userID = (Long)session.getAttribute("jspShop.userID");
        
        if (userID == null)
        {
            throw new JspTagException("You are not logged in.");
        }        
        
        deleteType(getId(), userID);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void deleteType(String typeValueID, Long userID) throws JspTagException
	{
	    // get instance of Property to delete
	    Type type = new Type(new Long(typeValueID), userID);
	    try
	    {
    	    // delete the property
    	    type.delete();
        }
        catch (RemoveException e)
        {
            throw new JspTagException("Could not delete Type, DeleteException: " + e.getMessage());
        }        
    }		
}
