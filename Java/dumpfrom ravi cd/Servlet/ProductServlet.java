import  javax.servlet.*;
import  java.io.*;
import  java.util.*;

public  class  ProductServlet  extends  GenericServlet
{
  ProductDet proddetail;
  public  void  init(ServletConfig config)throws ServletException
  {
    super.init(config);
    proddetail=new  ProductDet();
  }
 public  Product  getDetail(String id)
 {
   return proddetail.getDetail(id);
 }
 public  Product[]  getAllDetails()
 {
   return proddetail.getAllDetails();
 }
 public  int  getNoOfItems()
 {
   return proddetail.getNoOfItems();
 }
  public void  service(ServletRequest req,ServletResponse res)throws ServletException
  {
    throw new  UnavailableException(this,"This Servlet doesnot accept client requests");
  }
  public  String toString()
  {
   return "This is a Generic Servlet for Product Details";
  }

}
