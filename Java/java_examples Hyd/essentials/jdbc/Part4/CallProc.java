/* Demonstrates how to call a procedure
Author : Team - J
Version : 1.0
*/

import java.io.*;
import java.util.Enumeration ;
import java.sql.*;
public class CallProc{
	public static void main(String args[])throws Exception{
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	//con = DriverManager.getConnection("jdbc:odbc:orc","scott","tiger");
//	CallableStatement stmt = con.prepareCall("begin proc0; end;");
	CallableStatement stmt = con.prepareCall("{ call  proc0 }");

	stmt.execute();
	SQLWarning sqlw = stmt.getWarnings();
	System.out.println(sqlw);
 }	
}
