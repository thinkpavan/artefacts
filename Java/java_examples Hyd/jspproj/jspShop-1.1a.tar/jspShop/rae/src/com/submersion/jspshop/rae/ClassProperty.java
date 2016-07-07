package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import java.util.*;
import com.submersion.jspshop.ejb.*;

/** Makes properties under a Class.
 * 
 * @author Darryl Bleau (darrylbleau@submersion.com)
 * @see com.submersion.jspshop.rae.ClassProperties
 * @see com.submersion.jspshop.rae.Class
 * @see com.submersion.jspshop.rae.Classes
 * @version $Revision$
 * @created: August 29, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class ClassProperty extends RAEInstance
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
	private String className;
    private com.submersion.jspshop.ejb.Property property = null;
    private PropertyHome propertyHome;
    private ClassHome classHome;
    private ObjectHome objectHome;
    private TypeValueHome typeValueHome;
    private ValueHome valueHome;
    private PropertyTypeHome propertyTypeHome;

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public ClassProperty(Long id)
    {
        super(id);
        this.right = 15;
    }
    
    public ClassProperty(Long id, com.submersion.jspshop.ejb.Property property)
    {
        super(id);
        this.right = 15;
        this.property = property;
        initialise();
    }
    
    public ClassProperty(String name, String className)
    {
        try
        {
            // retrieve the initial context from the container
            InitialContext context = new InitialContext();
            
            // get a reference to the Property entity bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Property");
            
            // get an instance of the PropertyHome interface
            PropertyHome propertyHome = (PropertyHome)PortableRemoteObject.narrow(homeRef, PropertyHome.class);
            
            // get a refernce to the Class entity bean
            homeRef = context.lookup("java:comp/env/ejb/Class");
            
            // get an instance of the ClassHome interface...
            ClassHome classHome = (ClassHome)PortableRemoteObject.narrow(homeRef, ClassHome.class);
            
            
            // find the class we're lookin' at
            com.submersion.jspshop.ejb.Class newClass = classHome.findByPrimaryKey(className);
            
            // get the context for this class.
            String newContext = newClass.getContext();

            boolean isFirst = false;
            try
            {
                // go find property for class
                com.submersion.jspshop.ejb.Property property = propertyHome.findByClassNameProperty(className, name);
                isFirst = true;
                this.id = property.getPropertyID();            
                this.right = 15;            
                this.property = property;
            }
            catch (ObjectNotFoundException e)
            {
                // do nothing
            }
            
            // make sure it actually has a parent, and we didn't find it with original class
            if (!newContext.equals("-1") && !isFirst)
            {
                // split on context seperator
                String[] classes = split(newContext, ".");
                
                // go through all the classes, skip the first dot
                for (int i = 1; i < classes.length; i++)
                {
                    try
                    {
                        // go find property for class
                        com.submersion.jspshop.ejb.Property property = propertyHome.findByClassNameProperty(classes[i], name);
                        isFirst = true;
                        this.id = property.getPropertyID();            
                        this.right = 15;            
                        this.property = property;
                        break;                                
                    }
                    catch (ObjectNotFoundException e)
                    {
                        // do nothing
                    }
                }
            }                
            initialise();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up Home interfaces in ClassProperty method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
            e.printStackTrace();            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in ClassProperty method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
            e.printStackTrace();            
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in ClassProperty method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
            e.printStackTrace();
        }     
        
    }
/*  ================================================
		PUBLIC INTERFACE
    ================================================ */
    /* --ClassName----------- */

    public String getClassName()
    {
       if (property == null)
           initialise(); // run initialisation because we haven't yet
           
       return className;
    }

    /* --Name----------------- */

    public void setName(String name)
    {
       if (property == null)
           initialise();
           
       this.name = changeName(name);
    }
    
    /* --PropertyTypes----------- */
    
    public PropertyTypes getTypes()
    {
        return new PropertyTypes(getID());
    }

/*  --Delete---------------- */    
    public void delete() throws RemoveException
    {
        if (property == null)
            initialise();
            
        deleteProperty(getID());
    }    
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    protected void initialise()
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
            
            if (property == null)
            {
                // find an object by it's primary key, as supplied in the constructor
                property = propertyHome.findByPrimaryKey(getID());
            }
            
            // set the values for this object
            this.className = property.getClassName();
            
            // set the name for this object
            this.name = property.getName();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up Home interfaces in initialise method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
            e.printStackTrace();            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
            e.printStackTrace();            
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
            e.printStackTrace();
        } 
    }
    
    private String changeName(String name)
    {
        try
        {
             // use private object variable to change the name
            property.setName(name);
            return name;   
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in changeName method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    private void deleteProperty(Long propertyID) throws RemoveException
    {
        try
        {
            // remove all values associated with the property
            deleteValues(propertyID);
            // remove all propertyType associated with the property.
            deletePropertyTypes(propertyID);
            
            // remove the property from the database
            propertyHome.remove(propertyID);            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteProperty method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
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
            System.err.println("jspShop: Error connecting to container in deleteValues method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
            e.printStackTrace();
        }        
         catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteValues method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
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
            System.err.println("jspShop: Error using finder query in deleteTypes method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
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
            System.err.println("jspShop: Error using finder query in deletePropertyTypes method in com.submersion.jspshop.rae.ClassProperty. " + e.getMessage());
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
