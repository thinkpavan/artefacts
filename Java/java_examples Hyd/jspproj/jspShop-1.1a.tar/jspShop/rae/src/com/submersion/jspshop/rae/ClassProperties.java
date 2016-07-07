package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import com.submersion.jspshop.ejb.*;
import java.util.*;

/** Collection (hashtable) of ClassProperty objects
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.rae.ClassProperty
 * @see com.submersion.jspshop.rae.Class
 * @version $Revision$
 * @created: August 29, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class ClassProperties extends RAECollection
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private String className;
    private PropertyHome propertyHome;
    private ClassHome classHome;
    private ObjectHome objectHome;
    private TypeValueHome typeValueHome;
    private ValueHome valueHome;
    private PropertyTypeHome propertyTypeHome;


/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public ClassProperties(String className, boolean inherit)
    {
        this.className = className;
        initialise(className, inherit);
    }
        

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --Item---------------- */
    public ClassProperty getItem(Long propertyID)
    {
        return (ClassProperty)items.get(propertyID);
    }
        
/*  --Create---------------- */
    public ClassProperty create(String name) throws CreateException
    {
        return createProperty(name);
    }
    
/*  --Delete---------------- */    
    public void delete(Long propertyID) throws RemoveException
    {
        deleteProperty(propertyID);
    }
    
    
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    private void deleteProperty(Long propertyID) throws RemoveException
    {
        try
        {
            if (items.containsKey(propertyID))
            {
                // remove all values associated with the property
                deleteValues(propertyID);
                // remove all propertyType associated with the property.
                deletePropertyTypes(propertyID);
                
                // remove the property from the database
                propertyHome.remove(propertyID);
                
                // remove the property from the hashtable
                items.remove(propertyID);
            }        
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteProperty method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }        
    }    

    private void deleteValues(Long propertyID) throws RemoveException
    {
        try
        {
            // get an iteration of all values with propertyID passed
            Iterator iterator = valueHome.findByPropertyID(propertyID).iterator();
            
            // iterate through each value
            while (iterator.hasNext())
            {
                // get the valueID
                Long valueID = ((Value)iterator.next()).getValueID();
                
                // delete any types from that property
                deleteTypes(valueID);
                
                valueHome.remove(valueID);
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteValues method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteValues method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void deleteTypes(Long valueID) throws RemoveException
    {
        try
        {
            // get an iteration of all typeValues with valueID passed
            Iterator iterator = typeValueHome.findByValueID(valueID).iterator();
            
            // iterate through each typeValue
            while (iterator.hasNext())
            {
                //remove typeValue
                typeValueHome.remove(((TypeValue)iterator.next()).getTypeValueID());
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteTypes method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteTypes method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void deletePropertyTypes(Long propertyID) throws RemoveException
    {
        try
        {
            // get an iteration of all PropertyTypes
            Iterator iterator = propertyTypeHome.findByPropertyID(propertyID).iterator();
            
            // iterate through each propertyType
            while (iterator.hasNext())
            {
                // remove propertyType
                propertyTypeHome.remove(((com.submersion.jspshop.ejb.PropertyType)iterator.next()).getPropertyTypeID());
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deletePropertyTypes method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deletePropertyTypes method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }
    }    

    private ClassProperty createProperty(String name) throws CreateException
    {
        try
        {
            // create an instance of the property
            com.submersion.jspshop.ejb.Property property = propertyHome.create();
            
            // set attributes
            property.setClassName(className);
            property.setName(name);
            
            // get new propertyID
            Long propertyID = property.getPropertyID();
                        
            // create a new ClassProperty
            ClassProperty newProperty = new ClassProperty(propertyID);
            
            // add new property to hashtable
            items.put(propertyID, newProperty);
            
            // return the property back
            return newProperty;
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up property home interface in createProperty method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in createProperty method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in createProperty method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
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
            
            // get a reference to the Property entity bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Property");
            
            // get an instance of the PropertyHome interface
            propertyHome = (PropertyHome)PortableRemoteObject.narrow(homeRef, PropertyHome.class);

            // get a reference to the Class entity bean
            homeRef = context.lookup("java:comp/env/ejb/Class");
            
            // get an instance of the ClassHome interface
            classHome = (ClassHome)PortableRemoteObject.narrow(homeRef, ClassHome.class);

            // get a reference to Object entity bean
            homeRef = context.lookup("java:comp/env/ejb/Object");
            
            // get instance of object home interface
            objectHome = (ObjectHome)PortableRemoteObject.narrow(homeRef, ObjectHome.class);

            // get reference to TypeValue entity bean
            homeRef = context.lookup("java:comp/env/ejb/TypeValue");
            
            // get instance of TypeValueHome
            typeValueHome = (TypeValueHome)PortableRemoteObject.narrow(homeRef, TypeValueHome.class);                        
            
            // get reference to Value entity bean
            homeRef = context.lookup("java:comp/env/ejb/Value");

            // get instance of ValueHome
            valueHome = (ValueHome)PortableRemoteObject.narrow(homeRef, ValueHome.class);
            
            // get reference to PropertyType entity bean
            homeRef = context.lookup("java:comp/env/ejb/PropertyType");

            // get instance of PropertyTypeHome
            propertyTypeHome = (PropertyTypeHome)PortableRemoteObject.narrow(homeRef, PropertyTypeHome.class);
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up home interfaces in preInitialise method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }        
    }
    
    private void initialise(String className, boolean inherit)
    {

        if (!inherit)
        {
            initialiseNoInherit(className);
        }
        else
        {
            initialiseInherit(className);
        }
        
    }
    
    private void initialiseNoInherit(String className)
    {
        try
        {

            // get instances of the home interfaces
            preInitialise();
    
            Iterator iterator = propertyHome.findByClassName(className).iterator();           
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }                
    }        

    private void initialiseInherit(String className)
    {
        try
        {

            // get instances of the home interfaces
            preInitialise();                        
            
            // get an instance of the class
            com.submersion.jspshop.ejb.Class newClass = classHome.findByPrimaryKey(className);
            
            // get the context to the class
            String context = newClass.getContext();
            
            // make sure it has a parent first.
            if (!context.equals("-1"))
            {
                // split the context on "." (to return ancestors)            
                String[] classes = split(context, ".");
                
                // when we split this, the first will be blank, the last will be -1
                // no need to do query on that
                for (int i = 1; i < classes.length - 1; i++)
                {
                    // get all properties for current class
                    Iterator iterator = propertyHome.findByClassName(classes[i]).iterator();
                    // add to hash
                    makeHash(iterator);
                }
            }
                                    
             // return an iterator from the PropertyHome find query for the current class
            Iterator iterator = propertyHome.findByClassName(className).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
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
                // get instance of property 
                com.submersion.jspshop.ejb.Property property = (com.submersion.jspshop.ejb.Property)iterator.next();
                
                // get the propertyID of current iteration
                Long propertyID = property.getPropertyID();
                
                // create wrapper of ClassProperty
                ClassProperty classProperty = new ClassProperty(propertyID,property);
                                
                // throw in Hashmap using propertyTypeID
                items.put(propertyID, classProperty);
            }                
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in makeHash method in com.submersion.jspshop.rae.ClassProperties. " + e.getMessage());
            e.printStackTrace();
        }        
    } 

	private String[] split(String str, String delim) 
	{	
        // for temporarily storing our data
		ArrayList v = new ArrayList();
		
        // initialise current pos
		int cpos = 0;

        // keep going while more delimiters
		while(str.indexOf(delim,cpos) != -1)
		{	
            // delimiter point is where
			int pnt = str.indexOf(delim,cpos);
            // get a substring of the string using current pos and that point
			v.add(str.substring(cpos,pnt));
            // move the current pos past that point
			cpos = pnt + delim.length();
		}
        // add in last element
		v.add(str.substring(cpos,str.length()));

        // create return array
		String[] ret = new String[v.size()];
		for (int i = 0; i < ret.length; i++) 
		{
			ret[i] = (String) v.get(i);
		}
		
		return ret;
	}

}
