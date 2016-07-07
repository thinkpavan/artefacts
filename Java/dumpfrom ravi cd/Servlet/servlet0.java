import java.io.*;
import javax.servlet.*;
public class servlet0 extends GenericServlet
{
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
  {
    res.setContentType("text/html");
    PrintWriter pw = res.getWriter();
    pw.println("<B>Welcome to Servlets</B>");
    pw.close();
  }
}
/*<html>
<body bgcolor="teal">
<form method=post action="servlet/servlet0">
<input type=submit name=submit>
</form>
</body>
</html>
*/