/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object
Version : 1.0
Author : Team -J
*/

package env;
import javax.ejb.*;
import javax.naming.*;
import java.util.*;

public class HWorld implements SessionBean {
    private SessionContext context;

// this method will be called when ejb is created

    public void ejbCreate() throws CreateException {
		System.out.println(" In Ejb create method");
    }
// following are the methods defined in SessionBean interface
   public void setSessionContext(SessionContext sc) {}
   public void ejbRemove() {}
   public void ejbActivate() {}
   public void ejbPassivate() {}

// Business logic provided by the bean component
   public String GetMessage(String UName){
	String env1=null,env2=null;
// we can use the following to read the environment values that are set at the
// deployment
	try{
	Properties p = new Properties();
	p.put(Context.INITIAL_CONTEXT_FACTORY,
	      "weblogic.jndi.WLInitialContextFactory");
	InitialContext ic = new InitialContext(p);
	Context ctx = (Context) ic.lookup("java:comp/env");
	env1 = (String) ctx.lookup("cname");
	env2  = (String) ctx.lookup("caddress");
	System.out.println(" environment value 1 = "+ env1);
	System.out.println(" environment value 2 = "+ env2);
	} catch (Exception e) {
		System.out.println(e);
	}
	return "Hi .." + UName +"  Welcome to " + env1 +","+ env2;
   }	
} 
