/* Demonstrates how to use a Prepared Statement
Author : Team - J
Version : 1.0
*/


import java.util.Enumeration ;
import java.sql.*;
public class PrepStmt1{
	public static void main(String args[])throws Exception{
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	//con = DriverManager.getConnection("jdbc:odbc:orc","scott","tiger");
	PreparedStatement stmt = con.prepareStatement("select * from mytab where col1 = ?");
	//set query criteria
	stmt.setInt(1,100);
	ResultSet rs = stmt.executeQuery();
	rs.next();	
	System.out.println(rs.getString(1));
	System.out.println(rs.getString(2));
// another set of rows with different criteria
	stmt.setInt(1,1);
	rs.close();
	rs = stmt.executeQuery();
	rs.next();	
	System.out.println(rs.getString(1));
	System.out.println(rs.getString(2));

}	
}
