package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;


/** Remote interface for the Object entity bean.
 * 
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.ObjectHome
 * @see com.submersion.jspshop.ejb.ObjectBean
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$
*/
public interface Object extends EJBObject
{
/*  =====================================
              DataField Methods
    ===================================== */

/*  --ObjectID-------------------- */
    /** Returns the primary key for this Object.
     * 
     * @exception RemoteException 
     */
    public Long getObjectID() throws RemoteException;

/*  --Context-------------------- */
    /** Returns a sort key that contains the context of this object.
     * 
     * @exception RemoteException 
     */
    public String getContext() throws RemoteException;

    /** Changes the sort key for the context. Should only be used at creation time, or moves within the tree.
     * 
     * @param context 
     * @exception RemoteException 
     */
    public void setContext(String context) throws RemoteException;

/*  --ParentID-------------------- */
    /** Returns the primary key of the Parent Object
     * 
     * @exception RemoteException 
     */
    public Long getParentID() throws RemoteException;

    /** Changes the parent Object for this Object. Should only be used during creation or when moving the object in the Tree.
     * 
     * @param parentID 
     * @exception RemoteException 
     */
    public void setParentID(Long parentID) throws RemoteException;

/*  --Name-------------------- */
    /** Returns the name of the Object
     * 
     * @exception RemoteException 
     */
    public String getName() throws RemoteException;

    /** Changes the name of the object
     * 
     * @param name 
     * @exception RemoteException 
     */
    public void setName(String name) throws RemoteException;

/*  --ClassName-------------------- */
    /** Returns the Class primary key that the object belongs to
     * 
     * @exception RemoteException 
     */
    public String getClassName() throws RemoteException;

    /** Sets the Class Primary Key that the Object belongs to. Should only be done during Creation.
     * 
     * @param className 
     * @exception RemoteException 
     */
    public void setClassName(String className) throws RemoteException;
}
