package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import java.util.*;
import com.submersion.jspshop.ejb.*;

/** Collection (Hashmap) of Property objects
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.rae.PropertyType
 * @see com.submersion.jspshop.rae.ClassProperty
 * @version $Revision$
 * Date Created: August 29, 2001  
 * Last changed: $Date$
 * Changed by: $Author$
*/

public class PropertyTypes extends RAECollection
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private Long propertyID ;
    private PropertyTypeHome propertyTypeHome;
    private TypeValueHome typeValueHome;
    private ValueHome valueHome;

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public PropertyTypes(Long propertyID)
    {
        this.propertyID = propertyID;
        initialise(propertyID);
    }

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --Item---------------- */
    public PropertyType getItem(Long propertyTypeID)
    {
        return (PropertyType)items.get(propertyTypeID);
    }

/*  --Create---------------- */
    public com.submersion.jspshop.rae.PropertyType create(Long typeID) throws CreateException
    {
        return createPropertyType(typeID, propertyID);
    }    

/*  --Delete---------------- */
    public void delete(Long propertyTypeID) throws RemoveException
    {
        deletePropertyType(propertyTypeID);
    }
    
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    private void deletePropertyType(Long propertyTypeID) throws RemoveException
    {
        try
        {
            if (items.containsKey(propertyTypeID))
            {
                
                // get instance of propertyType
                com.submersion.jspshop.ejb.PropertyType propertyType = propertyTypeHome.findByPrimaryKey(propertyTypeID);
                
                // delete all referenced values to this propertyType
                deleteObjectValues(propertyType.getTypeID());
                
                // remove the propertyType from the database
                propertyTypeHome.remove(propertyType.getPropertyTypeID());
                
                // remove the property type from the hashtable
                items.remove(propertyTypeID);
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deletePropertyTypes method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();            
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deletePropertyType method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }
    }            
    
    private void deleteObjectValues(Long typeID) throws RemoveException
    {
        try
        {
            // get iterator of all TypeValues that use typeID
            Iterator iterator = typeValueHome.findByTypeID(typeID).iterator();
            
            //iterate through each one
            while (iterator.hasNext())
            {
                // remove the buggers
                typeValueHome.remove(((TypeValue)iterator.next()).getTypeValueID());
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteObjectValues method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteObjectValues method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }
    }    
    
    private com.submersion.jspshop.rae.PropertyType createPropertyType(Long typeID, Long propertyID) throws CreateException
    {
        try
        {
            // create the property
            com.submersion.jspshop.ejb.PropertyType propertyType = propertyTypeHome.create();
            
            // set the attributes
            propertyType.setTypeID(typeID);
            propertyType.setPropertyID(propertyID);        
                        
            // get current ID
            Long propertyTypeID = propertyType.getPropertyTypeID();
            
            // get an instance of new object
            com.submersion.jspshop.rae.PropertyType newPropertyType = new com.submersion.jspshop.rae.PropertyType(propertyTypeID);
            
            // add to hashtable
            items.put(propertyTypeID,newPropertyType);
            
            // return new propertyType
            return newPropertyType;
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up PropertyTypeHome in createPropertyType method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in createPropertyTypes method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in createPropertyType method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    private void preInitialise()
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

        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up PropertyTypeHome in preInitialise method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }        
    }
    
    private void initialise(Long propertyID)
    {
        try
        {
            // get an instance of the home interface
            preInitialise();
     
             // return an iterator from the PropertyTypeHome find query
            Iterator iterator = propertyTypeHome.findByPropertyID(propertyID).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }                
    }
    
    private void initialise(Long propertyID, Long typeID)
    {
        try
        {
            // get an instance of the home interface
            preInitialise();
     
             // return an iterator from the PropertyTypeHome find query
            Iterator iterator = propertyTypeHome.findByPropertyIDTypeID(propertyID, typeID).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }                
    }

    private void initialise(Long propertyID, String typeName)
    {
        try
        {
            // get an instance of the home interface
            preInitialise();
     
             // return an iterator from the PropertyTypeHome find query
            Iterator iterator = propertyTypeHome.findByPropertyIDTypeName(propertyID, typeName).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }                
    }
    
    private void makeHash(Iterator iterator)
    {
        try
        {
            // iterate through the query
            while (iterator.hasNext())
            {
                // get an instance of the propertytype
                com.submersion.jspshop.ejb.PropertyType propertyType = (com.submersion.jspshop.ejb.PropertyType)iterator.next();
                
                // get the propertyTypeID of current iteration
                Long propertyTypeID = propertyType.getPropertyTypeID();
                
                // create wrapper of PropertyType
                com.submersion.jspshop.rae.PropertyType rPropertyType = new com.submersion.jspshop.rae.PropertyType(propertyTypeID,propertyType);
                
                // throw in Hashmap using propertyTypeID
                items.put(propertyTypeID, rPropertyType);
            }                
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in makeHash method in com.submersion.jspshop.rae.PropertyTypes. " + e.getMessage());
            e.printStackTrace();
        }        
    }    
}
