/* Demonstrates how to use different types of result sets
Author : Team - J
Version : 1.0
*/


import java.util.Enumeration ;
import java.sql.*;
public class RSType{
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
	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

	ResultSet rs = stmt.executeQuery("select * from Emp");
	while(rs.next()){
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println("===================================");
	}
	rs.first();
		System.out.println("===================================");
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println("===================================");

rs.absolute(3);
		System.out.println("============absolute(3)=========");
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println("===================================");
// let us find how many rows are there in this resultset , which is not possible with 
// all the drivers
rs.last();
System.out.println(" No of Rows "+rs.getRow());
}
}
