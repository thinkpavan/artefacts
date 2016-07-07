import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.util.*;
import  java.io.*;

public  class  CashierServlet  extends  HttpServlet
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
   String cost=req.getParameter("cost");
   out.println("<html><head>");
   out.println("<script language=\"JavaScript\">");
   out.println("function getData()");
   out.println("{");
   out.println("alert(cost)");
   out.println("}");
   out.println("</script>");
   out.println("</head>");
   out.println("<body onload=\"getData()\" bgcolor=lightyellow>");
   out.println("<center><h1>FOODWORLD</h1></center>");
   out.println("Your BILL");
   out.println("<form name=\"frm\" action=\"http://localhost:8080/servlet/ReceiptServlet\" method=post>");
   out.println("Name<input type=text  name=t size=20><br>");
   out.println("Closeup<input type=checkbox  name=t1 size=10 value=\"Closeup\"><br>");
   out.println("Lux<input type=checkbox  name=t2 size=10 value=\"Lux\"><br>");
   out.println("Pears<input type=checkbox  name=t3 size=10 value=\"Pears\"><br>");
   out.println("Frosties<input type=checkbox  name=t4 size=10 value=\"Frosties\"><br>");
   out.println("Complan<input type=checkbox  name=t5 size=10 value=\"Complan\"><br>");
   out.println("TotalCost <input type=text  name=t6 size=10><br>");
   out.println("CreditCard<input type=text  name=t7 size=10><br>");
   out.println("<input type=submit value=submit><input type=reset value=reset><br><hr>");
  
   out.println("</form>");
   out.println("</body></html>");
   }catch(Exception e){e.printStackTrace();}
}
}
