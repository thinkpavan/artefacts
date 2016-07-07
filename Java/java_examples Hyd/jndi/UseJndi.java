/* A sample showing how to use jndi
   Author : Team - J
   Version : 1.0
*/
import javax.naming.*;
import java.rmi.*;
import java.util.*;

public class UseJndi{
    public  static void main(String args[]){
        try{
            Hashtable h = new Hashtable();
            h.put(Context.INITIAL_CONTEXT_FACTORY,
                "weblogic.jndi.WLInitialContextFactory");
            h.put(Context.PROVIDER_URL, "t3://localhost:7001");
            h.put(Context.SECURITY_PRINCIPAL, "admin");//user
            h.put(Context.SECURITY_CREDENTIALS, "admin"); 
            Context ic = new InitialContext(h);
            System.out.println(" initial context = "+ ic);
            NamingEnumeration ne = ic.listBindings("");
            while (ne.hasMore()) {
                Binding b = (Binding)ne.next();
                System.out.println( b.getName());
                System.out.println(b.getObject());
            }
        }catch (Exception e){
		System.out.println(e);
	}
    }
}
