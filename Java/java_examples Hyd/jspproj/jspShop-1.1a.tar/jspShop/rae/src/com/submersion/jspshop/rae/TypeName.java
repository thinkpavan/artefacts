package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;
import com.submersion.jspshop.ejb.*;

/** Let's you create types.
 * 
 * @author Darryl Bleau (darrylbleau@submersion.com)
 * @see com.submersion.jspshop.rae.TypeNames
 * @version $Revision$
 * @created: August 29, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class TypeName extends RAEInstance
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private com.submersion.jspshop.ejb.Type type = null;
    private TypeValueHome typeValueHome;
    private PropertyTypeHome propertyTypeHome;
    private TypeHome typeHome;

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public TypeName(String typeName)
    {
        try
        {
            // retrieve initial context from container
       	 	InitialContext context = new InitialContext();
        
            // get a reference of the Type entity bean
        	java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Type");
        
            // get reference of the Type home interface
        	TypeHome typeHome = (TypeHome)PortableRemoteObject.narrow(homeRef, TypeHome.class);
            
            // find the type for the name
            com.submersion.jspshop.ejb.Type type = typeHome.findByTypeName(typeName);
            
            // set the id
            this.id = type.getTypeID();
            this.type = type;
            initialise();
            
            this.right = 15; // hardcoding right for this stuff right now
          
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up Type interface in Types(typeName, userID) constructor in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder Query in Types(typeName, userID) constructor in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in Types(typeName, userID) constructor in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }        
            
    }

    public TypeName(Long id)
    {
        super(id);
        this.right = 15;
    }    
    
    public TypeName(Long id, com.submersion.jspshop.ejb.Type type)
    {
        super(id);
        this.type = type;
        initialise();
        this.right = 15;
    }

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --Name---------------- */
    public void setName(String name)
    {
        if (type == null)
            initialise();
        this.name = changeName(name);
    }           

/*  --Delete---------------- */    
    public void delete() throws RemoveException
    {
        if (type == null)
            initialise();
        deleteType(getID());
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
            System.err.println("jspShop: Error connecting to container in deleteType method in com.submersion.jspshop.rae.TypeName. " + e.getMessage());
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
            System.err.println("jspShop: Error connecting to container in deletePropertyTypes method in com.submersion.jspshop.rae.TypeName. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
             System.err.println("jspShop: Error using finder query in deletePropertyTypes method in com.submersion.jspshop.rae.TypeName. " + e.getMessage());
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
            System.err.println("jspShop: Error connecting to container in deleteTypeValues method in com.submersion.jspshop.rae.TypeName. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
             System.err.println("jspShop: Error using finder query in deleteTypeValues method in com.submersion.jspshop.rae.TypeName. " + e.getMessage());
            e.printStackTrace();
        }
    }    
    
    protected void initialise()
    {
        try
        {
            // get initialContext from container
            InitialContext context = new InitialContext();
            
            // get a reference to Type entity bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Type");
            
            // get an instance of home
            typeHome = (TypeHome)PortableRemoteObject.narrow(homeRef, TypeHome.class);
            
            // get a refernce to TypeValue entity bean
            homeRef = context.lookup("java:comp/env/ejb/TypeValue");
           
            // get an instance of TypeValue home interface
            typeValueHome = (TypeValueHome)PortableRemoteObject.narrow(homeRef, TypeValueHome.class);

            // get reference to PropertyType entity bean
            homeRef = context.lookup("java:comp/env/ejb/PropertyType");
            
            // get instnace of the PropertyTypeHome interface
            propertyTypeHome = (PropertyTypeHome)PortableRemoteObject.narrow(homeRef, PropertyTypeHome.class);           
            
            if (type == null)
            {
                // find the current Type by it's primary key
                type = typeHome.findByPrimaryKey(getID());
            }
            this.name = type.getName();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up Home interfaces in initialise method in com.submersion.jspshop.rae.TypeName. " + e.getMessage());
            e.printStackTrace();     
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.TypeName. " + e.getMessage());
            e.printStackTrace(); 
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.TypeName. " + e.getMessage());
            e.printStackTrace(); 
        }        
    }
    
    private String changeName(String name)
    {
        try
        {
            type.setName(name);
            return name;
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in changeName method in com.submersion.jspshop.rae.TypeName. " + e.getMessage());
            e.printStackTrace();
        }
        return null;    
    }    
}
