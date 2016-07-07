//A Program to Print Details of Columns
import java.sql.*;
class jdbc8
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
	  ResultSet rest=stmt.executeQuery("SELECT * FROM CUSTOMERS");
          ResultSetMetaData rmd=rest.getMetaData();
          prnVal("\nThe Columns available are: \n");
          for(int i=1;i<rmd.getColumnCount();i++)
               prnVal("\n\t" + rmd.getColumnName(i));
       	  con.close();
      }
      catch(Exception e)
      {
	  prnVal("\n"+e);
      }  
    }
}	