 import java.sql.*;
 //import javax.sql.*;
 
 public class ScrollableR1 {
   public static void main(String a[]) {
     try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con =    DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:oracle","scott","tiger");
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
 ResultSet rs = st.executeQuery(" SELECT eno, ename, sal  FROM EMP1 ");
 rs.afterLast();
 while(rs.previous()) {
   System.out.println(" "+ rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getInt(3));    
 }


 }
         catch(Exception e){e.printStackTrace();}
   }
}
