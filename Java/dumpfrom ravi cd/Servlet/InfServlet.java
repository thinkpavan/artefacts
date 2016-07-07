import  javax.servlet.*;
import  java.io.*;

public  class  InfServlet  extends  GenericServlet
{
 public void  service(ServletRequest req,ServletResponse res)throws ServletException,IOException
 {
   res.setContentType("text/html");
   PrintWriter out=res.getWriter();
   out.println("Content Type "+req.getContentType()+"<br>");
   out.println("Server Name "+req.getServerName()+"<br>");
   out.println("Server Port "+req.getServerPort()+"<br>");
   out.println("Remote Addr "+req.getRemoteAddr()+"<br>");
   out.println("Remote Host "+req.getRemoteHost()+"<br>");
   out.println("Protocol  "+req.getProtocol()+"<br>");
   out.println("Real Path "+req.getRealPath("/servlet/WelcomeServlet")+"<br>");
   out.close();
 }
}
