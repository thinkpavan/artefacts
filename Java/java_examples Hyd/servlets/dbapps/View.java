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


public class View extends HttpServlet
{
/* note : need to add validations, seperate bus logic from this code */
	public void service( HttpServletRequest request, HttpServletResponse res ) throws ServletException, IOException
	{
		String driver = getInitParameter("driver");
		String url = getInitParameter("dburl");
/* products per page*/
		String ppp = getInitParameter("ppp");
		String lastpid = request.getParameter("lpid");
		if(lastpid == null)
			lastpid="0";
String sqlStmt = "select * from products where pid > "+ lastpid +" and rownum< "+ ppp +" order by pid";
		PrintWriter	out	= res.getWriter();
		out.println(sqlStmt+"br><br>");
		try{
		Class.forName(driver);
		Connection con;
		con = DriverManager.getConnection(url,"scott","tiger");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlStmt);
		while(rs.next()){
			out.print(rs.getString(1)+" ");
			out.print(rs.getString(2)+" ");
			out.println(rs.getString(3)+"<br>");
			lastpid=rs.getString(1);
			out.println("***" + lastpid + "<BR><BR>");
		}
		out.println("<br><br>Used :" +sqlStmt);
		out.println("<A href=\"/dbapps/view?lpid="+lastpid+"\">Next</A>");
		con.close();
		}catch(Exception e){
			out.print("Falied to store "+ e);
		}	
	}
}
