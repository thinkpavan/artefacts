package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;


/** Remote interface for Value entity bean
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.ValueBean
 * @see com.submersion.jspshop.ejb.ValueHome
 * @version $Revision$
 * Date Created: August 22, 2001  
 * Last changed: $Date$
 * Changed by: $Author$ 
 */
public interface Value extends EJBObject
{
/*  =====================================
              DataField Methods
    ===================================== */

/*  --ValueID-------------------- */
    /** returns the Primary key of the bean
     * 
     * @exception RemoteException 
     */
    public Long getValueID() throws RemoteException;

/*  --PropertyID-------------------- */
    /** returns the propertyID of which the value belongs to
     * 
     * @exception RemoteException 
     */
    public Long getPropertyID() throws RemoteException;
    
    /** changes the propertyID that the value belongs to. Should only be used during create.
     * 
     * @exception RemoteException 
     * @param propertyID 
     */
    public void setPropertyID(Long propertyID) throws RemoteException;

/*  --ObjectID-------------------- */
    /** returns the objectID that the value is linked to.
     * 
     * @exception RemoteException 
     */
    public Long getObjectID() throws RemoteException;
    
    /** changes the objectID that the value is linked to. Should only be used during create.
     * 
     * @exception RemoteException 
     * @param objectID 
     */
    public void setObjectID(Long objectID) throws RemoteException;

/*  --Value-------------------- */
    /** returns the String value of the property.
     * 
     * @exception RemoteException 
     */
    public String getValue() throws RemoteException;
    
    /** changes the string value of the property.
     * 
     * @exception RemoteException 
     * @param value 
     */
    public void setValue(String value) throws RemoteException;
}
