 import java.sql.*;

 public class RetrieveT {
   public static void main(String a[]) {
     try {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection con = DriverManager.getConnection("jdbc:odbc:bhagavan"
        ,"scott","tiger");
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(" SELECT * FROM EMP1"); 
       while (rs.next()) {

         System.out.println(rs.getInt(1) +"    "+ rs.getString(2)+"  "+
                        rs.getInt(3)  );
        }
       } catch(Exception e){e.printStackTrace();}
   }
}
