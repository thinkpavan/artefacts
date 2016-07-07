/* Demonstrates how to use a Prepared Statement
Author : Team - J
Version : 1.0
*/


import java.util.Enumeration ;
import java.sql.*;
public class PrepStmt{
	public static void main(String args[])throws Exception{
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	//con = DriverManager.getConnection("jdbc:odbc:orc","scott","tiger");
	PreparedStatement stmt = con.prepareStatement("update mytab set col1 = ? where col2 = ?");
	//let us first update row 1
	stmt.setInt(1,100);
	stmt.setInt(2,1);
	System.out.println(" no of rows effected ="+stmt.executeUpdate());
}	
}
