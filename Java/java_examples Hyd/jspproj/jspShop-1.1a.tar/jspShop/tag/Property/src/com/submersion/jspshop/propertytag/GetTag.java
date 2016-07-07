package com.submersion.jspshop.propertytag;

import java.util.Iterator;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Returns a property and it's value
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.propertytag.GetTEI
 * @version $Revision$
 * @created: October 9, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class GetTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String objectID;
    String propertyName;
    rObject object;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */

    /* --ObjectID ----------------- */	
    public void setObjectID(String objectID)
    {
        this.objectID = objectID;
    }
    
    /* --PropertyName ----------------- */
    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }    

    /* --Object ----------------- */
	public void setObject(rObject object)
    {
        this.object = object;
    }
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{

        // get the ID of the current person logged in
        HttpSession session = pageContext.getSession();
        Long userID = (Long)session.getAttribute("jspShop.userID");
        
        if (objectID == null || objectID.equals(""))
        {
            throw new JspTagException("Invalid objectID");
        }
        if (propertyName == null || propertyName.equals(""))
        {
            throw new JspTagException("Invalid propertyName");
        }
        if (userID == null)
        {
            throw new JspTagException("You are not logged in.");
        }
        if (object == null)
        {
            object = new rObject(new Long(objectID), userID);
        }
        Properties properties = object.getProperties(propertyName, Properties.PROPERTY);
        Iterator iterator = properties.getIterator();
        Property property = null;
        if (iterator.hasNext())
        {
            property = (Property)iterator.next();
        }

        
        pageContext.setAttribute(getId(), property); 
        object = null;
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
	
}
