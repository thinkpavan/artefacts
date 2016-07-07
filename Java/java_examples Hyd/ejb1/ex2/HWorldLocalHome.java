/*  Sample showing how to develop EJB Home Interface , The class
 that implements this interface will be auomatically depends on
 EJB Server on which this EJB will be deployed.
 Version : 1.0
 Author : Team - J
*/

package local;

import java.rmi.*;
import javax.ejb.*;
import local.HWorldLocal;

public interface HWorldLocalHome extends EJBLocalHome {
// may fail to create an object so we need to declare that this method
// throws CreateException
    public HWorldLocal create()
        throws CreateException;

}
