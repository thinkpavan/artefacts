//A Program on Procedure Call
import java.sql.*;
import java.util.*;
class jdbc5
{
     public static void main(String args[]) throws InterruptedException
     {
           try
           {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           }
           catch(ClassNotFoundException e)
           {
                  System.out.println(e);
           }
           try
           {
                   Connection con=DriverManager.getConnection("jdbc:odbc:abc","scott","tiger");
                   Statement stmt=con.createStatement();
                   stmt.execute("DROP PROCEDURE SUMM");
                   stmt.execute("CREATE PROCEDURE SUMM AS SELECT empno,ename from emp");
		   CallableStatement cst=con.prepareCall("{CALL SUMM}");
		   ResultSet rs=cst.executeQuery();
		   while(rs.next())
	           {
                        System.out.print("\n"+rs.getString(1) + "\t");
			System.out.print(rs.getString(2));
			Thread.sleep(200);
                   }
	   }
	   catch(SQLException e)
   	   {
		  System.out.println(e);
	   }
      }
}

               

