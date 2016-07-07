package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;

/** Home interface for the Object entity bean.
 *
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.Object
 * @see com.submersion.jspshop.ejb.ObjectBean
 * @version $Revision$
 * @created: August 22, 2001  
 * @changed: $Date$
 * @changedBy: $Author$ 
 */
public interface ObjectHome extends EJBHome
{
/*  =====================================
              Finder Queries.
    ===================================== */
    /** Used for creating a new instance of an Object.
     * 
     * @param objectID 
     * @exception NamingException 
     * @exception RemoteException 
     * @exception CreateException 
     * @exception FinderException 
     */
    public Object create() throws NamingException, RemoteException, CreateException, FinderException;

    /** Returns an object by it's primary key, ObjectID.
     * 
     * @param objectID 
     * @exception FinderException 
     * @exception RemoteException 
     */
    public Object findByPrimaryKey(Long objectID) throws FinderException, RemoteException;

    public Object findByParentIDName(Long context, String name) throws FinderException, RemoteException;
        
    /** Returns all instances of objects.
     * 
     * @exception FinderException 
     * @exception RemoteException 
     */
    public Collection findAll() throws FinderException, RemoteException;
    
    public Collection findByProperty(Long context, String property) throws FinderException, RemoteException;
    
    public Collection findByPropertySub(String context, String property) throws FinderException, RemoteException;
    
    public Collection findByProperty2(Long context, Long propertyID) throws FinderException, RemoteException;
    
    public Collection findByPropertySub2(String context, Long propertyID) throws FinderException, RemoteException;

    public Collection findByValue(Long context, String value) throws FinderException, RemoteException;
    
    public Collection findByValueSub(String context, String value) throws FinderException, RemoteException;
    
    public Collection findByType(Long context, String type) throws FinderException, RemoteException;
    
    public Collection findByTypeSub(String context, String type) throws FinderException, RemoteException;
    
    public Collection findByType2(Long context, Long typeID) throws FinderException, RemoteException;
    
    public Collection findByTypeSub2(String context, Long typeID) throws FinderException, RemoteException;

    public Collection findByContext2(Long context) throws FinderException, RemoteException;
    
    public Collection findByContext(String context) throws FinderException, RemoteException;    
        
    public Collection findByClassName2(Long context, String className) throws FinderException, RemoteException;
    
    public Collection findByClassNameSub(String context, String className) throws FinderException, RemoteException;
    
    public Collection findByClassName(String className) throws FinderException, RemoteException;
    
    public Collection findByChildCheck(Long context) throws FinderException, RemoteException;
        
}
