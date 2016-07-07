/* Demonstrates how to find out Database Capability
Author : Team - J
Version : 1.0
*/

import java.io.*;
import java.util.Enumeration ;
import java.sql.*;
public class DBCap{
	public static void main(String args[])throws Exception{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con;
	//con = DriverManager.getConnection("jdbc:odbc:orc","scott","tiger");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott", "tiger");
	DatabaseMetaData dbmd =con.getMetaData();
	System.out.println("database name "+dbmd.getDatabaseProductName());
	System.out.println("database version "+dbmd.getDatabaseProductVersion());
	System.out.println("jdbc driver version "+dbmd.getDriverVersion());
	System.out.println("usesLocalFiles  "+dbmd.usesLocalFiles());
	System.out.println("sql key words = "+dbmd.getSQLKeywords());

 }	
}
