package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;

/** Home interface for TypeValue entity bean
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.TypeValueBean
 * @see com.submersion.jspshop.ejb.TypeValue
 * @version $Revision$
 * @created: August 22, 2001  
 * @changed: $Date$
 * @changedBy: $Author$ 
 */
public interface TypeValueHome extends EJBHome
{
/*  =====================================
              Finder Queries.
    ===================================== */
    /** creates a new instance of the TypeValue
     * 
     * @exception NamingException 
     * @exception RemoteException 
     * @exception CreateException 
     * @exception FinderException 
     * @param typeValueID 
     */
    public TypeValue create() throws NamingException, RemoteException, CreateException, FinderException;

    /** Finds a typeValue by it's primaryKey
     * 
     * @exception FinderException 
     * @exception RemoteException 
     * @param typeValueID 
     */
    public TypeValue findByPrimaryKey(Long typeValueID) throws FinderException, RemoteException;

    /** Returns a collection of all TypeValues
     * 
     * @exception FinderException 
     * @exception RemoteException 
     */

    public Collection findBySecurity(Long objectID, String id, String secureProperty, String rightType) throws FinderException, RemoteException;
     
    public Collection findAll() throws FinderException, RemoteException;

    public Collection findByValueID(Long valueID) throws FinderException, RemoteException;
    
    public Collection findByValueIDType(Long valueID, Long typeID) throws FinderException, RemoteException;
    
    public Collection findByValueIDType(Long valueID, String type) throws FinderException, RemoteException;
    
    public Collection findByValueIDValue(Long valueID, String value) throws FinderException, RemoteException;
    
    public Collection findByPropertyIDTypeID(Long propertyID, Long typeID) throws FinderException, RemoteException;

    public Collection findByTypeID(Long typeID) throws FinderException, RemoteException;
    

}
