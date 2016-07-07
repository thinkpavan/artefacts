/* Demonstrates how to store binary data
Author : Team - J
Version : 1.0
to execute this create a table bigtab with blob and no columns
*/

import java.io.*;
import java.util.Enumeration ;
import java.sql.*;
public class StorePhoto{
	public static void main(String args[])throws Exception{
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	//con = DriverManager.getConnection("jdbc:odbc:orc","scott","tiger");
	PreparedStatement stmt = con.prepareStatement("update bigtab set photo = ? where no = 10");
	File f = new File("verisign.bmp");
	FileInputStream fis = new FileInputStream(f);
	stmt.setBinaryStream(1,fis,(int)f.length());
	System.out.println("photo length = " + f.length());
	System.out.println("no of rows effected "+stmt.executeUpdate());

}	
}
