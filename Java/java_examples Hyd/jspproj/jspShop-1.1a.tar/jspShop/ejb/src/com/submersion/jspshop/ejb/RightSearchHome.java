package com.submersion.jspshop.ejb;

import java.rmi.RemoteException;
import javax.ejb.*;

/** Home interface for ObjectSearch session bean
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.Object
 * @see com.submersion.jspshop.ejb.ObjectSearch
 * @see com.submersion.jspshop.ejb.ObjectSearchBean
 * @see com.submersion.jspshop.ejb.ObjectHelper
 * @version $Revision$
 * @created: September 7, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/
public interface RightSearchHome extends EJBHome
{
/*  ================================================
	        ENTITY METHODS
    ================================================ */
    public RightSearch create() throws RemoteException, CreateException;
}
