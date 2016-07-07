import  javax.servlet.*;
import  java.io.*;
import  java.sql.*;
import  javax.servlet.http.*;
public class  DataServlet   extends  HttpServlet
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
  public  void  doGet(HttpServletRequest req,HttpServletResponse res)
  {
      try
      {
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       out.println("<html><body bgcolor=lightyellow>");
       out.println("<form  name=\"frm\" action=\"http://localhost:8080/servlet/DataServlet\" method=\"post\">");
       out.println("Empno<input type=text  name=\"empno\" size=10><br>");
       out.println("EmpName<input type=text  name=\"ename\" size=10><br>");
       out.println("Job<input type=text  name=\"job\" size=10><br>");
       out.println("Sal<input type=text  name=\"sal\" size=10><br>");
       out.println("Deptno<input type=text  name=\"deptno\" size=10><br>");
       out.println("<input type=submit  name=\"move\" value=\"INSERT\">");
       out.println("<input type=submit  name=\"move\" value=\"SELECTBYDEPT\">");
       out.println("<input type=submit  name=\"move\" value=\"DELETE\">");
       out.println("<input type=submit  name=\"move\" value=\"UPDATE\">");
       out.println("<input type=reset value=\"RESET\">");
       out.println("</form>");
      }catch(Exception e){e.printStackTrace();}
  }

  public  void  doPost(HttpServletRequest req,HttpServletResponse res)
  {
       try
       {
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       String move;
       move=req.getParameter("move");
       String  v=" ",v1=" ",v2=" ",v3=" ",v4=" ";
       int cnt=0;
       v=req.getParameter("empno");
       v1=req.getParameter("ename");
       v2=req.getParameter("job");
       v3=req.getParameter("sal");
       v4=req.getParameter("deptno");
       out.println("<html><body bgcolor=lightyellow>");
       if(move.equalsIgnoreCase("INSERT"))
       {
       System.out.println("INSERT");
       pstmt=con.prepareStatement("insert into emp(empno,ename,job,sal,deptno) values(?,?,?,?,?)");
       pstmt.setInt(1,Integer.parseInt(v));
       pstmt.setString(2,v1);
       pstmt.setString(3,v2);
       pstmt.setDouble(4,Double.valueOf(v3).doubleValue());
       pstmt.setInt(5,Integer.parseInt(v4));
       cnt=pstmt.executeUpdate();
       out.println("<h1>"+cnt+"Records Inserted to Oracle</h1>");
       pstmt.close();
       }
       else
       if(move.equalsIgnoreCase("SELECTBYDEPT"))
       {
       System.out.println("SELECTBYDEPT");
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
       }
       else
       if(move.equalsIgnoreCase("DELETE"))
       {
       System.out.println("DELETE");
       pstmt=con.prepareStatement("delete from emp where empno=?");
       pstmt.setInt(1,Integer.parseInt(v));
       cnt=pstmt.executeUpdate();
       out.println("<h1>"+cnt+"Record Deleted from Oracle</h1>");
       pstmt.close();
       }
       else
       if(move.equalsIgnoreCase("UPDATE"))
       {
       System.out.println("UPDATE");
       pstmt=con.prepareStatement("update emp set ename=?,job=?,sal=?,deptno=? where empno=?");
       pstmt.setString(1,v1);
       pstmt.setString(2,v2);
       pstmt.setDouble(3,Double.valueOf(v3).doubleValue());
       pstmt.setInt(4,Integer.parseInt(v4));
       pstmt.setInt(5,Integer.parseInt(v));
       cnt=pstmt.executeUpdate();
       out.println("<h1>"+cnt+"Records Updated to Oracle</h1>");
       pstmt.close();
       }
       out.println("</body></html>");
       out.close();


       }catch(Exception e){e.printStackTrace();}

  }
}
