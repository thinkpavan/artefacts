/* Demonstrates how to call a function
Author : Team - J
Version : 1.0
*/

import java.io.*;
import java.util.Enumeration ;
import java.sql.*;
public class CallFunc{
	public static void main(String args[])throws Exception{
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott", "tiger");

//	CallableStatement stmt = con.prepareCall("begin ? := func0 (?); end;");
CallableStatement stmt = con.prepareCall("{ ? = call func0 (?) }");
	int inparam=1;
	//set input parameters
	stmt.setInt(2,inparam);
	//register output types
	stmt.registerOutParameter(1,Types.INTEGER);
	stmt.execute();
	SQLWarning sqlw = stmt.getWarnings();
	System.out.println(sqlw);
	System.out.println("value returned by function = " +stmt.getInt(1));
 }	
}
