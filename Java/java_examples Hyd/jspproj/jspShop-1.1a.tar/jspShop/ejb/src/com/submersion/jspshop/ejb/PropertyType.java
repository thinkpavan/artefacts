package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;


/** Remote interface for PropertyType entity bean
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.PropertyTypeBean
 * @see com.submersion.jspshop.ejb.PropertyTypeHome
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public interface PropertyType extends EJBObject
{
/*  =====================================
              DataField Methods
    ===================================== */

    public Long getPropertyTypeID() throws RemoteException;

    public Long getPropertyID() throws RemoteException;

    public void setPropertyID(Long propertyID) throws RemoteException;

    public Long getTypeID() throws RemoteException;

    public void setTypeID(Long typeID) throws RemoteException;
}
