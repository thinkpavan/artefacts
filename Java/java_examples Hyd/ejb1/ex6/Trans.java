/*Class that implements the logic of a bean , It should be noted
that a client never directly talks to this object , shows how to use
transaction service, this is a stateless session bean. We cannot
have a transaction open by a client across method calls
Version : 1.0
Author : Team -J
*/

package part6;
import javax.ejb.*;
import java.sql.*;
import javax.sql.*; // here we are using DataSource
import javax.naming.*;

public class Trans implements SessionBean {
    private  SessionContext context;
// these methods will be called when ejb is created

    public void ejbCreate() throws CreateException {
		System.out.println("*** In Ejb create method ***");
    }

// following are the methods defined in SessionBean interface
   public void setSessionContext(SessionContext sc) {
        context =sc;
        System.out.println("*** in set session context ***");
   }
   public void ejbRemove() {
	   System.out.println("EJB Remove called");

   }
   public void ejbActivate() {
	   System.out.println("Ejb Activate called");
   }
   public void ejbPassivate() {
	   System.out.println("ejb passivate called");
   }

// this method returns the no of employee from emp table, in order
// to transfer all the columns we can design a class that can hold all
// the columns of the table. Once if we know how to transfer one column the
// same technique can be used to transfer multiple columns
    public String[] listEmp()
    {
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
        //con.close(); //can u find the bug here ???
        return (empno);
        }catch(Exception e){
            System.out.println(e);
            return null;
         }
    }
// this method updates the emp record to reflect new salary.
    public void updatesal(int hike, int empno){
        try{
        Connection con = getConnection();
        System.out.println(con);
        Statement stmt = con.createStatement(); // we can use prepstmt here
       int count = stmt.executeUpdate("update emp set sal = sal + "+hike +" where empno = " + empno);
       System.out.println(" no of rows updated = "+ count);
       //con.close(); // try by commenting this line
        }catch(Exception e){ System.out.println(e);}
    }
 // the above two methods has to throw an exception if any error
 //occurs during the execution


// we took this code from weblogic examples and modified the parameters according
// to our configuration

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
}



// we encourage students to perform a test on this bean by commenting
// connection.clsoe() and running multiple clients with db pool max
// size to 10. we strongly suggest to do this as one need to know
// about in's and out's to develop an enterprise scalable app.