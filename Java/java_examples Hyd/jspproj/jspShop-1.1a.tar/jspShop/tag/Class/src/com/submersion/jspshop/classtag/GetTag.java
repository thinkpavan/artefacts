package com.submersion.jspshop.classtag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Returns information from a Class
 * 
 * @author Darryl Bleau (darrylbleau@submersion.com)
 * @see com.submersion.jspshop.classtag.GetTEI
 * @version $Revision$
 * @created: September 24, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class GetTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String className;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
    public void setClassName(String className)
    {
        this.className = className;
    }
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        
        if (className.equals(""))
        {
            throw new JspTagException("Invalid className");
        }       

        com.submersion.jspshop.rae.Class newClass = new com.submersion.jspshop.rae.Class(className);
        pageContext.setAttribute(getId(), newClass);        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
}
