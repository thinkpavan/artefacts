//A Program on Transaction Control
import java.sql.*;
class jdbc9
{
    private static void prnVal(String s)
    {
	  System.out.print(s);
    }
    public static void main(String args[])
    {
      try
      {	
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          Connection con=DriverManager.getConnection("jdbc:odbc:datas","sa","");
          Statement stmt=con.createStatement();
          con.setAutoCommit(false);
	  int i=stmt.executeUpdate("DELETE FROM EMPL WHERE SAL<3000");
          con.rollback();
          con.setAutoCommit(true);
       	  con.close();
      }
      catch(Exception e)
      {
	  prnVal("\n"+e);
      }  
    }
}	