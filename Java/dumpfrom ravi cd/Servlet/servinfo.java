// Information about the environment in which the servlet is running
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class servinfo extends HttpServlet
{
  public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
  {
    ServletContext sc = getServletContext();
    PrintStream out = new PrintStream(res.getOutputStream());
    res.setContentType("text/plain");
    out.println("Hello " + req.getRemoteHost());
    out.println("The following are the information about the environment in which the servlet is running.");
    out.println("The name and version of the server running is " + sc.getServerInfo());
    out.println();
    out.flush();
  }
}
