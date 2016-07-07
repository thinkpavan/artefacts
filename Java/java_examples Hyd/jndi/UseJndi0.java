/* A sample showing how to use jndi
   Author : Team - J
   Version : 1.0
*/
import javax.naming.*;
import java.rmi.*;
import java.util.*;

public class UseJndi0{
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
            // initialcontext is like rooot of the tree
		//now let us try to create sub context ( assume subcontext as a branch)
          	Context subcon1 = ic.createSubcontext("inetsolv");
		String name1 = new String("objnameone");
		String value1= new String("Objvalueone");
		subcon1.bind(name1,value1);
		Context subcon2 = subcon1.createSubcontext("admin");
		System.out.println(" sub con created "+ subcon2);
		String name = new String("objname");
		String value = new String("Objvalue");
		subcon2.bind(name,value);
		System.out.println(value +" bound to a name "+ value);
        }catch (Exception e){System.out.println(e);}
    }
}
