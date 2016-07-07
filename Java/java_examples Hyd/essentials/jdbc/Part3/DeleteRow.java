/* Demonstrates how to insert/delete/update rows
Author : Team - J
Version : 1.0
*/


import java.util.Enumeration ;
import java.sql.*;
import oracle.jdbc.driver.*;


public class DeleteRow{
	public static void main(String args[])throws Exception{
	//Class.forName("OracleDriver");
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	System.out.println(con);
	Statement stmt = con.createStatement();
	int norows = stmt.executeUpdate("insert into emp (empno) values(777)");
	System.out.println("no of rows effected = "+ norows);	
	norows = stmt.executeUpdate("insert into emp (empno) values(778)");
	norows = stmt.executeUpdate("insert into emp (empno) values(779)");
	norows = stmt.executeUpdate("update emp set sal =10000 where empno <800");
	System.out.println("no of rows effected = "+ norows);	
	norows = stmt.executeUpdate("delete emp where empno <800");
	System.out.println("no of rows effected = "+ norows);	
	}
}
