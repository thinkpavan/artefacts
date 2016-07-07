import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class Hide extends HttpServlet 
{ public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException { 
    String user= req.getParameter("username");
	String pass= req.getParameter("password");
     res.setContentType("text/html");
     PrintWriter out = res.getWriter();
     out.println("<html>");
      out.println("<head><title> Servlet Example </title></head>");
      out.println("<body>");
	  out.println("username = "+user);
	  out.println("password = "+pass);
out.println("</body></html>");
	  out.close();
  }

}