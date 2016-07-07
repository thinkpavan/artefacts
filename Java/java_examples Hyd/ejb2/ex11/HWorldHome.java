/*  Sample showing how to develop EJB Home Interface , The class
 that implements this interface will be auomatically depends on
 EJB Server on which this EJB will be deployed.
 Version : 1.0
 Author : Team - J
*/

package env;

import java.rmi.*;
import javax.ejb.*;
import env.HWorldRemote;

public interface HWorldHome extends EJBHome {
// may fail to create an object so we need to declare that this method
// throws CreateException
    public HWorldRemote create()
        throws RemoteException, CreateException;

}
