package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;


/** Remote interface for Type Entity bean
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.TypeBean
 * @see com.submersion.jspshop.ejb.TypeHome
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public interface Type extends EJBObject
{
/*  =====================================
              DataField Methods
    ===================================== */

/*  --TypeID-------------------- */
    /** returns the primary key for Type 
     * 
     * @exception RemoteException 
     */
    public Long getTypeID() throws RemoteException;

/*  --Name-------------------- */
    /** Returns the name of the type
     * 
     * @exception RemoteException 
     */
    public String getName() throws RemoteException;

    /** Sets the name of the type
     * 
     * @exception RemoteException 
     * @param name 
     */
    public void setName(String name) throws RemoteException;
}
