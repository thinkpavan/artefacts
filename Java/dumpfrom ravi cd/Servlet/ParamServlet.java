import  javax.servlet.*;
import  java.io.*;

public  class  ParamServlet  extends  GenericServlet
{
  String s;
  public  void  init(ServletConfig  config)throws ServletException
  {
    super.init(config);
    s=getInitParameter("company");
  }
 public  void  service(ServletRequest req,ServletResponse res)throws ServletException,IOException
 {
        res.setContentType("text/html");
        ServletOutputStream out=res.getOutputStream();
        out.println("<html><body bgcolor=lightyellow>WELCOME  TO  SERVLETS.......</body></html>");
        out.println(s);
        out.close();
 }
}
