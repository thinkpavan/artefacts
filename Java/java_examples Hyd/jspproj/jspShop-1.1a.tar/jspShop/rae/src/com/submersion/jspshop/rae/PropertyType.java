package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import java.util.*;
import com.submersion.jspshop.ejb.*;

/** Access to all the types for one property.
 * 
 * @author Darryl Bleau (darrylbleau@submersion.com)
 * @see com.submersion.jspshop.rae.PropertyTypes
 * @see com.submersion.jspshop.rae.Property
 * @version $Revision$
 * @created: August 29, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class PropertyType extends RAEInstance
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private Long propertyID;
    private Long typeID;
    private com.submersion.jspshop.ejb.PropertyType propertyType = null;
    private PropertyTypeHome propertyTypeHome;
    private TypeValueHome typeValueHome;
    private ValueHome valueHome;

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public PropertyType(Long id)
    {
        super(id);
        this.right = 15;
    }
    
    public PropertyType(Long id, com.submersion.jspshop.ejb.PropertyType propertyType)
    {
        super(id);
        this.propertyType = propertyType;
        initialise();
        this.right = 15;
    }        
    
/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --PropertyID---------------- */
    public Long getPropertyID()
    {
	   if  (propertyType == null)
		   initialise(); //run initialisation because we haven't yet
		   
	   return propertyID;
    }
	
/*  --Types--------------------- */
    public Long getTypeID()
    {
		if (propertyType == null)
			initialise(); //run initialisation because we haven't yet
			
		return typeID;
	}

    public void setTypeID(Long typeID)
    {
        if (propertyType == null)
            initialise(); // run initialisation because we haven't yet
            
        this.typeID = changeTypeID(typeID);
    }

/*  --Delete---------------- */
    public void delete() throws RemoveException
    {
        if (propertyType == null)
            initialise(); // run initialisation because we haven't yet
            
        deletePropertyType(getID());
    }
      
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    private Long changeTypeID(Long typeID)
    {
        try
        {
            propertyType.setTypeID(typeID);
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deletePropertyTypes method in com.submersion.jspshop.rae.PropertyType. " + e.getMessage());
            e.printStackTrace();            
        }
        return typeID;            
    }    
    
    private void deletePropertyType(Long propertyTypeID) throws RemoveException
    {
        try
        {            
            // delete all referenced values to this propertyType
            deleteObjectValues(propertyType.getPropertyID(), propertyType.getTypeID());
            
            // remove the propertyType from the database
            propertyTypeHome.remove(getID());
            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deletePropertyTypes method in com.submersion.jspshop.rae.PropertyType. " + e.getMessage());
            e.printStackTrace();            
        }
    }            
    
    private void deleteObjectValues(Long propertyID, Long typeID) throws RemoveException
    {
        try
        {
            // get iterator of all TypeValues that use typeID
            Iterator iterator = typeValueHome.findByPropertyIDTypeID(propertyID, typeID).iterator();
            
            //iterate through each one
            while (iterator.hasNext())
            {
                // remove the buggers
                typeValueHome.remove(((TypeValue)iterator.next()).getTypeValueID());
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteObjectValues method in com.submersion.jspshop.rae.PropertyType. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteObjectValues method in com.submersion.jspshop.rae.PropertyType. " + e.getMessage());
            e.printStackTrace();
        }
    }    

    protected void initialise()
    {
	    try
        {
            // retrieve the initial context from the container
            InitialContext context = new InitialContext();
            
            // get a reference to the PropertyType entity bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/PropertyType");
            
            // get an instance of the PropertyTypeHome interface
            propertyTypeHome = (PropertyTypeHome)PortableRemoteObject.narrow(homeRef, PropertyTypeHome.class);
            
            // get a reference to the TypeValue entity bean
            homeRef = context.lookup("java:comp/env/ejb/TypeValue");
            
            // get an instance of the TypeValueHome interface
            typeValueHome = (TypeValueHome)PortableRemoteObject.narrow(homeRef, TypeValueHome.class);
            
            // get a reference to the Value entity bean
            homeRef = context.lookup("java:comp/env/ejb/Value");
            
            // get an instance of the ValueHome interface
            valueHome = (ValueHome)PortableRemoteObject.narrow(homeRef, ValueHome.class);
 
            // get a reference to the Type entity bean
            homeRef = context.lookup("java:comp/env/ejb/Type");
            
            // get an instance of the TypeHome interface
            TypeHome typeHome = (TypeHome)PortableRemoteObject.narrow(homeRef, TypeHome.class);
 
			if (propertyType == null)
            {
                // get an instance of the current propertyType using it's ID from constructor
                propertyType = propertyTypeHome.findByPrimaryKey(getID());
            }
			
			// set values on this object
			this.typeID = propertyType.getTypeID();
			this.propertyID = propertyType.getPropertyID();
			
			// get the name from the corresponding Type entity bean
			this.name = typeHome.findByPrimaryKey(typeID).getName();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up Home interfaces in initialise method in com.submersion.jspshop.rae.PropertyType. " + e.getMessage());
            e.printStackTrace();            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.PropertyType. " + e.getMessage());
            e.printStackTrace();            
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.PropertyType. " + e.getMessage());
            e.printStackTrace();
        }    
    }
}
