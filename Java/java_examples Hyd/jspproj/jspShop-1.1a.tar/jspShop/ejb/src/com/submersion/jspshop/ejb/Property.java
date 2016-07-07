package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;

/** Remote interface for Property entity bean
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.PropertyHome
 * @see com.submersion.jspshop.ejb.PropertyBean
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public interface Property extends EJBObject
{
/*  =====================================
              DataField Methods
    ===================================== */

/*  --PropertyID-------------------- */
    /** Returns the primary key for the property
     * 
     * @exception RemoteException 
     */
    public Long getPropertyID() throws RemoteException;

/*  --Name-------------------- */
    /** Returns the name of the property
     * 
     * @exception RemoteException 
     */
    public String getName() throws RemoteException;

    /** Changes the name of the property
     * 
     * @exception RemoteException 
     * @param name 
     */
    public void setName(String name) throws RemoteException;

/*  --ClassName-------------------- */
    /** Returns the Class key which the property belongs to.
     * 
     * @exception RemoteException 
     */
    public String getClassName() throws RemoteException;

    /** Changes the class key of which the property belongs. Would only use this during create.
     * 
     * @exception RemoteException 
     * @param className 
     */
    public void setClassName(String className) throws RemoteException;
}
