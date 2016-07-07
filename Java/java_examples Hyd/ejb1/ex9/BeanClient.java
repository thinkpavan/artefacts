/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object , shows how to use
transaction service, this is a stateless session bean calling methods on
another ejb
Version : 1.0
Author : Team -J
*/

package part9.Client;
import javax.ejb.*;
import java.sql.*;
import part9.Server.*;
import javax.naming.*;
import java.util.*;

public class BeanClient implements SessionBean{
    private  SessionContext context;
// these methods will be called when ejb is created

    public void ejbCreate() throws CreateException {
    }

// following are the methods defined in SessionBean interface
   public void setSessionContext(SessionContext sc) {
        context =sc;
   }
   public void ejbRemove() {
   }
   public void ejbActivate() {
   }
   public void ejbPassivate() {
   }

    public void callsrv(){
        try{
        Connection con = getConnection();
     //   con.setAutoCommit(false); un comment this and check !
        System.out.println(con);
        Statement stmt = con.createStatement(); // we can use prepstmt here
       int count = stmt.executeUpdate("update emp set sal = 100 where empno = 7499 ");
       System.out.println(" no of rows updated = "+ count);
       System.out.println(" calling method on other ejb ....");
       Context initial = getInitialContext();
// using naming service get reference to home interface
           Object obj= initial.lookup("part9.Server.BeanServerHome");
           BeanServerHome home =(BeanServerHome)obj;
           BeanServerRemote h = home.create();
            h.updatesal();
        System.out.println(" after update");
       con.close();
                //throw(new javax.ejb.EJBException(" transaction rolled back"));
        }catch(Exception e){
                System.out.println(e);
                // here in this example we will setrollbackonly so that 
                // container will rollback the transaction only in case
                // of exception. In the previous example we have tried to rollback
                // irrespective of the condition
                context.setRollbackOnly();
       }
    }

 
 // This method returns the connection object using which we can start database operations
 // a connection from the existing pool will be returned by this method.
   private Connection getConnection()
    throws SQLException
    { // in real project we will store the jdbc url using the application
      // server config utility and get the value from environment.
        return DriverManager.getConnection("jdbc:weblogic:jts:oraclePool");
    }
  
 //method to get the initial context specific to bea weblogic, we may
// need to slightly modify the props in order to run this on other
// servers
  static public Context getInitialContext() throws Exception {
    Hashtable h = new Hashtable();
    h.put(Context.INITIAL_CONTEXT_FACTORY,
        "weblogic.jndi.WLInitialContextFactory");
    h.put(Context.PROVIDER_URL, "t3://localhost:7001");
      h.put(Context.SECURITY_PRINCIPAL, "admin");//user
      h.put(Context.SECURITY_CREDENTIALS, "inetadmin"); //password
    return new InitialContext(h);
  }

} 

