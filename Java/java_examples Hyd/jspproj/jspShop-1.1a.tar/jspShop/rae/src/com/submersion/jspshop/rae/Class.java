package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import com.submersion.jspshop.ejb.*;
import java.util.*;

/** The Class Implementation
 * 
 * @author Darryl Bleau (darrylbleau@submersion.com)
 * @see com.submersion.jspshop.rae.ClassProperties
 * @see com.submersion.jspshop.rae.ClassProperty
 * @see com.submersion.jspshop.rae.Classes
 * @version $Revision$
 * @created: August 23, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class Class
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private String id;
    private String description;
    private String context;
    private com.submersion.jspshop.ejb.Class newClass;
    private Boolean isAParent = null;
    private ClassHome classHome;
    private ObjectHome objectHome;
    private PropertyHome propertyHome;
    private PropertyTypeHome propertyTypeHome;
    private TypeValueHome typeValueHome;
    private ValueHome valueHome;
    
/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public Class(String id)
    {
        this.id = id;
    }
    
    public Class(String id, com.submersion.jspshop.ejb.Class newClass)
    {
        this.id = id;
        this.newClass = newClass;
    }    

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */
    
    /*--ID-----------------*/
    public String getID()
    {
        return id;
    }
    
    /*--Parent-----------------*/
    public com.submersion.jspshop.rae.Class getParent()
    {
        if (newClass == null)
            initialise();
        try
        {            
            return new com.submersion.jspshop.rae.Class(newClass.getParentName());
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in getParent method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();            
        }
        return null;
    }
    
    /*--Description-----------------*/
    
    public String getDescription()
    {
        if (newClass == null)
            initialise();
            
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = changeDescription(description);
    }
    
    /*--Context-----------------*/
    public String getContext()
    {
        if (newClass == null)
            initialise();
            
        return context;
    }
    
    /*--ClassProperties-----------------*/
    public ClassProperties getProperties(boolean inherit)
    {
        return new ClassProperties(getID(), inherit);
    }    

    /*--HasChildren-----------------*/
    public boolean getHasChildren()
    {        
        if (isAParent == null)
        {
           this.isAParent = new Boolean(false);
           try
           {
                Iterator iterator = classHome.findByChildCheck(getID()).iterator();
                if (iterator.hasNext())
                {
                    this.isAParent = new Boolean(true);
                }                                
           }
           catch (RemoteException e)
           {
               System.err.println("jspShop: Error occurred connecting to container in hasChildren method in com.submersion.jspshop.rae.Class. " + e.getMessage());
               e.printStackTrace();
           }
           catch (FinderException e)
           {
               System.err.println("jspShop: Error occurred using finderQuery in hasChildren method in com.submersion.jspshop.rae.Class. " + e.getMessage());
               e.printStackTrace();
           }
        }
        return isAParent.booleanValue();
    }
    
    public void setHasChildren(boolean hasChildren)
    {
        this.isAParent = new Boolean(hasChildren);
    }

/*  --Delete---------------- */
    public void delete() throws RemoveException
    {
        if (newClass == null)
            initialise();
        
        deleteClass(getID());
    }           
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    private void initialise()
    {
        try
        {
            // retrieve the initial context from the container
            InitialContext context = new InitialContext();
            
            // get a reference to the Class entity bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Class");
            
            // get an instance of the Class interface
            classHome = (ClassHome)PortableRemoteObject.narrow(homeRef, ClassHome.class);

            homeRef = context.lookup("java:comp/env/ejb/Object");
            
            // get instance of object home interface
            objectHome = (ObjectHome)PortableRemoteObject.narrow(homeRef, ObjectHome.class);

            // get reference to TypeValue entity bean
            homeRef = context.lookup("java:comp/env/ejb/TypeValue");
            
            // get instance of TypeValueHome
            typeValueHome = (TypeValueHome)PortableRemoteObject.narrow(homeRef, TypeValueHome.class);                        

            //get reference to PropertyType entity bena
            homeRef = context.lookup("java:comp/env/ejb/PropertyType");        

            // get instance of PropertyTypeHome
            propertyTypeHome = (PropertyTypeHome)PortableRemoteObject.narrow(homeRef, PropertyTypeHome.class);
            
            // get reference to Value entity bean
            homeRef = context.lookup("java:comp/env/ejb/Value");

            // get instance of ValueHome
            valueHome = (ValueHome)PortableRemoteObject.narrow(homeRef, ValueHome.class);

            // get reference to Property entity bean
            homeRef = context.lookup("java:comp/env/ejb/Property");        
            
            // get instance of PropertyHome
            propertyHome = (PropertyHome)PortableRemoteObject.narrow(homeRef, PropertyHome.class);
            
            // find an object by it's primary key, as supplied in the constructor
            newClass = classHome.findByPrimaryKey(getID());
            
            // set the context for this Class
            this.context = newClass.getContext();
            
            // set the description for this Class
            this.description = newClass.getDescription();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up Home interfaces in initialise method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();            
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        } 
    }
    
    private String changeDescription(String description)
    {
        try
        {
            // use private object variable to change the name
            newClass.setDescription(description);
            return description;            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in changeName method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    private void deleteClass(String className) throws RemoveException
    {
        try
        {
            
            // create context of this class for searching
            StringBuffer context = new StringBuffer();
            context.append("%"); // search variable at the beginning for sql query
            context.append(".");
            context.append(this.id);
            context.append(newClass.getContext());
            
            // find all classes that inherit from this class.
            Iterator iterator = classHome.findByContext(context.toString()).iterator();
            
            // iterate through each class
            while (iterator.hasNext())
            {
                // get current class
                String newClassName = ((com.submersion.jspshop.ejb.Class)iterator.next()).getClassName();
                // remove all objects linked to this class
                deleteObjects(newClassName);
                // remove all classproperties linked to this class
                deleteClassProperties(newClassName);
                // remove the class from the database
                classHome.remove(newClassName);                
            }
            // remove all objects linked to this class
            deleteObjects(className);
            // remove all classproperties linked to this class
            deleteClassProperties(className);
            // remove the class from the database
            classHome.remove(className);                
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteClass method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteClass method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        }                
    }
    
    private void deleteClassProperties(String className) throws RemoveException
    {
        try
        {
            // find all Properties for this class
            Iterator iterator = propertyHome.findByClassName(className).iterator();
            
            // iterate through all properties returned
            while (iterator.hasNext())
            {
                // get the propertyID
                Long propertyID = ((com.submersion.jspshop.ejb.Property)iterator.next()).getPropertyID();
                
                // remove all propertyTypes for this property
                deletePropertyTypes(propertyID);
                
                // remove this property
                propertyHome.remove(propertyID);
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteClassProperties method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        }            
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteClassProperties method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        }                
    }
    
    private void  deletePropertyTypes(Long propertyID) throws RemoveException
    {
        try
        {
            // find all property types for this property
            Iterator iterator = propertyTypeHome.findByPropertyID(propertyID).iterator();
            
            // iterate through all propertyTypes returned
            while (iterator.hasNext())
            {
                // remove this propertyType
                propertyTypeHome.remove(((com.submersion.jspshop.ejb.PropertyType)iterator.next()).getPropertyTypeID());
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteProperties method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteClass method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        }                
   }    
    
    private void deleteObjects(String className) throws RemoveException
    {
        try
        {
            // get all objects that belongs to this class
            Iterator iterator = objectHome.findByClassName(className).iterator();
            
            // iterate through all objects returned
            while (iterator.hasNext())
            {
                // get objectID
                Long objectID = ((com.submersion.jspshop.ejb.Object)iterator.next()).getObjectID();
    
                // remove all properties for this object
                deleteProperties(objectID);
    
                // remove the object from the database
                objectHome.remove(objectID);
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteObjects method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        }                
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteObjects method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        }                
    }
    
    private void deleteProperties(Long objectID) throws RemoveException
    {
        try
        {        
            // return an iterator to find all values of this object
            Iterator iterator = valueHome.findByObjectID(objectID).iterator();
            
            // iterate through each value    
            while (iterator.hasNext())
            {
                // get the valueID of this value
                Long valueID = ((Value)iterator.next()).getValueID();
                
                // remove all types for this valueID
                deleteTypes(valueID);
                
                // destroy current value
                valueHome.remove(valueID);
            }
        }
        catch (RemoteException e)
        {
             System.err.println("jspShop: Error connecting to container in deleteProperties method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
       }        
       catch (FinderException e)
       {
           System.err.println("jspShop: Error using finder query in deleteProperties method in com.submersion.jspshop.rae.Class. " + e.getMessage());
           e.printStackTrace();
       }                
    }
    
    private void deleteTypes(Long valueID) throws RemoveException
    {
        try
        {
            // return an iterator to find all typeValues for this value
            Iterator iterator = typeValueHome.findByValueID(valueID).iterator();
            
            // iterate through each typeValue    
            while (iterator.hasNext())
            {
                // remove type
                typeValueHome.remove(((TypeValue)iterator.next()).getTypeValueID());            
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteTypes method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteProperties method in com.submersion.jspshop.rae.Class. " + e.getMessage());
            e.printStackTrace();
        }                
    }    
}
