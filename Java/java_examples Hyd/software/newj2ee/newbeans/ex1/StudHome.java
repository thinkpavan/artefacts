/*  Sample showing how to develop EJB Home Interface , The class
 that implements this interface will be auomatically depends on
 EJB Server on which this EJB will be deployed.
 Version : 1.0
 Author : Team - J
*/

package part1;

import java.rmi.*;
import javax.ejb.*;
import part1.StudRemote;

public interface StudHome extends EJBHome {

    public StudRemote create()
        throws RemoteException, CreateException;

}
