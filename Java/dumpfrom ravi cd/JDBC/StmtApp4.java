import  java.sql.*;
import  java.io.*;
public class StmtApp4
{
  public  static  void  main(String args[])
  {
      try
      {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      System.out.println("Connecting to Oracle");
      Connection  con=DriverManager.getConnection("jdbc:odbc:Oracle","scott","tiger");
      System.out.println("Connected to Oracle");
      con.setAutoCommit(false);
      String v=args[0];
      String v1=args[1];
      String v2=args[2];
      String v3=args[3];
      String v4=args[4];
      String url="insert into emp(empno,ename,job,sal,deptno) values("+v+",'"+v1+"','"+v2+"',"+v3+","+v4+")";

      Statement stmt=con.createStatement();
      BufferedReader br=new  BufferedReader(new InputStreamReader(System.in));
      System.out.println("Do you wish to save the record(Y/N)");
      String s=br.readLine();
      int cnt;
      cnt=stmt.executeUpdate(url);
      if(s.equalsIgnoreCase("Y"))
      {
      con.commit();
      System.out.println(cnt+"Done");
      }
      else
      {
      con.rollback();
      System.out.println(cnt+"Rolledback");
      }
      }catch(Exception e)
      {e.printStackTrace();
      }

  }
}
