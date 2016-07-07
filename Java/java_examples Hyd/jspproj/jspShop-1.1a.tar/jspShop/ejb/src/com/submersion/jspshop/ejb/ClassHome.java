package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;


/** Home interface for the Class Entity bean
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.Class
 * @see com.submersion.jspshop.ejb.ClassBean
 * @version $Revision$
 * Date Created: August 22, 2001 
 * Last changed: $Date$
 * Changed by: $Author$
*/
public interface ClassHome extends EJBHome
{
/*  =====================================
              Finder Queries.
    ===================================== */

    /** Creates a new instance of an entity bean. Returns the new instance.
     * 
     * @exception CreateException 
     * @exception RemoteException 
     * @param className 
     */
    public Class create(String className) throws CreateException, RemoteException;

    /** Finds an instance of a Class entity bean by it's primary key, ClassName.
     * 
     * @exception FinderException 
     * @exception RemoteException 
     * @param className 
     */
    public Class findByPrimaryKey(String className) throws FinderException, RemoteException;

    /** Returns all instances of the entity bean Class from the database.
     * 
     * @exception FinderException 
     * @exception RemoteException 
     */
    public Collection findAll() throws FinderException, RemoteException;
    
    public Collection findByContext(String context) throws FinderException, RemoteException;
    
    public Collection findByParentName(String parentName) throws FinderException, RemoteException;
    
    public Collection findByChildCheck(String parentName) throws FinderException, RemoteException;
}
