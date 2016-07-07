/*  Sample showing how to develop EJB Home Interface , The class
 that implements this interface will be auomatically depends on
 EJB Server on which this EJB will be deployed.
 Version : 1.0
 Author : Team - J
*/

package ws1;

import java.rmi.*;
import javax.ejb.*;
import ws1.WS1Remote;

public interface WS1Home extends EJBHome {
// may fail to create an object so we need to declare that this method
// throws CreateException
    public WS1Remote create()
        throws RemoteException, CreateException;

}
