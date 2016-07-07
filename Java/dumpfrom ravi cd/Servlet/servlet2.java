import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class servlet2 extends HttpServlet 
{

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException { 
    
	  String user = req.getParameter("user");
	  String pass = req.getParameter("password");

      res.setContentType("text/html");
     
	  PrintWriter out = res.getWriter();

	  out.println("<html>");
      out.println("<head><title> Servlet Example </title></head>");
      out.println("<body>");  

      out.println("<input type=text name=user value="+user+">");
	  out.println("<input type=text name=pass value="+pass+">");

	  out.println("</body></html>");
	  out.close();
  }
}


/*HTML Code should be :
<form method="post" action="/servlet2">
Name:
<input type="text" name="user"><br>
Password:
<input type="password" name="password"><br>
<input type="submit">
<input type="reset">
</form>
*/