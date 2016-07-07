/* Demonstrates how to use different types of result sets using access
Author : Team - J
Version : 1.0
*/


import java.util.Enumeration ;
import java.sql.*;
public class RSType{
	public static void main(String args[])throws Exception{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con;
	con = DriverManager.getConnection("jdbc:odbc:acc","","");
	// by default forward - only result set will be created
	// we can create sensitive/ in sensitive result sets
	// concurrency type can be read only /CONCUR_UPDATABLE
	// not all jdbc drivers support these options
	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	ResultSet rs = stmt.executeQuery("select * from Employees");
	//go to last record
	rs.last();
	showRow(rs);
	rs.absolute(5);//go to 5th row
	rs.deleteRow();
	rs.absolute(10);
//updating a row by using resultset methods
	//emp no
	rs.updateString(1, "100020");
	 rs.updateFloat("sal", 10000.0f);
	rs.updateRow();
	// inserting rows by using rowsets
	rs.moveToInsertRow();
	rs.updateString(1, "100050");
	rs.updateFloat("sal", 1000000.0f);
	rs.insertRow();
// after inserting a row move back to currentrow
	rs.moveToCurrentRow();
	}
	public static void showRow(ResultSet rs)throws Exception{
		System.out.println("------------------------");
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println("------------------------");
	}
}
