package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;
import com.evermind.ejb.CounterUtils;

/** <pre>Implementation of the Object entity bean using CMP (Container managed persistance).
 * 
 * Objects may contain other objects.
 * Objects are defined from a Class object
 * 
 * Objects are setup to make "Trees", like the following:
 * 
 * ROOT - ID = 1
 * |--SubContainer1 - ID = 2
 * |      |-SubContainer1-1 - ID = 3
 * |      |-SubContainer1-2 - ID = 4
 * |            |-SubContainer1-2-3 - ID = 5
 * |-SubContainer2 - ID = 6
 * 
 * 
 * The context for the above containers would look something like this:
 * SubContainer1      = .1
 * SubContainer1-1    = .2.1
 * SubContainer1-2    = .2.1
 * SubContainer1-2-3  = .4.2.1
 * SubContainer2      = .1</pre>
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.Object
 * @see com.submersion.jspshop.ejb.ObjectHome
 * @version $Revision$
 * Date Created: August 22, 2001 
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public class ObjectBean implements EntityBean
{
/*  --Class variables-------------------- */
    transient private EntityContext ctx;

/*  --EJB field variables-------------------- */
    public Long objectID;
    public String context;
    public Long parentID;
    public String name;
    public String className;

/*  =====================================
              DateField Methods
    ===================================== */

/*  --ObjectID-------------------- */
    /** Returns the primary key of the Object
     */
    public Long getObjectID()
    {
        return objectID;
    }

/*  --Context-------------------- */
    /** Returns the context for the Object
     */
    public String getContext()
    {
        return context;
    }
    /** Changes the context for the object. This should only be done during creation, or some sort of moving within the tree
     * 
     * @param context 
     */
    public void setContext(String context)
    {
        this.context = context;
    }

/*  --ParentID-------------------- */
    /** Returns the primary key for the parent object
     */
    public Long getParentID()
    {
        return parentID;
    }
    /** Changes the parent object for the current object. This should only be used during creation or some sort of moving within the tree.
     * 
     * @param parentID 
     */
    public void setParentID(Long parentID)
    {
        this.parentID = parentID;
    }

/*  --Name-------------------- */
    /** Returns the name of the Object
     */
    public String getName()
    {
        return name;
    }
    /** Changes the name of the object
     * 
     * @param name 
     */
    public void setName(String name)
    {
        this.name = name;
    }

/*  --ClassName-------------------- */
    /** Returns the primary key of the Class that the object is a type of.
     */
    public String getClassName()
    {
        return className;
    }
    /** Changes the class that the object is a type of. Should only be used during creation.
     * 
     * @param className 
     */
    public void setClassName(String className)
    {
        this.className = className;
    }
/*  =====================================
              EJB Specific Calls
    ===================================== */
    public Long ejbCreate() throws NamingException, RemoteException, CreateException, FinderException
    {
        this.objectID =  new Long(CounterUtils.getNextID("java:comp/env/ejb/Counter", "com.submersion.jspshop.ejb.Object"));
        return null;
    }

    public void ejbPostCreate()
    {
    }

    public void setEntityContext(EntityContext ctx)
    {
        this.ctx = ctx;
    }

    public void unsetEntityContext()
    {
        ctx = null;
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void ejbLoad()
    {
    }

    public void ejbStore()
    {
    }

    public void ejbRemove()
    {
    }
}
