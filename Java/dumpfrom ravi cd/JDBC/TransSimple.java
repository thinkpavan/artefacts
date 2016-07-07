import java.sql.*;

public class TransSimple  {

   public static void main(String a[]) {

     try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con = DriverManager.getConnection("jdbc:odbc:bhagavan","scott"
                                      ,"tiger");
     Statement st = con.createStatement();

     con.setAutoCommit(false);

     int i1 = st.executeUpdate("UPDATE EMP SET SAL = SAL+100  WHERE"+
                     " DEPTNO = 10 ");

     int i2 = st.executeUpdate("UPDATE EMP SET SAL = SAL-100  WHERE"+
                    " DEPTNO = 20 ");

     con.commit();
       }catch(Exception e){ con.rollback();
              e.printStackTrace();}

   }
}
