/* Demonstrates how to find out Database Capability
Author : Team - J
Version : 1.0
*/

import java.io.*;
import java.util.Enumeration ;
import java.sql.*;
public class DBCap1{
	public static void main(String args[])throws Exception{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con;
	//con = DriverManager.getConnection("jdbc:odbc:orc","scott","tiger");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott", "tiger");
	DatabaseMetaData dbmd =con.getMetaData();
	System.out.println("numeric function "+dbmd.getNumericFunctions());
	System.out.println("String Functions "+dbmd.getStringFunctions());
	System.out.println("System Functions"+dbmd.getSystemFunctions());
	System.out.println("Search String Escape"+dbmd.getSearchStringEscape());
	System.out.println(" Schema Term = "+dbmd.getSchemaTerm());
	System.out.println(" supportsStoredProcedures = "+dbmd.supportsStoredProcedures());
	System.out.println(" getMaxBinaryLiteralLength = "+dbmd.getMaxBinaryLiteralLength());

	System.out.println(" getMaxRowSize = "+dbmd.getMaxRowSize());

	System.out.println(" getMaxStatementLength = "+dbmd.getMaxStatementLength());

 }	
}
