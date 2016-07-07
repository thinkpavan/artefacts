 import java.sql.*;

 public class CTable {
   public static void main(String a[]) {
     try {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection con = DriverManager.getConnection("jdbc:odbc:dsn1"
        ,"scott","tiger");
       Statement st = con.createStatement();
       boolean b = st.execute(" CREATE TABLE EMP2(name varchar2(30)," +
                           " sal number(10,2))");
        System.out.println(b);
        }catch(Exception e){e.printStackTrace();}
   }
}
