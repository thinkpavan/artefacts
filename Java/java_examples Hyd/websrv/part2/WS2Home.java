/*  Sample showing how to develop EJB Home Interface , The class
 that implements this interface will be auomatically depends on
 EJB Server on which this EJB will be deployed.
 Version : 1.0
 Author : Team - J
*/

package ws2;

import java.rmi.*;
import javax.ejb.*;
import ws2.WS2Remote;

public interface WS2Home extends EJBHome {
// may fail to create an object so we need to declare that this method
// throws CreateException
    public WS2Remote create()
        throws RemoteException, CreateException;

}
