//A Program to Print Details of Database and Server
import java.sql.*;
class jdbc6
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
	  String dbName=dmd.getDatabaseProductName();
          String dbVer=dmd.getDatabaseProductVersion();
          ResultSet rst=dmd.getTableTypes();
          prnVal("\nThe Version of " + dbName + "   Database is  " + dbVer);
          prnVal("\nThe Following Tables are Available in " + dbName + " : ");  
          while(rst.next())
		prnVal("\n\t\t" + rst.getString("TABLE_TYPE"));
          rst.close();
	  con.close();
      }
      catch(Exception e)
      {
	  prnVal("\n"+e);
      }  
    }
}	