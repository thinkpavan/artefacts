import java.sql.*;

public class DBMD
{
  public static void main(String[] args)
  {
  try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:j2ee","scott","tiger");
      DatabaseMetaData dbmd=con.getMetaData();
      System.out.println("Database name: " + dbmd.getDatabaseProductName());
      System.out.println("Driver name: " + dbmd.getDriverName());
      System.out.println("Major version : " + dbmd.getDriverMajorVersion());
      System.out.println("Minor version : " + dbmd.getDriverMinorVersion());
      System.out.println("Driver version  "+ dbmd.getDriverVersion());
         }
    catch(Exception e){e.printStackTrace();}
   }
 }

