package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;
import com.evermind.ejb.CounterUtils;

/** <pre>Implementation of the PropertyType Entity Bean using Container Managed Persistance (CMP)
 * 
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.PropertyType
 * @see com.submersion.jspshop.ejb.PropertyTypeHome
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public class PropertyTypeBean implements EntityBean
{
/*  --Class variables-------------------- */
    transient private EntityContext ctx;

/*  --EJB field variables-------------------- */
    public Long typeID;
    public Long propertyTypeID;
    public Long propertyID;

/*  =====================================
              DateField Methods
    ===================================== */

/*  --PropertyTypeID-------------------- */
    public Long getPropertyTypeID()
    {
        return propertyTypeID;
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
    

/*  --PropertyID-------------------- */
    public Long getPropertyID()
    {
        return propertyID;
    }
    public void setPropertyID(Long propertyID)
    {
        this.propertyID = propertyID;
    }

/*  =====================================
              EJB Specific Calls
    ===================================== */
    public Long ejbCreate() throws NamingException, RemoteException, CreateException, FinderException
    {
        this.propertyTypeID = new Long(CounterUtils.getNextID("java:comp/env/ejb/Counter", "com.submersion.jspshop.ejb.PropertyType"));;
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
