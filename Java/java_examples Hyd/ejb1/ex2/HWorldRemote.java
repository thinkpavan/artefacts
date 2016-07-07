/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package local;
import javax.ejb.*;
import java.rmi.*;

public interface HWorldRemote extends EJBObject {
    public String GetMessage(String UName) throws  RemoteException;
}
