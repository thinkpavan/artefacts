package com.submersion.jspshop.classtag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import com.submersion.jspshop.rae.*;

/** Iterates through all Classes that exist 
 *
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.classtag.IterateTEI
 * @version $Revision$
 * @created: September 27, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class IterateTag extends	BodyTagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private Iterator iterator;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
    
/*  ================================================v
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspException
	{
        // get the ID of the current person logged in
        HttpSession session = pageContext.getSession();
        Long userID = (Long)session.getAttribute("jspShop.userID");
    
        // use this userID more often after we figure out how we're going to restrict classes
    
        // get collection of classes        
        Classes classes = new Classes();

        // get iterator
        iterator = classes.getIterator();
        
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
	        com.submersion.jspshop.rae.Class newClass = (com.submersion.jspshop.rae.Class)iterator.next();                        
            
            // add the object to the pageContext             
            pageContext.setAttribute(getId(),newClass);
            
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
