/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object , shows how to use
transaction service, this is a stateless session bean. We cannot
have a transaction open by a client across method calls
Version : 1.0
Author : Team -J
*/

package part7;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class Transaction implements SessionBean, SessionSynchronization {
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

// this method returns the no of employee from emp table, in order
// to transfer all the columns we can design a class that can hold all
// the columns of the table. Once if we know how to transfer one column the
// same technique can be used to transfer multiple columns
    public String[] listEmp(){
        try{
        Connection con = getConnection();
        System.out.println(con);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select ename from emp");
        // here we will return only first five rows
        String empno[] = new String[5];
        int i=0;
        for(i=0;i<5;i++){
            rs.next();
            empno[i]= rs.getString(1);
            System.out.println(empno[i]);
        }    
        con.close(); //can u find the bug here ???
        return (empno);
        }catch(Exception e){
            System.out.println(e);
            return null;
         }
    }
// we try to perform two database updates in this example to show how transactions
// are managed by server automatically
    public void updatesal(){
        try{
        Connection con = getConnection();
     //   con.setAutoCommit(false); un comment this and check !
        System.out.println(con);
        Statement stmt = con.createStatement(); // we can use prepstmt here
       int count = stmt.executeUpdate("update emp set sal = 100 where empno = 7900 ");
       System.out.println(" no of rows updated = "+ count);
       System.out.println("waiting here for some time ....");
       //Thread.currentThread().sleep(150000);
       System.out.println(" executing other stmt ....");
       stmt = con.createStatement(); // we can use prepstmt here
       count = stmt.executeUpdate("update emp set sal = sal + 99 where empno = 7900 ");
       System.out.println(" no of rows updated = "+ count);
       context.setRollbackOnly(); // we just don't want to commit the changes
       // this can also be done by throwing system exception EJBException
       con.close();
        }catch(Exception e){ System.out.println(e);}
    }
 // the above two methods has to throw an exception if any error
 //occurs during the execution
 
 
  private Connection getConnection()
    throws SQLException
  {
    InitialContext initCtx = null;
    try {
      initCtx = new InitialContext();
	System.out.println(" before getting datasource");

      DataSource ds = (javax.sql.DataSource)
        initCtx.lookup("one.oraclepool"); // look up for object in jndi tree
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
   // implementation of methods in sessionsync interface
   
    public void afterBegin() { 
        System.out.println("transaction begin");
    }
    public void beforeCompletion() {
        System.out.println("beforeCompletion");
    }
    public void afterCompletion(boolean committed) {
        System.out.println("afterCompletion: commited" + committed);
    }
} 

