import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class BasicServlet extends HttpServlet {

  public void doGet(HttpServletRequest req ,HttpServletResponse res) throws ServletException , IOException {
                                                                                                                  
      res.setContentType("text/html");
	  PrintWriter out = res.getWriter();

	  out.println("<html>");
	  out.println("<head><title> Basic Servlet </title></head>");
      out.println("<body>");

          out.println("Your Request method was " + req.getMethod() + "\n");

	  out.println("</body></html>");
	  out.close();
  }

public void doPost(HttpServletRequest req ,HttpServletResponse res) throws ServletException , IOException {

      res.setContentType("text/html");
	  PrintWriter out = res.getWriter();

	  out.println("<html>");
	  out.println("<head><title> Basic Servlet </title></head>");
      out.println("<body>");

          out.println("Your Request method was " + req.getMethod() + "\n");

	  out.println("</body></html>");
	  out.close();
  }
    
}
                                                         