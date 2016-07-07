/*  This is a sesssion bean to show how the transaction can be mainitained by
a client.
Version : 1.0
Author : Team -J
*/

package sync;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import java.util.*;
import javax.sql.*;
import java.rmi.*;

public class SSTrans implements SessionBean,SessionSynchronization
{
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

  public boolean operation1(int hike){
        try{
        Connection con = getConnection();
        Statement stmt = con.createStatement(); // we can use prepstmt here
       int count = stmt.executeUpdate("update emp set sal = 100 where empno = 7900 ");
       System.out.println(" no of rows updated = "+ count);
       con.close();
       return true;
        }catch(Exception e){
            System.out.println(e);
            return false; // if some thing goes wrong
        }
    }

  public boolean operation2(int hike){
        try{
        Connection con = getConnection();
        Statement stmt = con.createStatement(); // we can use prepstmt here
       int count = stmt.executeUpdate("update emp set sal = 200  where empno = 7900 ");
       System.out.println(" no of rows updated = "+ count);
	 context.setRollbackOnly();// rollback the transaction.
       con.close();
       return true;
        }catch(Exception e){
            System.out.println(e);
            return false; // if some thing goes wrong
        }
    }

// following method is to get the connection from the pool
  private Connection getConnection()
    throws SQLException
  {
    InitialContext initCtx = null;
    try {
      initCtx = new InitialContext();
	System.out.println(" before getting datasource");

      DataSource ds = (javax.sql.DataSource)
        initCtx.lookup("inetsolv.oraclepool"); // look up for object in jndi tree
	System.out.println(" after getting datasource");
      return ds.getConnection();
    } catch(NamingException ne) {
	System.out.println(ne);
      throw new EJBException(ne);
    } finally {
      try {
        if(initCtx != null) initCtx.close();
      } catch(NamingException ne) {
        throw new EJBException(ne);
      }
    }
  }    

// methods of session sync
public void afterBegin() throws EJBException,RemoteException{
	System.out.println("After Begin");
	System.out.println("****************************");
}
public void beforeCompletion() throws EJBException,RemoteException{
	System.out.println("Before Completion");
}
public void afterCompletion(boolean committed) throws EJBException,RemoteException{
	System.out.println("After Completion : Value of committed  = "+committed);
}




} 

