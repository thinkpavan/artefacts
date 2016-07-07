package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;


/** Home interface of the Value entity bean
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.ValueBean
 * @see com.submersion.jspshop.ejb.Value
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public interface ValueHome extends EJBHome
{
/*  =====================================
              Finder Queries.
    ===================================== */
    /** Creates a new instance of the value entity bean. 
     * 
     * @exception NamingException 
     * @exception RemoteException 
     * @exception CreateException 
     * @exception FinderException 
     */
    public Value create() throws NamingException, RemoteException, CreateException, FinderException;

    /** Finds an entity bean by it's primary key.
     * 
     * @exception FinderException 
     * @exception RemoteException 
     * @param valueID 
     */
    public Value findByPrimaryKey(Long valueID) throws FinderException, RemoteException;

    public Collection findByPasswordCheck(String email, String password) throws FinderException, RemoteException;
    
    /** returns a collection of all the Value entities
     * 
     * @exception FinderException 
     * @exception RemoteException 
     */
    public Collection findAll() throws FinderException, RemoteException;
    
    public Collection findByObjectIDValue(Long objectID, String value) throws FinderException, RemoteException;
    
    public Collection findByObjectID(Long objectID) throws FinderException, RemoteException;
    
    public Collection findByObjectIDType2(Long objectID, Long typeID) throws FinderException, RemoteException;
    
    public Collection findByObjectIDType(Long objectID, String type) throws FinderException, RemoteException;
    
    public Collection findByObjectIDProperty2(Long objectID, Long propertyID) throws FinderException, RemoteException;

    public Collection findByObjectIDProperty(Long objectID, String property) throws FinderException, RemoteException;
    
    public Collection findByPropertyID(Long propertyID) throws FinderException, RemoteException;
    
}
