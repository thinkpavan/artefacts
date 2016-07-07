package com.submersion.jspshop.propertytag;

import java.util.Iterator;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import com.submersion.jspshop.rae.*;

/** Iterates through all Properties of a given Object 
 *
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.propertytag.IterateTEI
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
    private String objectID;
    private String propertyID;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
    /*--ObjectID-----------*/	
    public void setObjectID(String objectID)
    {
        this.objectID = objectID;
    }

    /*--PropertyID-----------*/
    public void setPropertyID(String propertyID)
    {
        this.propertyID = propertyID;
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
            
        // get properties back
        Properties properties = new Properties(new Long(objectID), userID, new Long(propertyID), Properties.PROPERTY);
        
        // get iterator
        iterator = properties.getIterator();
        
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
	        Property property = (Property)iterator.next();                        
            
            // add the object to the pageContext             
            pageContext.setAttribute(getId(),property);
            
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
