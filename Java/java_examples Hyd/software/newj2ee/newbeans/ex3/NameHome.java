/*  Sample showing how to develop EJB Home Interface , The class
 that implements this interface will be auomatically depends on
 EJB Server on which this EJB will be deployed.
 Version : 1.0
 Author : Team - J
*/

package ex3;

import java.rmi.*;
import javax.ejb.*;
import ex3.*;

public interface NameHome extends EJBHome {
    public NameRemote create()
        throws RemoteException, CreateException;
  /*  public NameRemote create(String fn,String ln)
        throws RemoteException, CreateException;
*/
}
