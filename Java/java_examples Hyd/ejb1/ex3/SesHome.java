/*  Sample showing how to develop EJB Home Interface , The class
 that implements this interface will be auomatically generated by
 EJB Server on which this EJB will be deployed.
 Version : 1.0
 Author : Team - J
*/

package part3;

import java.rmi.*;
import javax.ejb.*;
import part3.SesRemote;

public interface SesHome extends EJBHome {
// may fail to create an object so we need to declare that this method
// throws CreateException
    public SesRemote create()
        throws RemoteException, CreateException;
// in some entity beans we need not declare the above also.
}