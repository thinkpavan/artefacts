import  javax.servlet.*;
import  java.io.*;

public  class  LifeCycle  extends  GenericServlet
{
  static int cnt;
   public  void  init(ServletConfig  config)throws  ServletException
   {
    super.init(config);
         System.out.println("init");
    }
    public  void  service(ServletRequest req,ServletResponse res)throws ServletException,IOException
    {
        cnt++;
        Thread  t=Thread.currentThread();
        ThreadGroup  tg=t.getThreadGroup();
        res.setContentType("text/plain");
         PrintWriter out=res.getWriter();
         out.println("WELCOME TO SERVLETS...."+cnt+" "+t.getName()+" "+Thread.activeCount());
         tg.list();
         out.close();
         System.out.println("service");
    }
    public void  destroy()
    {
      System.out.println("destroy");
    }

}
