// JDBC with Servlets
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class jdbcserv extends HttpServlet
{
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      con = DriverManager.getConnection("jdbc:odbc:stud");
      st = con.createStatement();
      rs = st.executeQuery("select * from student");
      out.println("<html><head><title>Student list</title></head>");
      out.println("<body>");
      out.println("<table border=5><tr><th>Rno</th><th>Name</th><th>Marks</th></tr>");
      while (rs.next())
        out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td>");
      out.println("</table></body></html>");
	   con.close();
    }
    catch (ClassNotFoundException e)
    {
      out.println(e.getMessage());
    }
    catch (SQLException e)
    {
      out.println(e.getMessage());
    }
  }
}
