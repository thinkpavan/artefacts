package com.submersion.jspshop.typenametag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Returns information from a TypeName
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.typenametag.GetTEI
 * @version $Revision$
 * @created: September 25, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class GetTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String typeID;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
    public void setTypeID(String typeID)
    {
        this.typeID = typeID;
    }
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        
        if (typeID.equals(""))
        {
            throw new JspTagException("Invalid TypeID");
        }       

        TypeName typeName = new TypeName(new Long(typeID));
        pageContext.setAttribute(getId(), typeName);        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
}
