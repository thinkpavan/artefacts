package com.submersion.jspshop.typetag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import com.submersion.jspshop.rae.*;

/** Iterates through all Types of a given Property
 *
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.typetag.IterateTEI
 * @version $Revision$
 * @created: September 24, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class IterateTag extends	BodyTagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private Iterator iterator;
    private String valueID;
    private String typeID;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
    /*--ValueID-----------*/	
    public void setValueID(String valueID)
    {
        this.valueID = valueID;
    }
    
    /*--TypeID-----------*/	
    public void setTypeID(String typeID)
    {
        this.typeID = typeID;
    }

        
/*  ================================================v
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspException
	{
        // get the ID of the current person logged in
        HttpSession session = pageContext.getSession();
        Long userID = (Long)session.getAttribute("jspShop.userID");
        
        if (userID == null)
        {
            throw new JspTagException("You are not logged in.");
        }
        
        // get types back
        Types types = new Types(new Long(valueID), userID, new Long(typeID));
        
        // get iterator
        iterator = types.getIterator();
        
        // start iteration
		return doAfterBody();
	}
	
	public int doEndTag()
	{		
		// continue evaluating the page.
		return EVAL_PAGE;
	}
	
	public int doAfterBody() throws JspException
	{
		
		// keep returning EVAL_BODY_TAG until iterator is expired
		// then return SKIP_BODY
	
		if (iterator.hasNext())
		{

            // get the current object from the iterator
	        Type type = (Type)iterator.next();                        
            
            // add the object to the pageContext             
            pageContext.setAttribute(getId(),type);
            
            // add the hasnext stuff
            pageContext.setAttribute(getId() + "HasNext", new Boolean(iterator.hasNext()));
            
            // re-evaluate body to continue iteration
			return BodyTag.EVAL_BODY_TAG;
		}
		else
		{
			try
			{
				// write out any remaining body content
				if (bodyContent != null) 
					bodyContent.writeOut(bodyContent.getEnclosingWriter());
			}
			catch (Exception e)
			{
				throw new JspException("Error occurred writing bodyContent: " + e);
			}
			// all done iteration.
			return BodyTag.SKIP_BODY;
		}
	}	
}