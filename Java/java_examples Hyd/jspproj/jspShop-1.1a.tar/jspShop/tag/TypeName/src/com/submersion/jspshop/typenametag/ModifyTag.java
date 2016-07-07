package com.submersion.jspshop.typenametag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Modifies a classproperty
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @version $Revision$
 * @created: September 25, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class ModifyTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String name;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
	public void setName(String name)
	{
	    this.name = name;
	}
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        
        modifyTypeName(getId(), this.name);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void modifyTypeName(String typeID, String name) throws JspTagException
	{
	    // get instance of the TypeName
	    TypeName typeName = new TypeName(new Long(typeID));

        // change the name
        typeName.setName(name);
    }		
}
