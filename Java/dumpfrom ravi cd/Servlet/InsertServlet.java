import  javax.servlet.*;
import  java.io.*;
import  java.sql.*;
public  class  InsertServlet  extends  GenericServlet
{
  Connection con;
  PreparedStatement pstmt;
  ResultSet rs;
   public  void  init(ServletConfig  config)throws  ServletException
   {
      try
      {
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         System.out.println("connecting to Oracle");
         con=DriverManager.getConnection("jdbc:odbc:abc","scott","tiger");
         System.out.println("connected to Oracle");
      }catch(Exception e){e.printStackTrace();}
   }
   public  void  service(ServletRequest  req,ServletResponse res)throws  ServletException,IOException
   {
        try
        {
        res.setContentType("text/html");
        PrintWriter  out=res.getWriter();
        int eno=Integer.parseInt(req.getParameter("empno"));
        String ename=req.getParameter("ename");
        String job=req.getParameter("job");
        double sal=Double.valueOf(req.getParameter("sal")).doubleValue();
        int deptno=Integer.parseInt(req.getParameter("deptno"));
        out.println("<html><body bgcolor=\"yellow\">");
        pstmt=con.prepareStatement("insert into emp(empno,ename,job,sal,deptno) values(?,?,?,?,?)");
        pstmt.setInt(1,eno);
        pstmt.setString(2,ename);
        pstmt.setString(3,job);
        pstmt.setDouble(4,sal);
        pstmt.setInt(5,deptno);
        int c=pstmt.executeUpdate();
        out.println("Inserted "+c+"Record");
        out.println("</body></html>");


        }catch(Exception  e){e.printStackTrace();}
   }
}
