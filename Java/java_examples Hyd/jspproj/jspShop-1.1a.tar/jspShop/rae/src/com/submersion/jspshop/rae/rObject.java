package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import com.submersion.jspshop.ejb.*;
import java.util.*;

/** Implementation of an Object
 * 
 * @author Darryl Bleau (darrylbleau@submersion.com)
 * @see com.submersion.jspshop.rae.Objects
 * @see com.submersion.jspshop.rae.Properties
 * @see com.submersion.jspshop.rae.Class
 * @version $Revision$
 * @created: August 29, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class rObject extends RAEInstance
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */        
    private String context;
    private com.submersion.jspshop.ejb.Object object;
    private Long userID;
    private Boolean isAParent = null;
    private String className;
    
    private ObjectHome objectHome;
    private ValueHome valueHome;
    private PropertyHome propertyHome;
    private TypeValueHome typeValueHome;    

/*  ================================================
		CONSTRUCTORS
    ================================================ */
    public rObject(Long context, String name)
    {
        try
        {
            // get a new initialicontext from the container
            InitialContext incontext = new InitialContext();
            
            // get a reference of the Object entity bean
            java.lang.Object homeRef = incontext.lookup("java:comp/env/ejb/Object");
            
            // get an instance of the Object Home interface
            ObjectHome objectHome = (ObjectHome)PortableRemoteObject.narrow(homeRef, ObjectHome.class);
        
            // get instnace of the object
            com.submersion.jspshop.ejb.Object object = objectHome.findByParentIDName(context, name);
        
            this.id = object.getObjectID();
            this.object = object;
            
            initialise();
        }
        catch (ObjectNotFoundException e)
        {
            this.id = new Long(-1);
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error occurred looking up Object home interface in rObject constructor in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error occurred using finder query in rObject constructor in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error occurred connecting to container in rObject constructor in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();            
        }
            
    }
    
    public rObject(Long id, Long userID)
    {
        super(id);
        this.userID = userID;
        initialise();
        this.right = getRights(userID);
    }
    
    public rObject(Long id, com.submersion.jspshop.ejb.Object object, Long userID, int right)
    {
        super(id);
        this.object = object;
        this.right = right;
        this.userID = userID; 
        initialise();
    }
    
/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --Context---------------- */
    public String getContext() throws SecurityException
    {        
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }
        
        
        return context;
    }
    
/* --ClassName--------------- */
    public String getClassName() throws SecurityException
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }
        
        return className;
    }

/*  --Name---------------- */
    public void setName(String name) throws SecurityException
    {
        if ((right & MODIFY) != MODIFY)
        {
            throw new SecurityException("You do not have proper authority for modifying.");
        }

        this.name = changeName(name);
    }

/*  --Class---------------- */
    public com.submersion.jspshop.rae.Class getObjectClass() throws SecurityException
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

        try
        {                     
            return new com.submersion.jspshop.rae.Class(object.getClassName());
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in getObjectClass method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();            
        }
        return null;
    }
    
/*  --Parent---------------- */
    public rObject getParent() throws SecurityException
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }
           
        try
        {            
            return new rObject(object.getParentID(), userID);
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in getParent method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();            
        }
        return null;
    }
    
/*  --Children---------------- */
    public Objects getChildren() throws SecurityException
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }
         
        return new Objects(getID(), false, userID);
    }            

/*  --Right---------------- */
    public int getRight()
    {
        return this.right;
    }
    
/*  --Properties---------------- */
    public com.submersion.jspshop.rae.Properties getProperties()
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

        com.submersion.jspshop.rae.Properties properties = new com.submersion.jspshop.rae.Properties(getID(),right);
        return properties;
    }
    
    public com.submersion.jspshop.rae.Properties getProperties(Long passedID, int queryType)
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }
            
        com.submersion.jspshop.rae.Properties properties = new com.submersion.jspshop.rae.Properties(getID(), passedID, queryType,right);
        return properties;
    }
    
    public com.submersion.jspshop.rae.Properties getProperties(String value, int queryType)
    {
        if ((right & READ) != READ)
        {
            throw new SecurityException("You do not have proper authority for reading.");
        }

        com.submersion.jspshop.rae.Properties properties = new com.submersion.jspshop.rae.Properties(getID(), value, queryType,right);
        return properties;
    }

/*  --hasChildren---------------- */
    
    public boolean getHasChildren()
    {
        if (isAParent == null)
        {
            this.isAParent = new Boolean(false);
            try
            {
                Iterator iterator = objectHome.findByChildCheck(getID()).iterator();
                if (iterator.hasNext())
                {
                    this.isAParent = new Boolean(true);
                }
            }
            catch (FinderException e)
            {
                System.err.println("jspShop: Error occurred using finder query in hasChildren method in com.submersion.jspshop.rae.rObject");
                e.printStackTrace();            
            }
            catch (RemoteException e)
            {
                System.err.println("jspShop: Error connecting to container in hasChildren method in com.submersion.jsphop.rae.rObject");
                e.printStackTrace();
            }
        }
        return isAParent.booleanValue();
    }
    
    public void setHasChildren(boolean hasChildren)
    {
        isAParent = new Boolean(hasChildren);
    }
    
/*  --Delete---------------- */
    public void delete() throws RemoveException
    {
        if ((right & DELETE) != DELETE)
        {
            throw new SecurityException("You do not have proper authority for deleting.");
        }
        deleteObject(getID());
    }
            
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    private void deleteObject(Long objectID) throws RemoveException
    {
        try
        {
            // get an instance of this object
            com.submersion.jspshop.ejb.Object object = objectHome.findByPrimaryKey(objectID);
            
            // create a context for searching
            StringBuffer context = new StringBuffer();
            context.append("%"); // search variable at the beginning for sql query
            context.append(".");
            context.append(objectID);
            context.append(object.getContext());
            
            // find all objects that have this object as a parent
            Iterator iterator = objectHome.findByContext(context.toString()).iterator();
            
            // iterate through all these objects
            while (iterator.hasNext())
            {
                Long newObjectID = ((com.submersion.jspshop.ejb.Object)iterator.next()).getObjectID();
                // remove all properties for this object
                deleteProperties(newObjectID);
                // remove the object from the database
                objectHome.remove(newObjectID);
            }            
            // remove all properties for this object
            deleteProperties(objectID);
            // remove the object from the database
            objectHome.remove(objectID);
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteObject method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteObject method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
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
            System.err.println("jspShop: Error connecting to container in deleteProperties method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteProperties method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
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
            System.err.println("jspShop: Error connecting to container in deleteTypes method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteTypes method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }
    }
       
    protected void initialise()
    {
        try
        {
            // get a new initialicontext from the container
            InitialContext context = new InitialContext();
            
            // get a reference of the Object entity bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Object");
            
            // get an instance of the Object Home interface
            objectHome = (ObjectHome)PortableRemoteObject.narrow(homeRef, ObjectHome.class);
            
            // get a reference of the Value entity bean
            homeRef = context.lookup("java:comp/env/ejb/Value");
            
            // get an instance of the Value Home interface
            valueHome = (ValueHome)PortableRemoteObject.narrow(homeRef, ValueHome.class);
            
            // get a reference of the TypeValue entity bean
            homeRef = context.lookup("java:comp/env/ejb/TypeValue");
            
            // get an instance of the TypeValue Home interface
            typeValueHome = (TypeValueHome)PortableRemoteObject.narrow(homeRef, TypeValueHome.class);

            if (object == null)
            {
                // find an object by it's primary key, as supplied in the constructor
                object = objectHome.findByPrimaryKey(getID());
            }
            
            // set the context for this rObject object
            this.context = object.getContext();
            
            // set the class name for this rObject object
            this.className = object.getClassName();
            
            // set name attribute
            this.name = object.getName();                        
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up Home interfaces in initialise method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();            
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialise method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();            
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialise method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        } 
    }
    
    private int getMyRight(Long userID)
    {        
        // initialise return value
        int rights = 0;
        
        // get all the group IDS and the userID
        String[]  ids = getIDs(userID);
        
        String right = "";
        try
        {
            // go through each ID
            for (int i = 0; i < ids.length; i++)
            {
                right = "";
                Iterator iterator = typeValueHome.findBySecurity(getID(), ids[i], "Security", "Right").iterator();
                if (iterator.hasNext())
                {
                    right = ((TypeValue)iterator.next()).getValue();
        
                    // if it's nothing do nothing            
                    if (right.equals(""))
                    {
                        rights |= 0;
                    }
                    else
                    {
                        // assign new rights
                        rights |= new Integer(right).intValue();
                    }
                }
            }
        }
        catch (FinderException e)
        {            
            System.err.println("jspShop: Error using finder query in getMyRight method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {            
            System.err.println("jspShop: Error connecting to container in getMyRight method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }        
        return rights;
    }
    
    private int getRights(Long userID)
    {
        // initialise return value
        int rights = 0;
        try
        {
            // figure out all the groups that this user belongs to, and then adds the user himself
            String[] ids = getIDs(userID);                  
            // add the current object to the context 
            StringBuffer sbuf = new StringBuffer();
            sbuf.append(".");
            sbuf.append(getID());
            sbuf.append(context);            
            
            // get all the ancestors of this context (and the object itself
            String[] ancestors = split(sbuf.toString(), ".");
            String right = "";
            // go through each ignoring first and last from split
            for (int i = 1; i < ancestors.length - 1; i++)
            {
                // go through all the groups the user belongs to
                for (int j = 0; j < ids.length; j++)
                {
                    right = "";
                    if (!ids[j].equals(""))
                    {
                        Iterator iterator = typeValueHome.findBySecurity(new Long(ancestors[i]), ids[j], "Security", "Right").iterator();
                        
                        if (iterator.hasNext())
                        {
                            right = ((TypeValue)iterator.next()).getValue();
                            // if it's nothing do nothing            
                            if (right.equals(""))
                            {
                                rights |= 0;
                            }
                            else
                            {
                                // assign new rights
                                rights |= new Integer(right).intValue();
                            }
                        }
                    }
                }
            }
        }
        catch (FinderException e)
        {            
            System.err.println("jspShop: Error using finder query in getRights method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {            
            System.err.println("jspShop: Error connecting to container in getRights method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }
        return rights;   
    }
                
    private String[] getIDs(Long userID)
    {
        String[] groups = null;
        try
        {
            // get iterator of values for property "Membership"
            Collection col = valueHome.findByObjectIDProperty(userID, "Membership");
            
            // initialise return string
            groups = new String[col.size() + 1];
            // get iterator
            Iterator iterator = col.iterator();
            
            // initialise array pointer
            int i = 0;
            
            // iterate through each group
            while (iterator.hasNext())
            {
                Value value = (Value)iterator.next();
                groups[i++] = value.getValue();
            }
            // add the userID
            groups[i] = userID.toString();
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in getGroups method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
             System.err.println("jspShop: Error connecting to container in getGroups method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }
            
        return groups;
    }
    
    private String changeName(String name)
    {
        try
        {
            // use private object variable to change the name
            object.setName(name);
            return name;
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in changeName method in com.submersion.jspshop.rae.rObject. " + e.getMessage());
            e.printStackTrace();
        }
        return null;
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
