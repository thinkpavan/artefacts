import  javax.servlet.*;
import  java.io.*;

public  class  LifeCycleServlet  extends  GenericServlet
{
 public void  init(ServletConfig config)throws ServletException
 {
 super.init(config);
 System.out.println("Init method fired");
 }
 public void  service(ServletRequest req,ServletResponse res)throws ServletException,IOException
 {
    res.setContentType("text/plain");
    PrintWriter out=res.getWriter();
    System.out.println("Service method fired");
    ThreadGroup tg=Thread.currentThread().getThreadGroup();
    out.println("Service method fired");
    out.println("Welcome to Servlets "+Thread.currentThread()+"  "+Thread.currentThread().getName());
    tg.list();
 }
 public  void  destroy()
 {
  System.out.println("Servlet Destroy");
 }
}
