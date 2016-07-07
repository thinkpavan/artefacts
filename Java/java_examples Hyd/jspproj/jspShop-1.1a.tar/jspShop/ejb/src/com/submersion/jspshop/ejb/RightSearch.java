package com.submersion.jspshop.ejb;

import java.util.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import javax.naming.*;;

/** Remote interface for ObjectSearch session bean
 * 
 * @author Jeff Davey (jeffdavey@submersion.com)
 * @see com.submersion.jspshop.ejb.Object
 * @see com.submersion.jspshop.ejb.ObjectSearchHome
 * @see com.submersion.jspshop.ejb.ObjectSearchBean
 * @see com.submersion.jspshop.ejb.ObjectHelper
 * @version $Revision$
 * @created: September 7, 2001  
 * @changed: $Date$
 * @changedBy: $Author$
*/

public interface RightSearch extends EJBObject
{
/*  ================================================
	    ENTITY METHODS
    ================================================ */

    public HashMap doRightSearch(Long context, Long userID) throws RemoteException;    
}
