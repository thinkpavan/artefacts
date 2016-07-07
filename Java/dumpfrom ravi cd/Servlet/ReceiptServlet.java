import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.util.*;
import  java.io.*;

public  class  ReceiptServlet  extends  HttpServlet
{
 ShoppingCart  cart;

public  void  doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
   try
   {
   HttpSession session=req.getSession(true);
   cart=(ShoppingCart)session.getValue(session.getId());
   System.out.println("Session Id "+session.getId());
   if(cart==null)
   {
   cart=new ShoppingCart();
   session.putValue(session.getId(),cart);
   System.out.println("Session Id "+session.getId());
   }
   res.setContentType("text/html");
   PrintWriter out=res.getWriter();
   out.println("<html><head><meta  http-equiv=\"refresh\"  content=\"5;url="+res.encodeUrl("/servlet/SessionServlet")+"\">");
   out.println("</head><body bgcolor=lightyellow>");
   out.println("Thank You for  visiting our shop");
   out.println("This page resets after 5 seconds");
   session.invalidate();
   out.println("</body></html>");
   }catch(Exception e){e.printStackTrace();}
}
}

