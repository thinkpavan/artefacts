package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;


/** Remote interface for Class entity bean.
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.ClassHome
 * @see com.submersion.jspshop.ejb.ClassBean
 * @version $Revision$
 * Date Created: August 22, 2001
 * Last changed: $Date$
 * Changed by: $Author$
 */
public interface Class extends EJBObject
{
/*  =====================================
              DataField Methods
    ===================================== */

/*  --ClassName-------------------- */
 
    /** Primary key for this entity
     * 
     * @exception RemoteException 
     */
    public String getClassName() throws RemoteException;

/*  --ParentName-------------------- */
 
    /** Returns the primary key for the parent object from which this class inherits properties from
     * 
     * @exception RemoteException 
     */
    public String getParentName() throws RemoteException;
    /** Changes the parent object of the entity (Would only use while moving in tree, or creating)
     * 
     * @exception RemoteException 
     * @param parentName 
     */
    public void setParentName(String parentName) throws RemoteException;

/*  --Context-------------------- */
 
    /** A sort key showing the inheritance line of the class
     * 
     * @exception RemoteException 
     */
    public String getContext() throws RemoteException;
    /** Changes the context (Would only use when moving in tree, or during creation)
     * 
     * @exception RemoteException 
     * @param context 
     */
    public void setContext(String context) throws RemoteException;

/*  --Description-------------------- */
 
    /** Returns description describing the class
     * 
     * @exception RemoteException 
     */
    public String getDescription() throws RemoteException;
    /** Changes the description for this class
     * 
     * @exception RemoteException 
     * @param description 
     */
    public void setDescription(String description) throws RemoteException;
}
