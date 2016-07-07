/* Demonstrates how to call a procedure with in/out/inout parameters
Author : Team - J
Version : 1.0
*/

import java.io.*;
import java.util.Enumeration ;
import java.sql.*;
public class CallProc1{
	public static void main(String args[])throws Exception{
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	//con = DriverManager.getConnection("jdbc:odbc:orc","scott","tiger");
//	CallableStatement stmt = con.prepareCall("begin proc1(?,?,?); end;");
CallableStatement stmt = con.prepareCall("{ call proc1 (?,?,?) }");
	int inparam=1;
	int inoutparam=33;
	//set input parameters
	stmt.setInt(1,inparam);
	stmt.setInt(3,inoutparam);
	//register output types
	stmt.registerOutParameter(2,Types.INTEGER);
	stmt.registerOutParameter(3,Types.INTEGER);
	stmt.execute();
	SQLWarning sqlw = stmt.getWarnings();
	System.out.println(sqlw);
	System.out.println(" output param ="+ stmt.getInt(2)+"  inout parameter = " + stmt.getInt(3));
 }	
}
