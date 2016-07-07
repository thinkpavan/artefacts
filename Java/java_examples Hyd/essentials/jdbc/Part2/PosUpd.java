/* Demonstrates how to use different types of result sets
Author : Team - J
Version : 1.0
*/


import java.util.Enumeration ;
import java.sql.*;
public class PosUpd{
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
// in some cases positional update may fail if for update is not used in select statement
	//ResultSet rs = stmt.executeQuery("select * from Emp");
	ResultSet rs = stmt.executeQuery("select empno,comm from Emp for update of comm");
// oracle's current i.e 12.01 is not supporting this operation at all
	System.out.println(" pointing to "+rs.getRow());
	rs.absolute(3);
	System.out.println(" pointing to "+rs.getRow());
	// let us try to update a row in the underlying database
// modify comm to 1000
	rs.updateFloat(2,1000); // by this statement local result set will be updated
// to update database u need to apply update method on resultset.
	rs.updateRow();
}
}
