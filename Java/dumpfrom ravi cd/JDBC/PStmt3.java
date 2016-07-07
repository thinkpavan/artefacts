import  java.sql.*;

public class PStmt3{
  public static  void  main(String  args[])
  {
   try
   {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   System.out.println("Connecting to Oracle");
   Connection con=DriverManager.getConnection("jdbc:odbc:emp","scott","tiger");
   System.out.println("Connected to Oracle");
/*PreparedStatement pstmt=con.prepareStatement("insert into emp(empno,ename,sal,deptno) values(?,?,?,?)");
pstmt.setInt(1,1234);
pstmt.setString(2,"Trendz");
pstmt.setDouble(3,1200);
pstmt.setInt(4,20);*/

PreparedStatement pstmt=con.prepareStatement("update emp set sal=? where empno=?");
pstmt.setDouble(1,1111);
pstmt.setInt(2,1234);
int rs=pstmt.executeUpdate();
//System.out.println(rs+"Records Was Inserted");
System.out.println(rs+"Records Was updated");
   }catch(Exception e){
        System.out.println("Exception ="+e);
        e.printStackTrace();
    }
  }
}
