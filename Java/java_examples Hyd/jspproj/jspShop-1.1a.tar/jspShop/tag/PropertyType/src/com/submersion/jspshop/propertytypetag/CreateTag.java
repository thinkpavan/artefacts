package com.submersion.jspshop.propertytypetag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Creates a new PropertyType and returns it
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.propertytypetag.CreateTEI
 * @version $Revision$
 * @created: September 17, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class CreateTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String propertyID;
    String typeID;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
	public void setPropertyID(String propertyID)
	{
	    this.propertyID = propertyID;
	}
	
	public void setTypeID(String typeID)
	{
	    this.typeID = typeID;
	}
	
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        
        createPropertyType(propertyID, typeID);
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
	private void createPropertyType(String propertyID, String typeID) throws JspTagException
	{
	    // initialise collection for creating
	    PropertyTypes propertyTypes = new PropertyTypes(new Long(propertyID));
	    
	    try
	    {
    	    // create the propertyType
    	    PropertyType propertyType = propertyTypes.create(new Long(typeID));
    
            // return it in pageContext
            pageContext.setAttribute(getId(), propertyType);
        }
        catch (CreateException e)
        {
            throw new JspTagException("Could not create PropertyType, CreateException: " + e.getMessage());
        }        
    }		
}
