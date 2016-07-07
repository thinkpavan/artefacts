/* Shows how to save data to database.
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
//import oracle.jdbc.driver.*;


public class Store extends HttpServlet
{
/* note : need to add validations, seperate bus logic from this code */
	public void service( HttpServletRequest request, HttpServletResponse res ) throws ServletException, IOException
	{
		String driver = getInitParameter("driver");
		String url = getInitParameter("dburl");
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String qty = request.getParameter("qty");
		String sqlStmt = "insert into products values ("+id+",'"+name+"',"+qty+")";
		PrintWriter	out	= res.getWriter();
		out.print("Before registring driver ");
		try{
Class.forName(driver);
		Connection con;
		con = DriverManager.getConnection(url,"scott","tiger");
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sqlStmt);
		out.println("Used :" +sqlStmt);
		con.close();
		}catch(Exception e){
			out.print("Falied to store "+ e);
		}	
	}
}
