import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet extends HttpServlet
{
 public void doGet(HttpServletRequest req,HttpServletResponse res)
 throws IOException, ServletException
 {
  String uid=req.getParameter("uid");
  String pwd=req.getParameter("pwd");
  PrintWriter out=res.getWriter();
  out.println("<applet code=MyApplet height=100 width=200>");
  out.println("<param name=uid value="+uid+">");
  out.println("<param name=pwd value="+pwd+">");
  out.println("</applet>");
  out.close();
 }
}