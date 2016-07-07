/* Demonstrates how to use different types of result sets
Author : Team - J
Version : 1.0
*/


import java.util.Enumeration ;
import java.sql.*;
public class PosIns{
	public static void main(String args[])throws Exception{
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	//Connection con;
	//con = DriverManager.getConnection("jdbc:odbc:orc","scott","tiger");
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	System.out.println(con);
	// by default forward - only result set will be created
	// we can create sensitive/ in sensitive result sets
	// concurrency type can be read only /CONCUR_UPDATABLE
	// not all jdbc drivers support these options
	//Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	ResultSet rs = stmt.executeQuery("select empno,ename,deptno from Emp");
//before inserting row create a row
	rs.moveToInsertRow();
	// let us try to update a row in the underlying database
// modify comm to 1000
	rs.updateInt(1,1000); // by this statement local result set will be updated
rs.updateString(2,"stud"); 
rs.updateInt(3,10);
// to update database u need to apply update method on resultset.
	rs.insertRow();
System.out.println(" after inserting row in db");
	rs.close();
// like this u can use delete row also (if driver supports the feature
}
}
