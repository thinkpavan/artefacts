package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;

/** Home interface for the PropertyType Entity Bean
 *
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.PropertyTypeBean
 * @see com.submersion.jspshop.ejb.PropertyType
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public interface PropertyTypeHome extends EJBHome
{
/*  =====================================
              Finder Queries.
    ===================================== */
    public PropertyType create() throws NamingException, RemoteException, CreateException, FinderException;
    
    public PropertyType findByPrimaryKey(Long propertyTypeID) throws FinderException, RemoteException;

    public Collection findAll() throws FinderException, RemoteException;
    
    public Collection findByTypeID(Long typeID) throws FinderException, RemoteException;
    
    public Collection findByPropertyID(Long propertyID) throws FinderException, RemoteException;
    
    public Collection findByPropertyIDTypeName(Long propertyID, String typeName) throws FinderException, RemoteException;
    
    public Collection findByPropertyIDTypeID(Long propertyID, Long typeID) throws FinderException, RemoteException;
}
