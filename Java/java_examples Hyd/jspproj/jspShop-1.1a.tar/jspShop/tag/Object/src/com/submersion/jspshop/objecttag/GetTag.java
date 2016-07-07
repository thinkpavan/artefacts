package com.submersion.jspshop.objecttag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Returns information from an Object
 * 
 * @author Jeff Davye (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.objecttag.GetTEI
 * @version $Revision$
 * @created: September 26, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class GetTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String objectID;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
    public void setObjectID(String objectID)
    {
        this.objectID = objectID;
    }
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{

        // get the ID of the current person logged in
        HttpSession session = pageContext.getSession();
        Long userID = (Long)session.getAttribute("jspShop.userID");
        
        if (objectID.equals(""))
        {
            throw new JspTagException("Invalid objectID");
        }
        if (userID == null)
        {
            throw new JspTagException("You are not logged in.");
        }

        rObject object = new rObject(new Long(objectID), userID);
        pageContext.setAttribute(getId(), object);        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
}
