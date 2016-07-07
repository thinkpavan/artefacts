/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package ws2;
import javax.ejb.*;
import java.rmi.*;

public interface WS2Remote extends EJBObject {
    public String method1(String UName)
        throws  RemoteException;
    public String method2(String FName,String LName)
        throws  RemoteException;
}
