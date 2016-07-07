/* A sample showing how to define remote interface for EJB 
   Author : Team - J
   Version : 1.0
*/

package ref;
import javax.ejb.*;
import java.rmi.*;

public interface ejb1Local extends EJBLocalObject {
    // this method does some thing
  public void ejb1Method();
}
