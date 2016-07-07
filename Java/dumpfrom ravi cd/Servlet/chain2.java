// Servlet chaining
import java.io.*;
import java.util.Enumeration;
import javax.servlet.http.*;
import javax.servlet.*;

public class chain2 extends HttpServlet
{
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    Enumeration e = req.getHeaderNames();
    while (e.hasMoreElements())
    {
      String header = (String)e.nextElement();
      String value = req.getHeader(header);
      res.setHeader(header,value);
    }
    res.setContentType(req.getContentType());
    PrintWriter out = res.getWriter();
    if (req.getContentType().startsWith("text/html"))
    {
      BufferedReader reader = req.getReader();
      String s;
      while ((s=reader.readLine())!=null)
      {
	String u = s.toUpperCase();
	out.println(u);
      }
    }
    else
    {
      ServletInputStream in = req.getInputStream();
      int b;
      while ((b=in.read())!=-1)
      {
	out.write(b);
      }
    }
    out.close();
  }
}
