/*  Sample showing how to develop EJB Home Interface , The class
 that implements this interface will be auomatically generated by
 EJB Server on which this EJB will be deployed.
 Version : 1.0
 Author : Team - J
*/

package sec;

import java.rmi.*;
import javax.ejb.*;
import sec.*;

public interface SecHome extends EJBHome {
    public SecRemote create()
        throws RemoteException, CreateException;
}