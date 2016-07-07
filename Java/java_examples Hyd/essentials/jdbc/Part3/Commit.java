/* Demonstrates how to use commit/rollback
Author : Team - J
Version : 1.0
*/


import java.util.Enumeration ;
import java.sql.*;
import oracle.jdbc.driver.*;


public class Commit{
	public static void main(String args[])throws Exception{
	//Class.forName("OracleDriver");
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con;
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	con.setAutoCommit(false);
	Statement stmt = con.createStatement();
	int norows = stmt.executeUpdate("insert into emp (empno) values(777)");
	System.out.println("no of rows effected = "+ norows);	
	norows = stmt.executeUpdate("insert into emp (empno) values(778)");
	norows = stmt.executeUpdate("insert into emp (empno) values(779)");
	//con.rollback();
	con.commit();
	}
}
