package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;
import com.evermind.ejb.CounterUtils;

/** <pre>Implementation of the Property entity bean, using Contaner Managed Persistance (CMP)
 * 
 * Properties are used to define an Object.
 * Properties belong to a class, as does an Object.
 * Properties can have multiple types.</pre>
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.PropertyHome
 * @see com.submersion.jspshop.ejb.Property
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public class PropertyBean implements EntityBean
{
/*  --Class variables-------------------- */
    transient private EntityContext ctx;

/*  --EJB field variables-------------------- */
    public Long propertyID;
    public String name;
    public String className;

/*  =====================================
              DateField Methods
    ===================================== */

/*  --PropertyID-------------------- */
    /** Returns the primary key of the property
     * 
     */
    public Long getPropertyID()
    {
        return propertyID;
    }

/*  --Name-------------------- */
    /** Returns the name of the property
     * 
     */
    public String getName()
    {
        return name;
    }

    /** sets the name of the property
     * 
     * @param name 
     */
    public void setName(String name)
    {
        this.name = name;
    }

/*  --ClassName-------------------- */
    /** Returns the class of which the property belongs to
     * 
     */
    public String getClassName()
    {
        return className;
    }

    /** changes the class which the property belongs to. Would only use this during creation.
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
        this.propertyID = new Long(CounterUtils.getNextID("java:comp/env/ejb/Counter", "com.submersion.jspshop.ejb.Property"));
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
