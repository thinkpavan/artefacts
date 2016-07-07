//A Program to Print Details of Drivers
import java.sql.*;
class jdbc7
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
          DatabaseMetaData dmd=con.getMetaData();
	  String drName=dmd.getDriverName();
          String drVer=dmd.getDriverVersion();
	  int drMjVer=dmd.getDriverMajorVersion();
          int drMnVer=dmd.getDriverMinorVersion();
          prnVal("\nThe Driver: " + drName + "     Version is: " + drVer);
          prnVal("\nMajor Verion is: " + drMjVer + "     and Minor Version is: " + drMnVer);          	  con.close();
      }
      catch(Exception e)
      {
	  prnVal("\n"+e);
      }  
    }
}	