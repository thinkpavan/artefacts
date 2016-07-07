// Servlet Chaining
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class chain1 extends HttpServlet
{
  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
  }
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    out.println("<form><input type=text value=Hello World></form>");
    out.close();
  }
}