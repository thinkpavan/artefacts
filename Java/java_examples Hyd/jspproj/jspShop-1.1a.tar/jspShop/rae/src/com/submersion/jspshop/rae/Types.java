package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import java.util.*;
import com.submersion.jspshop.ejb.*;

/** Contains a collection (hashtable) of Type objects.
 *  Use the constructor to determine which query you wish to return.
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.rae.Property
 * @see com.submersion.jspshop.rae.Type
 * @version $Revision$
 * @created: August 23, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class Types extends RAECollection
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private Long valueID;
    private TypeValueHome typeValueHome = null;
    private ValueHome valueHome = null;
    private int right;
    
/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public Types(Long valueID, Long userID)
    {
        try
        {
            preInitialise();
            Value value = valueHome.findByPrimaryKey(valueID);            
            rObject object = new rObject(value.getObjectID(), userID);
            this.right = object.getRight();
            this.valueID = valueID;
            initialise(valueID);
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
    
    public Types(Long valueID, Long userID, Long typeID)
    {
        try
        {
            preInitialise();
            Value value = valueHome.findByPrimaryKey(valueID);            
            rObject object = new rObject(value.getObjectID(), userID);
            this.right = object.getRight();
            this.valueID = valueID;
            initialise(valueID, typeID);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder Query in Types(valueID, userID, typeID) constructor in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in Types(valueID, userID, typeID) constructor in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Types(Long valueID, int right)
    {
        this.right = right;
        this.valueID = valueID;
        initialise(valueID);
    }
    
    public Types(Long valueID, Long typeID, int right)
    {
        this.right = right;
        this.valueID = valueID;
        initialise(valueID, typeID);
    }

    public Types(Long valueID, String passedString, int queryType, int right)
    {
        this.right = right;
        this.valueID = valueID;
        switch (queryType)
        {
            case TYPE:
                initialiseType(valueID, passedString);
            default:
                initialiseValue(valueID, passedString);
        }
    }

    
/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --Item---------------- */
    public Type getItem(Long typeValueID)
    {
        return (Type)items.get(typeValueID);
    }

/*  --Create-------------- */
    public Type create(Long typeID, String value) throws CreateException
    {
        // check rights
        if ((right & CREATE) != CREATE)
        {
            throw new SecurityException("You do not have proper authority for creating.");
        }

        return createType(typeID, value);
    }    
    
/*  --Delete---------------- */
    public void delete(Long typeValueID) throws RemoveException
    {
        // check rights
        if ((right & DELETE) != DELETE)
        {
            throw new SecurityException("You do not have proper authority for deleting.");
        }

        deleteType(typeValueID);
    }
    
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    private Type createType(Long typeID, String value) throws CreateException
    {
        try
        {
            // create a new TypeValue instance
            TypeValue typeValue = typeValueHome.create();
            
            // set the attributes (and the actual string value to blank)
            typeValue.setTypeID(typeID);
            typeValue.setValueID(valueID);
            typeValue.setValue(value);
            
            return new Type(typeValue.getTypeValueID(), this.right);
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in createType method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up propertyTypeHome interfaces in createType method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder Query in createType method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }    
    
    private void deleteType(Long typeValueID) throws RemoveException
    {
        try
        {            
            // destroy typeValue
            typeValueHome.remove(typeValueID);
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteType method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }        
    }
    
    private void initialise(Long valueID)
    {
        try
        {
            // initialise home interface
            preInitialise(); 
            
            // return an iterator from the TypeValueHome find query
            Iterator iterator = typeValueHome.findByValueID(valueID).iterator(); 
            
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder Query in initialise method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }        
    }

    private void initialise(Long valueID, Long typeID)
    {
        try
        {
            // not called with userid, and is not already initialised
            if (valueHome == null)
            {
                //initialise home interface
                preInitialise();
            }
            // return an iterator from the TypeValueHome find query
            Iterator iterator = typeValueHome.findByValueIDType(valueID, typeID).iterator();
    
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder Query in initialise method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }                    
    }

    private void initialiseValue(Long valueID, String value)
    {
        try
        {
            // initialise home interface
            preInitialise();
            
            // return an iterator from the TypeValueHome find query
            Iterator iterator = typeValueHome.findByValueIDValue(valueID, value).iterator();
    
            // create Hash
            makeHash(iterator);

        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder Query in initialiseValue method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseValue method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }          
    }

    private void initialiseType(Long valueID, String type)
    {
        try
        {
            // initialise home interface
            preInitialise();
            
            // return an iterator from the TypeValueHome find query
            Iterator iterator = typeValueHome.findByValueIDType(valueID, type).iterator();
    
            // create Hash
            makeHash(iterator);

        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder Query in initialiseType method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseType method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }          
    }

    private void preInitialise()
    {
        try
        {
            // retrieve the initial context from the container
            InitialContext context = new InitialContext();
            
            // get a reference to the TypeValue entity bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/TypeValue");
            
            // get an instance of the TypeValueHome interface
            typeValueHome = (TypeValueHome)PortableRemoteObject.narrow(homeRef, TypeValueHome.class);
            
            // get a reference to the Value entity bean
            homeRef = context.lookup("java:comp/env/ejb/Value");
            
            // get an instance of the ValueHome interface
            valueHome = (ValueHome)PortableRemoteObject.narrow(homeRef, ValueHome.class);
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up TypeValueHome in preInitialise method in com.submersion.jspshop.rae.Types. " + e.getMessage());
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
                // get the typeValueID of current iteration
                Long typeValueID = ((TypeValue)iterator.next()).getTypeValueID();
                
                // create wrapper of Type
                com.submersion.jspshop.rae.Type type = new com.submersion.jspshop.rae.Type(typeValueID,right);
                
                // throw in Hashmap using typeValueID
                items.put(typeValueID, type);
            }                
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to Container in maksHash method in com.submersion.jspshop.rae.Types. " + e.getMessage());
            e.printStackTrace();
        }                    
    }        
}
