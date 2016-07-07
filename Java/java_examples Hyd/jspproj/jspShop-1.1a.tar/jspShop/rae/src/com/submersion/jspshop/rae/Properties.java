package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import java.util.*;
import com.submersion.jspshop.ejb.*;

/** Collection (Hashmap) of Property types.
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.rae.Property
 * @see com.submersion.jspshop.rae.Object
 * @version $Revision$
 * @created: August 23, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class Properties extends RAECollection
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private Long objectID;
    private PropertyHome propertyHome = null;
    private ValueHome valueHome = null;
    private TypeValueHome typeValueHome;
    private int right;

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public Properties(Long objectID, Long userID)
    {
        rObject object = new rObject(objectID, userID);
        this.right = object.getRight();
        this.objectID = objectID;
        initialise(objectID);
    }
        
    public Properties(Long objectID, Long userID, Long passedID, int queryType)
    {        
        rObject object = new rObject(objectID, userID);
        this.right = object.getRight();
        this.objectID = objectID;
        switch (queryType)
        {
            case TYPE:
                initialiseType(objectID, passedID);
                break;
            default:
                initialiseProperty(objectID, passedID);
        }
    }
    
    public Properties(Long objectID, int right)
    {
        this.right = right;
        this.objectID = objectID;        
        initialise(objectID);
    }

    public Properties(Long objectID, Long passedID, int queryType, int right)
    {
        this.objectID = objectID;
        this.right = right;
        
        // Since we can't have two constructors with same datatype, I've set up this one
        // To have an queryType. So far, only type or property are valid properties.        
        
        switch (queryType)
        {
            case TYPE:            
                initialiseType(objectID, passedID);
                break;
            default:
                initialiseProperty(objectID, passedID);
        }
    }
    
    public Properties(Long objectID, String passedString, int queryType, int right)
    {
        this.objectID = objectID;
        this.right = right;
        switch (queryType)
        {
            case PROPERTY:
                initialiseProperty(objectID, passedString);
                break;                
            case TYPE:
                initialiseType(objectID, passedString);
                break;
            default:
                initialiseValue(objectID, passedString);
        }                
    }       

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --Item---------------- */    
    public Property getItem(Long valueID)
    {
        return (Property)items.get(valueID);
    }

/*  --Create-------------- */
    public Property create(Long propertyID, String value) throws CreateException
    {
        // check rights
        if ((right & CREATE) != CREATE)
        {
            throw new SecurityException("You do not have proper authority for creating.");
        }

        return createProperty(propertyID, value);
    }

/*  --Delete-------------- */
    public void delete(Long valueID) throws RemoveException
    {
        // check rights
        if ((right & DELETE) != DELETE)
        {
            throw new SecurityException("You do not have proper authority for deleting.");
        }

        deleteProperty(valueID);
    }

    
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    private void deleteProperty(Long valueID) throws RemoveException
    {
        try
        {
            // remove all types linked to this property
            deleteTypes(valueID);
            
            // destroy value
            valueHome.remove(valueID);
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteProperty method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
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
                // remove this type
                typeValueHome.remove(((TypeValue)iterator.next()).getTypeValueID());            
            }
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteTypes method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteTypes method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Property createProperty(Long propertyID, String value) throws CreateException
    {
        try
        {
            // create the new value
            Value newValue = valueHome.create();
            
            // set the attributes of the new Value (and the actual string value to blank)
            newValue.setPropertyID(propertyID);
            newValue.setObjectID(objectID);
            newValue.setValue(value);

            // return the newly create property
            return new Property(newValue.getValueID(), this.right);             
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in createProperty method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in createProperty method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up ValueHome in createProperty method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
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
                   
            // get a reference to the Value entity bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Value");
            
            // get an instance of the ValueHome interface
            valueHome = (ValueHome)PortableRemoteObject.narrow(homeRef, ValueHome.class);        

            // get a reference to the TypeValue entity bean
            homeRef = context.lookup("java:comp/env/ejb/TypeValue");
            
            // get an instance of the TypeValueHome interface
            typeValueHome = (TypeValueHome)PortableRemoteObject.narrow(homeRef, TypeValueHome.class);        

        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up ValueHome in preInitialise method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();            
        }        
    }
    
    private void initialiseValue(Long objectID, String value)
    {
        try
        {
            // get an instance of the home interface
            preInitialise();
     
             // return an iterator from the TypeValueHome find query
            Iterator iterator = valueHome.findByObjectIDValue(objectID, value).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseValue method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseValue method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }        
    }

    private void initialiseProperty(Long objectID, String property)
    {
        try
        {
            // get an instance of the home interface
            preInitialise();
             // return an iterator from the TypeValueHome find query
            Iterator iterator = valueHome.findByObjectIDProperty(objectID, property).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseProperty method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseProperty method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }        
    }

    private void initialiseType(Long objectID, String type)
    {
        try
        {
            // get an instance of the home interface
            preInitialise();
     
             // return an iterator from the TypeValueHome find query
            Iterator iterator = valueHome.findByObjectIDType(objectID, type).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseType method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseType method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }        
    }
    
    private void initialise(Long objectID)
    {
        try
        {
            // get an instance of the home interface
            preInitialise();
     
             // return an iterator from the TypeValueHome find query
            Iterator iterator = valueHome.findByObjectID(objectID).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }        
    }
     
    private void initialiseProperty(Long objectID, Long propertyID)
    {
        try
        {
            preInitialise();
     
             // return an iterator from the TypeValueHome find query
            Iterator iterator = valueHome.findByObjectIDProperty2(objectID, propertyID).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseProperty method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }        
    }
    
    private void initialiseType(Long objectID, Long typeID)
    {
        try
        {
            // get an instance of the home interface
            preInitialise();
     
             // return an iterator from the TypeValueHome find query
            Iterator iterator = valueHome.findByObjectIDType2(objectID, typeID).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseType method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
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
                // get the valueID of current iteration
                Long valueID = ((Value)iterator.next()).getValueID();
                
                // create wrapper of Property
                Property property = new Property(valueID,right);
                
                // throw in Hashmap using valueID
                items.put(valueID, property);
            }                
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in makeHash method in com.submersion.jspshop.rae.Properties. " + e.getMessage());
            e.printStackTrace();
        }        
    }        
}
