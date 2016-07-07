 import java.sql.*;

 public class UpdateT {
   public static void main(String a[]) {
     try {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection con = DriverManager.getConnection("jdbc:odbc:bhagavan"
        ,"scott","tiger");
       Statement st = con.createStatement();
       int i = st.executeUpdate(" UPDATE EMP2 SET SAL = SAL + 2000");
        System.out.println(i);
        }catch(ArrayIndexOutOfBoundsException ae)
           {System.out.println("Please enter amount");}
         catch(Exception e){e.printStackTrace();}
   }
}
