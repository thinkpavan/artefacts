package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;
import com.evermind.ejb.CounterUtils;

/** Implementation of the TypeValue entity bean, using container managed persistance (CMP).
 * 
 * This bean belongs to a property type, which has a property name.
 * 
 * Basically links the values to the Object
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.TypeValue
 * @see com.submersion.jspshop.ejb.TypeValueHome
 * @version $Revision$
 * @created: August 22, 2001  
 * @changed: $Date$
 * @changedBy: $Author$ 
 */
public class TypeValueBean implements EntityBean
{
/*  --Class variables-------------------- */
    transient private EntityContext ctx;

/*  --EJB field variables-------------------- */
    public Long typeValueID;
    public Long valueID;
    public Long typeID;
    public String value;

/*  =====================================
              DateField Methods
    ===================================== */

/*  --TypeValueID-------------------- */
    /** Returns the primary key of the bean.
     * 
     */
    public Long getTypeValueID()
    {
        return typeValueID;
    }

/*  --ValueID-------------------- */
    /** Returns the property value ID
     * 
     */
    public Long getValueID()
    {
        return valueID;
    }

    /** sets the property value ID, should only be used during creation.
     * 
     * @param valueID 
     */
    public void setValueID(Long valueID)
    {
        this.valueID = valueID;
    }

/*  --Value-------------------- */
    /** Returns the string value of the property type
     * 
     */
    public String getValue()
    {
        return value;
    }

    /** sets the string value of the property type
     * 
     * @param value 
     */
    public void setValue(String value)
    {
        this.value = value;
    }

/*  --TypeID-------------------- */
    public Long getTypeID()
    {
	    return typeID;
    }
    
    public void setTypeID(Long typeID)
    {
	    this.typeID = typeID;
    }
    
/*  =====================================
              EJB Specific Calls
    ===================================== */
    public Long ejbCreate() throws NamingException, RemoteException, CreateException, FinderException
    {
        this.typeValueID = new Long(CounterUtils.getNextID("java:comp/env/ejb/Counter", "com.submersion.jspshop.ejb.TypeValue"));
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
