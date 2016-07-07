package com.submersion.jspshop.rae;

import java.util.Iterator;
import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import com.submersion.jspshop.ejb.*;

/** <pre>Property implementation for objects. Basically allows you
 *  to change Property values for an object.</pre>
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.rae.Types
 * @see com.submersion.jspshop.rae.Properties
 * @version $Revision$
 * @created: August 23, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class Property extends RAEInstance implements Comparable
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private String value;
    private Long objectID;
    private Value pValue = null;
    private TypeValueHome typeValueHome;
    private ValueHome valueHome;

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public Property(Long id, int right)
    {
        super(id);
        this.right = right;
    }

    public Property(Long id, Long userID)
    {
        super(id);
        initialise();
        rObject object = new rObject(this.objectID, userID);
        this.right = object.getRight();
    }
/*  ================================================
		PUBLIC INTERFACE
    ================================================ */


/*  --ObjectID---------------- */
    public Long getObjectID() throws SecurityException
    {            
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

        if (pValue == null)
            initialise();
        
        return objectID;
    }
    
/*  --Value---------------- */
    public String getValue() throws SecurityException
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

        if (pValue == null)
            initialise();

        return value;
    }

    public void setValue(String value) throws SecurityException
    {
        if ((right & MODIFY) != MODIFY)
        {
            throw new SecurityException("You do not have proper authority for modifying.");
        }

        if (pValue == null)
            initialise();

        this.value = changeValue(value);
    }

/*  --Types---------------- */
    public Types getTypes() throws SecurityException
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

        Types types = new Types(getID(), right);
        return types;
    }
    
    public Types getTypes(Long typeID) throws SecurityException
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

        if (value == null)
            initialise();        

        Types types = new Types(getID(), typeID, right);
        return types;
    }
    
    public Types getTypes(String value) throws SecurityException
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

        if (this.value == null)
            initialise();        

        Types types = new Types(getID(), value, Types.VALUE, right);
        return types;
    }

    /*  --Delete-------------- */
    public void delete() throws RemoveException
    {
        // check rights
        if ((right & DELETE) != DELETE)
        {
            throw new SecurityException("You do not have proper authority for deleting.");
        }

        deleteProperty(getID());
    }

    /*  --compareTo-------------- */
    public int compareTo(java.lang.Object o)
    {
        Property prop = (Property)o;
        return this.value.compareTo(prop.getValue());
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
            System.err.println("jspShop: Error connecting to container in deleteProperty method in com.submersion.jspshop.rae.Property. " + e.getMessage());
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
            System.err.println("jspShop: Error connecting to container in deleteTypes method in com.submersion.jspshop.rae.Property. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteTypes method in com.submersion.jspshop.rae.Property. " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String changeValue(String value)
    {
        try
        {
            pValue.setValue(value);
            return value;
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in changeValue method in com.submersion.jspshop.rae.Property. " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    protected void initialise()
    {
        try
        {
            // retrieve initial context from container
            InitialContext context = new InitialContext();
            
            // get a reference of the Property entity bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Property");
            
            // get reference of the Property home interface
            PropertyHome propertyHome = (PropertyHome)PortableRemoteObject.narrow(homeRef, PropertyHome.class);
    
            // get a reference of the Value entity bean
            homeRef = context.lookup("java:comp/env/ejb/Value");
            
            // get a reference of the Value home interface        
            valueHome = (ValueHome)PortableRemoteObject.narrow(homeRef, ValueHome.class);
            
            // get a reference of the TypeValue entity bean
            homeRef = context.lookup("java:comp/env/ejb/TypeValue");
            
            // get a reference of the TypeValue home interface        
            typeValueHome = (TypeValueHome)PortableRemoteObject.narrow(homeRef, TypeValueHome.class);

            // find this individual Value (as specified by Constructor)
            pValue = valueHome.findByPrimaryKey(getID());
            
            // set the value
            value = pValue.getValue();        
            
            // use the propertyID in the Value bean to get the name of the Property
            name = propertyHome.findByPrimaryKey(pValue.getPropertyID()).getName();
            
            // set the objectID of the value
            this.objectID = pValue.getObjectID();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up Home interfaces in initialise method in com.submersion.jspshop.rae.Property. " + e.getMessage());
            e.printStackTrace();            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.Property. " + e.getMessage());
            e.printStackTrace();            
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.Property. " + e.getMessage());
            e.printStackTrace();
        }            
        
    }
}
