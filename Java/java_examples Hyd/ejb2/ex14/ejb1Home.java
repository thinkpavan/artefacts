/*  Sample showing how to develop EJB Home Interface , The class
 that implements this interface will be auomatically generated by
 EJB Server on which this EJB will be deployed.
 Version : 1.0
 Author : Team - J
*/

package ref;

import java.rmi.*;
import javax.ejb.*;
import ref.ejb1Remote;

public interface ejb1Home extends EJBHome {
    public ejb1Remote create()
        throws RemoteException, CreateException;
}