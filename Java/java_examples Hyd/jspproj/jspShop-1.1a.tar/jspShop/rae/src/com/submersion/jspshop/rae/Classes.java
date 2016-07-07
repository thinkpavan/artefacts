package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import com.submersion.jspshop.ejb.*;
import java.util.*;

/** Collection (hashtable) of class objects
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.rae.Class
 * @version $Revision$
 * @created: August 29, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class Classes extends RAECollection
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private ClassHome classHome;
    private ObjectHome objectHome;
    private PropertyHome propertyHome;
    private PropertyTypeHome propertyTypeHome;
    private TypeValueHome typeValueHome;
    private ValueHome valueHome;
    private String parentName = null;

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public Classes()
    {
        initialise();
    }

    public Classes(String parentName)
    {
        this.parentName = parentName;
        initialise(parentName);
    }

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --Item---------------- */
    public com.submersion.jspshop.rae.Class getItem(String className)
    {
        return (com.submersion.jspshop.rae.Class)items.get(className);
    }
    
/*  --Create---------------- */
    public com.submersion.jspshop.rae.Class create(String className, String parentName, String description) throws CreateException
    {
        return createClass(className, parentName, description);
    }    

/*  --Delete---------------- */
    public void delete(String className) throws RemoveException
    {
        deleteClass(className);
    }
            
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    private void deleteClass(String className) throws RemoveException
    {
        try
        {
            if (items.containsKey(className))
            {
                // get an instance of the class
                com.submersion.jspshop.ejb.Class newClass = classHome.findByPrimaryKey(className);
                
                // create context of this class for searching
                StringBuffer context = new StringBuffer();
                context.append("%"); // search variable at the beginning for sql query
                context.append(".");
                context.append(className);
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
                    // remove the class from the hashtable if it is in there
                    items.remove(newClassName);
                }
                // remove all objects linked to this class
                deleteObjects(className);
                // remove all classproperties linked to this class
                deleteClassProperties(className);
                // remove the class from the database
                classHome.remove(className);                
                // remove the class from the hashtable if it is in there
                items.remove(className);            
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteClass method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteClass method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
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
            System.err.println("jspShop: Error connecting to container in deleteClassProperties method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }            
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteClassProperties method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
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
            System.err.println("jspShop: Error connecting to container in deleteProperties method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deletePropertyTypes method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
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
             System.err.println("jspShop: Error connecting to container in deleteObjects method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }                
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteObjects method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
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
            System.err.println("jspShop: Error using finder query in deleteProperties method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
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
            System.err.println("jspShop: Error using finder query in deleteTypes method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }            
    }    
    
    private com.submersion.jspshop.rae.Class createClass(String className, String parentName, String description) throws CreateException
    {
        try
        {
            // create a new class entity bean
            com.submersion.jspshop.ejb.Class newClass = classHome.create(className);
            com.submersion.jspshop.ejb.Class parent = null;
            
            // if parent has been passed
            if (parentName != null && !parentName.equals(""))
            {
                // find that entity bean in the database
                parent = classHome.findByPrimaryKey(parentName);
            }
            else
            {
                // else set it to -1
                parentName = "-1";
            }
            StringBuffer context = new StringBuffer();
            // if we have a parent
            if (parent != null)
            {
                // create a context using stringbuffer (Sure sure, it's not that much faster than string + "." but it is a teeny bit (like, 1 hundred thousanth of a second :)
                
                context.append(".");
                context.append(parentName);
                context.append(parent.getContext());
            }
            else
            {
                context.append(".-1"); // no nulls in database please
            }
            
            // don't want nulls returning from database if description isn't set
            if (description == null)
                description = "";
            
            // set attributes for this property
            newClass.setContext(context.toString());
            newClass.setParentName(parentName);
            newClass.setDescription(description);
            
            // add new class to hashtaable        
            items.put(className, newClass);
            
            // return newly created class 
            return new com.submersion.jspshop.rae.Class(className);
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in createClass method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in createClass method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
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
            
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up home interfaces in preInitialise method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }        
    }
    
    private void initialise()
    {
        try
        {
            // get an instance of the home interface
            preInitialise();
     
             // return an iterator from the ClassHome find query
            Iterator iterator = classHome.findAll().iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }                
    }

    private void initialise(String parentName)
    {
        try
        {
            // get an instance of the home interface
            preInitialise();
     
             // return an iterator from the ClassHome find query
            Iterator iterator = classHome.findByParentName(parentName).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }                
    }

    private void makeHash(Iterator iterator)
    {        
        try
        {
            HashMap childCheck = null;
            if (parentName != null)
            {
                // get all classes that have children
                childCheck = getChildCheck(this.parentName);
            }
            // iterate through the query
            while (iterator.hasNext())
            {
                // get instance of class
                com.submersion.jspshop.ejb.Class ejbClass = (com.submersion.jspshop.ejb.Class)iterator.next();
                
                // get the className of current iteration
                String className = ejbClass.getClassName();
                
                // create wrapper of ClassProperty
                com.submersion.jspshop.rae.Class newClass = new com.submersion.jspshop.rae.Class(className, ejbClass);
                
                if (parentName != null)
                {
                    boolean hasChildren = false;
                    if (childCheck.containsKey(className))
                    {
                        hasChildren = true;
                    }
                    newClass.setHasChildren(hasChildren);
                }
                
                // throw in Hashmap using propertyTypeID
                items.put(className, newClass);
            }                
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in makeHash method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }        
    }

    private HashMap getChildCheck(String context)
    {
        // our return value
        HashMap rval = new HashMap();
        try
        {
            // get list of children that have children
            Iterator iterator = classHome.findByChildCheck(parentName).iterator();
            
            while (iterator.hasNext())
            {
                String className = ((com.submersion.jspshop.ejb.Class)iterator.next()).getClassName();
                rval.put(className, new Boolean(true));
            }
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finderQuery in getChildCheck method in com.submersion.jspshop.rae.Classes. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in getChildCheck method in com.submersion.jspshop.rea.Classes. " + e.getMessage());
            e.printStackTrace();
        }
        return rval;
    }
    
}
