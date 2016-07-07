import  java.sql.*;

public class Test
{
  public static  void  main(String  args[])
  {
   try
   {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   System.out.println("Connecting to Oracle");
   Connection con=DriverManager.getConnection("jdbc:odbc:emp","scott","tiger");
   System.out.println("Connected to Oracle");
PreparedStatement pstmt=con.prepareStatement("select ename,job,deptno from emp where deptno=? ");
pstmt.setInt(1,10);
ResultSet rs=pstmt.executeQuery();
while(rs.next()){
        System.out.print(rs.getString(1)+"\t\t");
        System.out.print(rs.getString(2)+"\t\t");
        System.out.print(rs.getInt(3)+"\t\t");
        System.out.println();
	}

 	

   }catch(Exception e){  }
  }
}
