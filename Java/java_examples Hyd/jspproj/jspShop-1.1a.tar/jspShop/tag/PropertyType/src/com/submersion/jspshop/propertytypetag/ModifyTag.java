package com.submersion.jspshop.propertytypetag;

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
        
        modifyPropertyType(getId(), typeID);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void modifyPropertyType(String propertyTypeID, String typeID) throws JspTagException
	{
	    // get instance of the propertyType
	    PropertyType propertyType = new PropertyType(new Long(propertyTypeID));

        // change the name
        propertyType.setTypeID(new Long(typeID));
    }		
}
