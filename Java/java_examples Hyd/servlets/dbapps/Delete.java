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


public class Delete extends HttpServlet
{
/* note : need to add validations, seperate bus logic from this code */
	public void service( HttpServletRequest request, HttpServletResponse res ) throws ServletException, IOException
	{
		String driver = getInitParameter("driver");
		String url = getInitParameter("dburl");
		String pid = request.getParameter("pid");
		String sqlStmt = "select * from products order by  pid";
		PrintWriter	out	= res.getWriter();
		try{
		Class.forName(driver);
		Connection con;
		con = DriverManager.getConnection(url,"scott","tiger");
		Statement stmt = con.createStatement();
	/* if no pid is choosen display list of products */
		if(pid == null){
		ResultSet rs = stmt.executeQuery(sqlStmt);
			while(rs.next()){
			out.println("<A href=\"/dbapps/delete?pid="+rs.getString(1)+"\">"+rs.getString(2)+"</A><br><br>");
			}
		}
		else{
			sqlStmt="delete from products where pid = " +pid;
			stmt.executeUpdate(sqlStmt);
			out.println("Product deleted");
		}
		out.println(sqlStmt+"<br><br>");
		con.close();
		}catch(Exception e){
			out.print("Falied to store "+ e);
		}	
	}
}
