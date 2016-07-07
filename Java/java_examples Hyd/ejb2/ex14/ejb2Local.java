/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package ref;
import javax.ejb.*;
import java.rmi.*;

public interface ejb2Local extends EJBLocalObject {

  public void ejb2Method();
}
