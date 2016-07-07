package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;
import com.evermind.ejb.CounterUtils;

/** <pre>Implementation of the Type Entity Bean using Container Managed Persistance (CMP)
 * 
 * Each Property has one or more types.
 * Each Type has one or more values.
 * Every Object has a Class, which has properties, which have types.</pre>
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.TypeHome
 * @see com.submersion.jspshop.ejb.Type
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public class TypeBean implements EntityBean
{
/*  --Class variables-------------------- */
    transient private EntityContext ctx;

/*  --EJB field variables-------------------- */
    public Long typeID;
    public String name;

/*  =====================================
              DateField Methods
    ===================================== */

/*  --TypeID-------------------- */
    /** Returns the primary key of the entity bean
     * 
     */
    public Long getTypeID()
    {
        return typeID;
    }

/*  --Name-------------------- */
    /** returns the name of the bean
     * 
     */
    public String getName()
    {
        return name;
    }

    /** changes the name for the entity bean
     * 
     * @param name 
     */
    public void setName(String name)
    {
        this.name = name;
    }

/*  =====================================
              EJB Specific Calls
    ===================================== */
    public Long ejbCreate() throws NamingException, RemoteException, CreateException, FinderException
    {
        this.typeID = new Long(CounterUtils.getNextID("java:comp/env/ejb/Counter", "com.submersion.jspshop.ejb.Type"));;
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
