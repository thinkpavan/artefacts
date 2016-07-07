package com.submersion.jspshop.classpropertytag;

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
 * @created: September 16, 2001  
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
        
        modifyClassProperty(getId(), this.name);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void modifyClassProperty(String classPropertyID, String name) throws JspTagException
	{
	    // get instance of the proprety
	    ClassProperty property = new ClassProperty(new Long(classPropertyID));

        // change the name
        property.setName(name);
    }		
}
