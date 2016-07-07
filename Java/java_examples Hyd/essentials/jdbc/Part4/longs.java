/* Demonstrates how to store binary data
Author : Team - J
Version : 1.0
to execute this create a table bigtab with blob and no columns
*/


import java.util.Enumeration ;
import java.sql.*;
import java.io.*;

public class longs{
	public static void main(String args[])throws Exception{

	FileOutputStream fos;
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	//con = DriverManager.getConnection("jdbc:odbc:orc","scott","tiger");
	//PreparedStatement stmt = con.prepareStatement("select * from mytab where col1 = ?");
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from bigtab");
	rs.next();
	System.out.println(rs.getBlob(1));
	System.out.println(rs.getObject(2));
	Blob b = rs.getBlob(1);
// we cannot have a very big array so we read data in chuncks
	byte b1[] = new byte[(int)b.length()];
	b1 = b.getBytes(1,(int)b.length()); // read full data at once
	System.out.println("blob len = "+ b.length());
// after getting data write it to a file x.bmp
	fos = new FileOutputStream("x.bmp");
	fos.write(b1);
	fos.close();
}	
}
