package com.submersion.jspshop.rae;

import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;
import java.util.*;
import com.submersion.jspshop.ejb.*;

/** Collection (Hashtable) of Objects
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.rae.rObject
 * @version $Revision$
 * @created: August 23, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public class Objects extends RAECollection
{
/*  ================================================
	CLASS AND OBJECT ATTRIBUTES
    ================================================ */
    private Long context;
    private Long userID;
    private ClassHome classHome;
    private ObjectHome objectHome;
    private PropertyHome propertyHome;
    private PropertyTypeHome propertyTypeHome;
    private TypeValueHome typeValueHome;
    private ValueHome valueHome;
    private int right;
    private HashMap objectRights;
/*  ================================================
		CONSTRUCTORS
    ================================================ */

    public Objects(Long context, Long passedID, boolean subtree, int queryType, Long userID)
    {       
        this.userID = userID;
        this.context = context;
        this.objectRights = getRights(context, userID);
        switch (queryType)
        {
            case TYPE:            
                initialiseType(passedID, subtree);
                break;
            case PROPERTY:
                initialiseProperty(passedID, subtree);
        }
    }

    public Objects(Long context, boolean subtree, Long userID)
    {
        this.context = context;
        this.userID = userID;
        this.objectRights = getRights(context, userID);
        initialiseContext(subtree);
    }
        
    public Objects(Long context, String passedString, boolean subtree, int queryType, Long userID)
    {
        this.context = context;
        this.userID = userID;
        this.objectRights = getRights(context, userID);
        switch (queryType)
        {
            case PROPERTY:
                initialiseProperty(passedString, subtree);
                break;
            case VALUE:
                initialiseValue(passedString, subtree);
                break;
            case TYPE:
                initialiseType(passedString, subtree);
                break;
            case CLASS:
                initialiseClass(passedString, subtree);
        }
    }
    

/*  ================================================
		PUBLIC INTERFACE
    ================================================ */

/*  --Item---------------- */    
    public rObject getItem(Long objectID)
    {        
        return (rObject)items.get(objectID);
    }

/*  --Create---------------- */
    public rObject create(String className, String name) throws CreateException
    {
        //!!!Do a creation here.
        // Get properties associated with class
        // Get types associated with Property
        // Initialise all this with a '' string
        
        if ((right & CREATE) != CREATE)
        {
            throw new SecurityException("You do not have proper authority for creating.");
        }
        
        return createObject(className, name);
    }

/*  --Delete---------------- */
    public void delete(Long objectID) throws RemoveException
    {
        if ((right & DELETE) != DELETE)
        {
            throw new SecurityException("You do not have proper authority for deleting.");
        }
        deleteObject(objectID);
    }
        
/*  ================================================
		PRIVATE METHODS
    ================================================ */
    
    private HashMap getRights(Long context, Long userID)
    {
        HashMap rval = null;
        try
        {
            // get the initialcontext from the container
            InitialContext jndiContext = new InitialContext();
            
            // get a reference to the RightSearch Session bean
            java.lang.Object homeRef = jndiContext.lookup("java:comp/env/ejb/RightSearch");
            
            // get the home interface of the RightSearch session bean
            RightSearchHome rightSearchHome = (RightSearchHome)PortableRemoteObject.narrow(homeRef, RightSearchHome.class);
            
            // create a new session bean
            RightSearch rightSearch = rightSearchHome.create();
            
            // get all the rights for this context
            rval =  rightSearch.doRightSearch(context, userID);
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in getRights method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }    
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up rightSearchHome interface in getRights method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (CreateException e)
        {
            System.err.println("jspShop: Error creating instance of RightSearch session bean in getRights method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        return rval;
    }

    private void deleteObject(Long objectID) throws RemoveException
    {
        try
        {
            if (items.containsKey(objectID))
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
                    // remove the object from the current collection
                    items.remove(newObjectID);
                }            
                // remove all properties for this object
                deleteProperties(objectID);
                // remove the object from the database
                objectHome.remove(objectID);
                // remove the object from the current collection
                items.remove(objectID);
            }        
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in deleteObject method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteObject method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
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
            System.err.println("jspShop: Error connecting to container in deleteProperties method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteProperties method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
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
            System.err.println("jspShop: Error connecting to container in deleteTypes method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in deleteTypes method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
    }
                
    private rObject createObject(String className, String name) throws CreateException
    {
        try
        {
            
            com.submersion.jspshop.ejb.Object parent = null;
            // find parent object if it's not -1
            if (context.longValue() != -1)
            {
                parent = objectHome.findByPrimaryKey(context);
            }
            
    
            // create new Object
            com.submersion.jspshop.ejb.Object object = objectHome.create();
    
            // concatenate new context
            StringBuffer sbuf = new StringBuffer();
            sbuf.append(".");
            sbuf.append(context);
            if (parent != null)
            {
                sbuf.append(parent.getContext());
            }
            
    
            // set object attributes
            object.setName(name);
            object.setClassName(className);
            object.setParentID(context);
            object.setContext(sbuf.toString());
            
            Long objectID = object.getObjectID();
            
            // create a new wrapper class of Object
            rObject newObject = new rObject(objectID, object,userID,this.right);
            
            // add this new wrapper to our current collection
            items.put(objectID, newObject);
            
            // return 1
            return newObject;
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in createObject method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up home interfaces in createObject method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }        
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in createObject method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }    
        
    private void preInitialise()
    {
        try
        {
            // get context from container
            InitialContext context = new InitialContext();
            
            // get reference to object bean
            java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Object");
            
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

            // get reference to Class entity bean
            homeRef = context.lookup("java:comp/env/ejb/Class");        
            
            // get instance of ClassHome
            classHome = (ClassHome)PortableRemoteObject.narrow(homeRef, ClassHome.class);
            
            // if we're looking for the root node, we don't want to check security
            if (this.context.longValue() != -1)
            {
                // figure out what rights the user has to the context
                rObject object = new rObject(this.context, userID);
                this.right = object.getRight();
            }
            else
            {
                this.right = READ;
            }
        }
        catch (NamingException e)
        {
            System.err.println("jspShop: Error looking up home interfaces in preInitialise method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }        
    }    

    private String getContext()
    {
        try
        {
            String parentContext = "";
            if (this.context.longValue() != -1)
            {
                com.submersion.jspshop.ejb.Object object = objectHome.findByPrimaryKey(this.context);
                
                parentContext = object.getContext();
            }
            
            // create a context for searching
            StringBuffer context = new StringBuffer();
            context.append("%"); // search variable at the beginning for sql query
            context.append(".");
            context.append(this.context); // global variable
            context.append(parentContext);
            return context.toString();        
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in getContext method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to the container in getContext method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }

    private void initialiseProperty(String property, boolean subtree)
    {        
        try
        {
            // get object home interface
            preInitialise();
            
            Iterator iterator = null;
            // if it's not going to be subtree
            if (!subtree)
            {
                // do home call with out recursive search
                iterator = objectHome.findByProperty(context, property).iterator();
            }
            else
            {
                String context = getContext();
                iterator = objectHome.findByPropertySub(context, property).iterator();
            }
            
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseProperty method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseProperty method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }                        
    }    

    private void initialiseContext(boolean subtree)
    {
        try
        {            
            // get object home interface
            preInitialise();
            
            Iterator iterator = null;
            
            // subtree or not subtree search
            if (!subtree)
            {            
                iterator = objectHome.findByContext2(this.context).iterator();
            }
            else
            {
                String context = getContext();
                iterator = objectHome.findByContext(context).iterator();
            }
            // create hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseAll method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseAll method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }                        
    }
    
    
    private void initialiseClass(String className, boolean subtree)
    {
        try
        {
            // get object home interface
            preInitialise();
            
            Iterator iterator = null;
            
            if (!subtree)
            {
                // get Iterator of all objects based on class
                iterator = objectHome.findByClassName2(context, className).iterator();                
            }
            else
            {
                String context = getContext();
                iterator = objectHome.findByClassNameSub(context, className).iterator();
            }            
            // create hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseClass method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseClass method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }                                
    }

    private void initialiseValue(String value, boolean subtree)
    {
        try
        {
            // get object home interface
            preInitialise();
            
            Iterator iterator = null;
            
            // if it's not going to be subtree
            if (!subtree)
            {
                // do home call with out recursive search
                iterator = objectHome.findByValue(context,value).iterator();
            }
            else
            {
                String context = getContext();
                // recursive tree search
                iterator = objectHome.findByValueSub(context, value).iterator();
            }

            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseValue method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseValue method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }        
    }
 
    private void initialiseType(String type, boolean subtree)
    {
        try
        {
            // get object home interface
            preInitialise();
            
            Iterator iterator = null;
            
            // if it's not going to be subtree
            if (!subtree)
            {
                // do home call with out recursive search
                iterator = objectHome.findByType(context,type).iterator();
            }
            else
            {
                String context = getContext();
                // recursive tree search
                iterator = objectHome.findByTypeSub(context,type).iterator();
            }
            
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseType method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseType method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }        
        
    }
    
    private void initialiseProperty(Long propertyID, boolean subtree)
    {
        try
        {
            // get object home interface
            preInitialise();
            
            Iterator iterator = null;
            
            // if it's not going to be subtree
            if (!subtree)
            {
                // do home call with out recursive search
                iterator = objectHome.findByProperty2(context,propertyID).iterator();
            }
            else
            {
                String context = getContext();
                // recursive tree search
                iterator = objectHome.findByPropertySub2(context,propertyID).iterator();
            }
            
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseProperty method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseProperty method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }                
    }
    
    private void initialiseType(Long typeID, boolean subtree)
    {
        try
        {
            // get object home interface
            preInitialise();
            
            Iterator iterator = null;
            
            // if it's not going to be subtree
            if (!subtree)
            {
                // do home call with out recursive search
                iterator = objectHome.findByType2(context, typeID).iterator();
            }
            else
            {
                String context = getContext();
                // recursive tree search
                iterator = objectHome.findByTypeSub2(context, typeID).iterator();
            }
            
            // create Hash
            makeHash(iterator);
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finder query in initialiseType method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in initialiseType method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }                
    }
        
    private void makeHash(Iterator iterator)
    {
        try
        {
            HashMap childCheck = getChildCheck(this.context);
            // iterate through iterator
            while (iterator.hasNext())
            {
                // get Object
                com.submersion.jspshop.ejb.Object object = (com.submersion.jspshop.ejb.Object)iterator.next();
                // get the current rights of this context
                int objectRight = this.right;
                // get this objects objectID 
                Long objectID = object.getObjectID();
                if (objectRights.containsKey(objectID))
                {
                    objectRight |= new Integer((String)objectRights.get(objectID)).intValue();
                }
                boolean hasChildren = false;
                if (childCheck.containsKey(objectID))
                {
                    hasChildren = true;
                }
                rObject newObject = new rObject(objectID, object,userID,objectRight);
                
                newObject.setHasChildren(hasChildren);
                
                items.put(objectID,newObject);
            }                     
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in makeHash method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }            
    }        

    private HashMap getChildCheck(Long context)
    {
        // our return value
        HashMap rval = new HashMap();
        try
        {
            // get list of children that have children
            Iterator iterator = objectHome.findByChildCheck(context).iterator();
            
            while (iterator.hasNext())
            {
                Long objectID = ((com.submersion.jspshop.ejb.Object)iterator.next()).getObjectID();
                rval.put(objectID, new Boolean(true));
            }
        }
        catch (FinderException e)
        {
            System.err.println("jspShop: Error using finderQuery in getChildCheck method in com.submersion.jspshop.rae.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("jspShop: Error connecting to container in getChildCheck method in com.submersion.jspshop.rea.Objects. " + e.getMessage());
            e.printStackTrace();
        }
        return rval;
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
