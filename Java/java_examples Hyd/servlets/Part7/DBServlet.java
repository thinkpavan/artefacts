/* Shows how to fetch data from database
   Version : 1.0
   Author : Team -J
*/

import java.io.*;
import java.util.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Enumeration ;
import java.sql.*;
import oracle.jdbc.driver.*;


public class DBServlet extends HttpServlet
{

	public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
	{
		PrintWriter	out	= res.getWriter();
		out.print("Before registring driver ");
		try{
  //  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con;
		out.print("Before establishing connection with database ");
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:server","scott","tiger");
		out.print("After establishing connection with database ");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from emp");
		// very bad way of formating html output , use table here 
		while(rs.next()){
			out.print(rs.getString(1)+" ");
			out.print(rs.getString(2)+" ");
			out.print(rs.getString(3)+"  ");
			out.println(rs.getString(4)+"<br>");
		}
		}catch(Exception e){
			out.print("Falied to fetch data from database ....");
		}	
	}
}
