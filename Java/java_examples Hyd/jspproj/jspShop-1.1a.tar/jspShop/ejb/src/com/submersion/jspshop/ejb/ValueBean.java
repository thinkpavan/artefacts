package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;
import com.evermind.ejb.CounterUtils;


/** <pre>Implementation of the Value entity bean using Container Managed Persistance (CMP)
 * 
 * Values are linked to objects and properties.</pre>
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.Value
 * @see com.submersion.jspshop.ejb.ValueHome
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public class ValueBean implements EntityBean
{
/*  --Class variables-------------------- */
    transient private EntityContext ctx;

/*  --EJB field variables-------------------- */
    public Long valueID;
    public Long propertyID;
    public Long objectID;
    public String value;

/*  =====================================
              DateField Methods
    ===================================== */

/*  --ValueID-------------------- */
    /** returns the primary key of the entity bean
     * 
     */
    public Long getValueID()
    {
        return valueID;
    }

/*  --PropertyID-------------------- */
    /** returns the propertyID that the value belongs to
     * 
     */
    public Long getPropertyID()
    {
        return propertyID;
    }

    /** changes the propertyID that the value belongs to. Should only be used during create.
     * 
     * @param propertyID 
     */
    public void setPropertyID(Long propertyID)
    {
        this.propertyID = propertyID;
    }

/*  --ObjectID-------------------- */
    /** returns the objectID that the value is linked to.
     * 
     */
    public Long getObjectID()
    {
        return objectID;
    }

    /** changes the objectID that the value is linked to. Should only be used during creation.
     * 
     * @param objectID 
     */
    public void setObjectID(Long objectID)
    {
        this.objectID = objectID;
    }

/*  --Value-------------------- */
    /** returns the String value of the property
     * 
     */
    public String getValue()
    {
        return value;
    }

    /** changes the String value of the property
     * 
     * @param value 
     */
    public void setValue(String value)
    {
        this.value = value;
    }
/*  =====================================
              EJB Specific Calls
    ===================================== */
    public Long ejbCreate() throws NamingException, RemoteException, CreateException, FinderException
    {
        
        this.valueID = new Long(CounterUtils.getNextID("java:comp/env/ejb/Counter", "com.submersion.jspshop.ejb.Value"));
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
