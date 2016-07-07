package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import com.submersion.jspshop.ejb.*;

/** Type implementation for Objects. Basically allows modification of a property type value.  
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.rae.Types
 * @version $Revision$
 * @created: August 23, 2001  
 * @changed: $Date$
 * @createdby: $Author$
*/
public class Type extends RAEInstance
{
/*  ================================================
        CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private Long typeID;
    private Long valueID;
    private String value;
    private TypeValue typeValue = null;
    private TypeValueHome typeValueHome;
    private ValueHome valueHome;

/*  ================================================
        CONSTRUCTORS
    ================================================ */
    public Type(Long id, int right)
    {
	    super(id);
        this.right = right;
    } 
    
    public Type(Long id, Long userID)
    {
	    super(id);
        initialise();
        try
        {
            Value value = valueHome.findByPrimaryKey(valueID);            
            rObject object = new rObject(value.getObjectID(), userID);
            this.right = object.getRight();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder Query in Types(valueID, userID) constructor in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in Types(valueID, userID) constructor in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }        
    }     
/*  ================================================
        PUBLIC INTERFACE
    ================================================ */
/*  --ValueID---------------- */
    public Long getValueID() throws SecurityException
    {        
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

        if (typeValue == null)
            initialise(); //initialise if we haven't yet
            
    	return valueID;	
    }
/*  --TypeID---------------- */
    public Long getTypeID() throws SecurityException
    {        
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

        if (typeValue == null)
            initialise(); //initialise if we haven't yet
            
    	return typeID;	
    }
	
/*  --Value---------------- */	
    public void setValue(String value) throws SecurityException
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

    	if (typeValue == null)
    	    initialise(); //initialise if we haven't yet

    	this.value = changeValue(value);
    }
	
    public String getValue() throws SecurityException
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

    	if (typeValue == null)
    	    initialise(); //initialise if we haven't yet

    	return value;
    }

/*  --Delete---------------- */	
    public void delete() throws RemoveException
    {
        // check rights
        if ((right & DELETE) != DELETE)
        {
            throw new SecurityException("You do not have proper authority for deleting.");
        }

        deleteType(getID());
    }
/*  ================================================
        PRIVATE METHODS
    ================================================ */
    private void deleteType(Long typeValueID) throws RemoveException
    {
        try
        {            
            // destroy typeValue
            typeValueHome.remove(typeValueID);
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteType method in com.submersion.jspshop.rae.Type. " + e.getMessage());
            e.printStackTrace();
        }        
    }    
    
    protected void initialise()
    {
        try
        {
            // retrieve initial context from container
       	 	InitialContext context = new InitialContext();
        
            // get a reference of the Type entity bean
        	java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Type");
        
            // get reference of the Type home interface
        	TypeHome typeHome = (TypeHome)PortableRemoteObject.narrow(homeRef, TypeHome.class);
    
        	// get a reference of the TypeValue entity bean
        	homeRef = context.lookup("java:comp/env/ejb/TypeValue");
        
        	// get a reference of the TypeValue home interface        
        	typeValueHome = (TypeValueHome)PortableRemoteObject.narrow(homeRef, TypeValueHome.class);

        	// get a reference of the Value entity bean
        	homeRef = context.lookup("java:comp/env/ejb/Value");
        
        	// get a reference of the Value home interface        
        	valueHome = (ValueHome)PortableRemoteObject.narrow(homeRef, ValueHome.class);            
            
        	// find this individual TypeValue (as specified by Constructor)
        	typeValue = typeValueHome.findByPrimaryKey(getID());
        
        	// set the value
        	value = typeValue.getValue();        
            
            // set typeID
            this.typeID = typeValue.getTypeID();
            
            // set valueID
            this.valueID = typeValue.getValueID();
            
        	// use the typeID in the TypeValue bean to get the name of the type
        	name = typeHome.findByPrimaryKey(typeValue.getTypeID()).getName();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up Home interfaces in initialise method in com.submersion.jspshop.rae.Type. " + e.getMessage());
            e.printStackTrace();            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.Type. " + e.getMessage());
            e.printStackTrace();            
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finderQuery in initialise method in com.submersion.jspshop.rae.Type. " + e.getMessage());
            e.printStackTrace();
        }            
    }        

    private String changeValue(String value)
    {
        try
        {
            // use the private typeValue instance to change the value
        	typeValue.setValue(value);
        	return value;
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in changeValue method in com.submersion.jspshop.rae.Type. " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
