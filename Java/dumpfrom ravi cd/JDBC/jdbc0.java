// A Program on JDBC Data Write
import java.sql.*;
public class jdbc0
{

     public static void main(String args[]) throws SQLException,ClassNotFoundException     {

           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection con=DriverManager.getConnection("jdbc:odbc:deep","scott","tiger");
           Statement stam=con.createStatement();
           int i=stam.executeUpdate("INSERT INTO emp(empno,ename,sal) VALUES(1234,'APTECH',4450)");
           System.out.println(i + " row(s) inserted");
           con.close();
       }
}
