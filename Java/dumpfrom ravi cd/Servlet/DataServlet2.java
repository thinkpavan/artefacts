import  javax.servlet.*;
import  java.io.*;
import  java.sql.*;
public class  DataServlet2   extends  GenericServlet
{
 Connection con;
 PreparedStatement pstmt;
  public  void  init(ServletConfig config)throws ServletException
  {
    super.init(config);
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connecting to Oracle..");
    con=DriverManager.getConnection("jdbc:odbc:Oracle","scott","tiger");
    System.out.println("Connected to Oracle..");
    }catch(Exception e){e.printStackTrace();}
  }
  public  void  service(ServletRequest req,ServletResponse res)
  {
      try
      {
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       String move;
       out.println("<html><body bgcolor=lightyellow>");
       String  v=" ",v1=" ",v2=" ",v3=" ",v4=" ";
       int cnt=0;
       v=req.getParameter("empno");
       v1=req.getParameter("ename");
       v2=req.getParameter("job");
       v3=req.getParameter("sal");
       v4=req.getParameter("deptno");
       pstmt=con.prepareStatement("insert into emp(empno,ename,job,sal,deptno) values(?,?,?,?,?)");
       pstmt.setInt(1,Integer.parseInt(v));
       pstmt.setString(2,v1);
       pstmt.setString(3,v2);
       pstmt.setDouble(4,Double.valueOf(v3).doubleValue());
       pstmt.setInt(5,Integer.parseInt(v4));
       cnt=pstmt.executeUpdate();
       out.println("<h1>"+cnt+"Records Inserted to Oracle</h1>");
       pstmt.close();
       out.println("</body></html>");
       out.close();
      }catch(Exception e){e.printStackTrace();}
  }
}
