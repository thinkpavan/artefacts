// Information about the request object
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class servenvi extends HttpServlet
{
  public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
  {
    PrintStream out = new PrintStream(res.getOutputStream());
    res.setStatus(HttpServletResponse.SC_OK);
    res.setContentType("text/html");
    out.println("<html><head><title>Servlet Info</title></head><body>");
    out.println("<h1>The Servlet was invoked with:</h1>");
    out.println("<dl>");
    out.println("<dt>Initialization Parameter: </dt>");
    out.println("<dd>"+getInitParameter("flagDirectory")+"</dd>");
    out.println("<dt>Size of request data: </dt>");
    out.println("<dd>"+req.getContentLength()+"</dd>");
    out.println("<dt>Type of request data: </dt>");
    out.println("<dd>"+req.getContentType()+"</dd>");
    out.println("<dt>Protocol and version of request: </dt>");
    out.println("<dd>"+req.getProtocol()+"</dd>");
    out.println("<dt>Name of the query parameter: </dt>");
    out.println("<dd>"+req.getQueryString()+"</dd>");
    out.println("<dt>Name of the remote user: </dt>");
    out.println("<dd>"+req.getRemoteUser()+"</dd>");
    out.println("<dt>Invoking path of the Servlet: </dt>");
    out.println("<dd>"+req.getContentLength()+"</dd>");
    out.println("<dt>Translated Requested path: </dt>");
    out.println("<dd>"+req.getPathTranslated()+"</dd>");
    out.println("</dl></body></html>");
    out.flush();
    out.close();
  }
}
