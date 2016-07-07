package com.submersion.jspshop.propertytag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Deletes a property value
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
        
        deleteProperty(getId(), userID);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void deleteProperty(String valueID, Long userID) throws JspTagException
	{
	    // get instance of Property to delete
	    Property property = new Property(new Long(valueID), userID);
	    try
	    {
    	    // delete the property
    	    property.delete();
        }
        catch (RemoveException e)
        {
            throw new JspTagException("Could not delete Property, DeleteException: " + e.getMessage());
        }        
    }		
}
