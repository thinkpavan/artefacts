import  javax.servlet.*;
import  java.io.*;
import  java.sql.*;
public class  DataServlet1   extends  GenericServlet
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
f  }
  public  void  service(ServletRequest req,ServletResponse res)
  {
      try
      {
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       String move;
       out.println("<html><body bgcolor=lightyellow>");
       String v4=" ";
       v4=req.getParameter("deptno");
       pstmt=con.prepareStatement("select empno,ename,job,sal,deptno from emp where deptno=?");
       pstmt.setInt(1,Integer.parseInt(v4));
       ResultSet rs=pstmt.executeQuery();
       ResultSetMetaData rsmd=rs.getMetaData();
       int col=rsmd.getColumnCount();
       int c=1;
       out.println("<table bgcolor=lightpink  border=2 cellpadding=5 cellspacing=3>");
       while(c<=col)
        out.println("<th>"+rsmd.getColumnName(c++)+"</th>");
       while(rs.next())
       {
         out.println("<tr>");
         c=1;
         while(c<=col)
          out.println("<td>"+rs.getString(c++));
          out.println("</tr>");
       }
       pstmt.close();
       out.println("</table>");
       out.println("</body></html>");
       out.close();
      }catch(Exception e){e.printStackTrace();}
  }
}
