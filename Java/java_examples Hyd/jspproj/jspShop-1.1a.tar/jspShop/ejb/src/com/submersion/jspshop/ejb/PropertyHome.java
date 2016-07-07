package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import javax.naming.*;

/** Home interface for Property bean.
 *
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.Property
 * @see com.submersion.jspshop.ejb.PropertyBean
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public interface PropertyHome extends EJBHome
{
/*  =====================================
              Finder Queries.
    ===================================== */
    /** Creates a new instance of a Property.
     * 
     * @param propertyID 
     * @exception NamingException 
     * @exception RemoteException 
     * @exception CreateException 
     * @exception FinderException 
     */
    public Property create() throws NamingException, RemoteException, CreateException, FinderException;

    /** Finds an instace of a Property bean by it's Primary Key.
     * 
     * @param propertyID 
     * @exception FinderException 
     * @exception RemoteException 
     */

    public Property findByClassNameProperty(String className, String propertyName) throws FinderException, RemoteException; 
     
    public Property findByPrimaryKey(Long propertyID) throws FinderException, RemoteException;
    /** Finds all instances of all Properties.
     * 
     * @exception FinderException 
     * @exception RemoteException 
     */
    public Collection findAll() throws FinderException, RemoteException;
    
    public Collection findByClassName(String className) throws FinderException, RemoteException;        
}
