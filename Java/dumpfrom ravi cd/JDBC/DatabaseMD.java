 import java.sql.*;

 public class DatabaseMD {
   public static void main(String a[]) {
     try {

       DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver() );

  Connection con =          DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:oracle","scott","tiger");

DatabaseMetaData dbmd = con.getMetaData();

System.out.println("\n\n Database Product Name " +dbmd.getDatabaseProductName()+ "\n\n Database Product Version    "+dbmd.getDatabaseProductVersion()+" \n\n  Driver Name  "+dbmd.getDriverName() +" \n\n URL   "+dbmd.getURL()+"\n\n  User Name "+dbmd.getUserName());

        }
         catch(Exception e){e.printStackTrace();}
   }
}
