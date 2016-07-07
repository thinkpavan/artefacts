package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import java.util.*;
import com.submersion.jspshop.ejb.*;

/** Collection (Hashmap) of TypeName
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.rae.TypeName
 * @version $Revision$
 * @created: August 23, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class TypeNames extends RAECollection
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private TypeHome typeHome;
    private TypeValueHome typeValueHome;
    private PropertyTypeHome propertyTypeHome;
/*  ================================================
		CONSTRUCTORS
    ================================================ */

    public TypeNames()
    {
        initialise();
    }
    
/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --Count---------------- */
    public int getCount()
    {
        return items.size();
    }
    
/*  --Item---------------- */
    public TypeName getItem(Long typeID)
    {
        return (TypeName)items.get(typeID);
    }
        
/*  --Create---------------- */
    public TypeName create(String name) throws CreateException
    {
        try
        {
            com.submersion.jspshop.ejb.Type type = typeHome.create();
            type.setName(name);
            return new TypeName(type.getTypeID());
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in create method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error using TypeHome.create() in create method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in create method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
/*  --Delete---------------- */
    public void delete(Long typeID) throws RemoveException
    {
        deleteType(typeID);
    }
/*  ================================================
		PRIVATE METHODS
    ================================================ */

    private void deleteType(Long typeID) throws RemoveException
    {
        try
        {
            deleteTypeValues(typeID);
            deletePropertyTypes(typeID);
            typeHome.remove(typeID);                        
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteType method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void deleteTypeValues(Long typeID) throws RemoveException
    {
        try
        {
            // find all typevalues that belong to this typeid
            Iterator iterator = typeValueHome.findByTypeID(typeID).iterator();
            
            // iterate through each
            while (iterator.hasNext())
            {
                // get the typeValueID
                Long typeValueID = ((TypeValue)iterator.next()).getTypeValueID();
                
                // delete it
                typeValueHome.remove(typeValueID);
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteTypeValues method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
             System.err.println("jspShop: Error using finder query in deleteTypeValues method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void deletePropertyTypes(Long typeID) throws RemoveException
    {
        try
        {
            // find all the propertytypes that belong to this typeid
            Iterator iterator = propertyTypeHome.findByTypeID(typeID).iterator();
            
            // iterate through each
            while (iterator.hasNext())
            {
                // get the propertyTypeID
                Long propertyTypeID = ((com.submersion.jspshop.ejb.PropertyType)iterator.next()).getPropertyTypeID();
                
                // delete it
                propertyTypeHome.remove(propertyTypeID);
            }
        }
         catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deletePropertyTypes method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
             System.err.println("jspShop: Error using finder query in deletePropertyTypes method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }       
    }
    
    private void preInitialise()
    {
        try
        {
            // get context from container
            InitialContext context = new InitialContext();
            
            // get reference of Type entity bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Type");
            
            // Get an instance of the typeHome
            typeHome = (TypeHome)PortableRemoteObject.narrow(homeRef, TypeHome.class);
            
            // get reference to TypeValue entity bean
            homeRef = context.lookup("java:comp/env/ejb/TypeValue");
            
            // get an instance of the TypeValueHome interface
            typeValueHome = (TypeValueHome)PortableRemoteObject.narrow(homeRef, TypeValueHome.class);
            
            // get reference to PropertyType entity bean
            homeRef = context.lookup("java:comp/env/ejb/PropertyType");
            
            // get instnace of the PropertyTypeHome interface
            propertyTypeHome = (PropertyTypeHome)PortableRemoteObject.narrow(homeRef, PropertyTypeHome.class);
            
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up TypeHome in preInitialise method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }
    }    

    
    private void initialise()
    {
        try
        {
            // initialise home interface
            preInitialise();
            
            // get iterator
            Iterator iterator = typeHome.findAll().iterator();
            // make a hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
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
                
                // get the type object back
                com.submersion.jspshop.ejb.Type type = (com.submersion.jspshop.ejb.Type)iterator.next();
                // get the typeID of current iteration
                Long typeID = type.getTypeID();
                // create wrapper of Type
                TypeName typeName = new TypeName(typeID, type);
                
                // throw in Hashmap using typeID
                items.put(typeID, typeName);
            }                        
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in makeHash method in com.submersion.jspshop.rae.TypeNames. " + e.getMessage());
            e.printStackTrace();
        }            
    }    
}
