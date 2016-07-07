/* Demonstrates how to use Oracle Thin Driver
Author : Team - J
Version : 1.0
*/


import java.util.Enumeration ;
import java.sql.*;
import oracle.jdbc.driver.*;


public class ThinDriver{
	public static void main(String args[])throws Exception{
	//Class.forName("OracleDriver");
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
	con = DriverManager.getConnection("jdbc:oracle:thin:@inetsolv100:1521:server","scott","tiger");
	System.out.println(con);
//	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from Emp");
	while(rs.next()){
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println("===================================");
	}
}
}
