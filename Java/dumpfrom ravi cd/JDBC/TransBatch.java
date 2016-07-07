import java.sql.*;

public class TransBatch  {

   public static void main(String a[]) {

     try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con = DriverManager.getConnection("jdbc:odbc:bhagavan","scott"
                                      ,"tiger");
     Statement st = con.createStatement();
     con.setAutoCommit(false);
     st.addBatch("UPDATE EMP SET SAL = SAL+100  WHERE"+
                     " DEPTNO = 10 ");

     st.addBatch("UPDATE EMP SET SAL = SAL-100  WHERE"+
                    " DEPTNO = 20 ");
     st.executeBatch();
     con.commit();
       }catch(Exception e){e.printStackTrace();}

   }
}
