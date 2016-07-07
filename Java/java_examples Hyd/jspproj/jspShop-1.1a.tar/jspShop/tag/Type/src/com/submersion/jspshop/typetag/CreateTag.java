package com.submersion.jspshop.typetag;

import javax.servlet.jsp.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.ejb.*;
import com.submersion.jspshop.rae.*;

/** Creates a new TypeValue and returns it
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.typetag.CreateTEI
 * @version $Revision$
 * @created: September 26, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class CreateTag extends TagSupport
{
/*  ================================================
	    CLASS AND OBJECT ATTRIBUTES
    ================================================ */    
    String valueID;
    String value;
    String typeID;
    String typeName;
    Property property;
    
/*  ================================================
		PUBLIC METHODS
    ================================================ */	
	public void setValueID(String valueID)
	{
	    this.valueID = valueID;
	}
	
	public void setValue(String value)
	{
	    this.value = value;
	}
	
    public void setTypeID(String typeID)
    {
        this.typeID = typeID;
    }
    
    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }
    public void setProperty(Property property)
    {
        this.property = property;
    }
/*  ================================================
		TAG SPECIFIC
    ================================================ */
	public int doStartTag() throws JspTagException
	{
        // get the ID of the current person logged in
        HttpSession session = pageContext.getSession();
        Long userID = (Long)session.getAttribute("jspShop.userID");
        
        if (userID == null)
        {
            throw new JspTagException("You are not logged in.");
        }        
        if (typeID != null)
        {            
            createType(typeID, value, valueID, userID);
        }
        else if (typeName != null)
        {
            createTypeName(typeName, value, valueID, userID);
        }
        
        return EVAL_BODY_INCLUDE;
	}

/*  ================================================v
		PRIVATE METHODS
    ================================================ */
    private void createTypeName(String typeName, String value, String valueID, Long userID) throws JspTagException
    {
        // figure out which type we're looking at
        TypeName typeNameRAE = new TypeName(typeName);
     
        Types types = null;
        if (property == null)
        {            
            // create for this type
            types = new Types(new Long(valueID), userID);
        }
        else
        {
            types = property.getTypes();
        }
        
        try
        {
            // create the new typeValue
            Type type = types.create(typeNameRAE.getID(), value);
            
            // return it in pageContext
            pageContext.setAttribute(getId(), type);
        }
        catch (CreateException e)
        {
            throw new JspTagException("Could not create TypeValue, CreateException: " + e.getMessage());
        }        
    }
	
	private void createType(String typeID, String value, String valueID, Long userID) throws JspTagException
	{
	    // initialise collection for creating
	    Types types = new Types(new Long(valueID),userID);
	    try
	    {
    	    // create the typeValue
    	    Type type = types.create(new Long(typeID), value);
    
            // return it in pageContext
            pageContext.setAttribute(getId(), type);
        }
        catch (CreateException e)
        {
            throw new JspTagException("Could not create TypeValue, CreateException: " + e.getMessage());
        }        
    }		
}
