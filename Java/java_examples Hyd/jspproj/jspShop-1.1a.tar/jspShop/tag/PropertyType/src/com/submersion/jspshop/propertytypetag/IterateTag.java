package com.submersion.jspshop.propertytypetag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import com.submersion.jspshop.rae.*;

/** Iterates through all PropertyType children of a given PropertyID 
 *
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.propertytypetag.IterateTEI
 * @version $Revision$
 * @created: September 8, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class IterateTag extends	BodyTagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private Iterator iterator;
    private String propertyID;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
    /*--ClassName-----------*/	
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
    
        // use this userID more often after we figure out how we're going to restrict classes
    
        if (this.propertyID == null)
        {
            return EVAL_PAGE;
        }
        // find all propertytypes that belong to this property
        PropertyTypes propertyTypes = new PropertyTypes(new Long(this.propertyID));
        
        // get iterator
        iterator = propertyTypes.getIterator();   
        
        // start iteration
		return doAfterBody();			
	}
	
	public int doEndTag() 
	{		
		// continue evaluating the page.
		return EVAL_PAGE;
	}
	
	public int doAfterBody() throws JspTagException
	{
		
		// keep returning EVAL_BODY_TAG until iterator is expired
		// then return SKIP_BODY
	
		if (iterator.hasNext())
		{

            // get the current object from the iterator
	        PropertyType propertyType = (PropertyType)iterator.next();
            
            // add the object to the pageContext             
            pageContext.setAttribute(getId(),propertyType);
            
            // add the hasNext boolean to the pageContext
            pageContext.setAttribute(getId() + "HasNext",new Boolean(iterator.hasNext()));
            
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
				throw new JspTagException("Error occurred writing bodyContent: " + e);
			}
			// all done iteration.
			return BodyTag.SKIP_BODY;
        }
	}

        
}
