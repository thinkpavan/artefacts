package com.submersion.jspshop.classtag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import com.submersion.jspshop.rae.*;

/** Iterates through all Class children of a given context 
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.classtag.GetChildrenTEI
 * @version $Revision$
 * @created: September 4, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class GetChildrenTag extends	BodyTagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    Iterator iterator;
    
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
        
        // find all container objects that belong to passed context
        Classes classes = new Classes(getId());

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
            
            // get the attributes from the current object
            String className = newClass.getID();
            Boolean hasChildren = new Boolean(false);
            if (newClass.getHasChildren())
            {
                hasChildren = new Boolean(true);
            }
            
            // set the objectID attribute in the page context
			pageContext.setAttribute("className", className);
			
            // set the children variable in page context            
            pageContext.setAttribute("hasChildren",hasChildren);
            
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
