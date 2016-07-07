/* Demonstrates how to get data from AccessAuthor : Team - J
Version : 1.0
*/


import java.util.Enumeration ;
import java.sql.*;
public class getDataFrmAccess{
	public static void main(String args[])throws Exception{
	   // establish connection to database this includes loading driver
	   // and fetching data.
	// first step is to register jbbc driver with driver manager
	// class.forName loads class which in this case is jdbc
	// implementation of interface Driver
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con;
	con = DriverManager.getConnection("jdbc:odbc:acc","","");
	System.out.println(con);
	// Once connected, we can  execute any sql statement
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from Employees");
	while(rs.next()){
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println("===================================");
	}
}
}