package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;

/** Home interface for the Type Entity Bean
 *
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.TypeBean
 * @see com.submersion.jspshop.ejb.Type
 * @version $Revision$
 * @created: August 22, 2001  
 * @changed: $Date$
 * @changedBy: $Author$ 
 */
public interface TypeHome extends EJBHome
{
/*  =====================================
              Finder Queries.
    ===================================== */
    /** creates a new instance of the bean
     * 
     * @param typeID 
     * @exception NamingException 
     * @exception RemoteException 
     * @exception CreateException 
     * @exception FinderException 
     */
    public Type create() throws NamingException, RemoteException, CreateException, FinderException;
    
    /** finds an entity and returns it based on it's primarykey
     * 
     * @param typeID 
     * @exception FinderException 
     * @exception RemoteException 
     */
    public Type findByPrimaryKey(Long typeID) throws FinderException, RemoteException;
    
    public Type findByTypeName(String name) throws FinderException, RemoteException;
    
    /** returns a collection of all type entities
     * 
     * @exception FinderException 
     * @exception RemoteException 
     */
    public Collection findAll() throws FinderException, RemoteException;
    
    public Collection findByName(String name) throws FinderException, RemoteException;
    
    public Collection findByTypeID(Long typeID) throws FinderException, RemoteException;
}
