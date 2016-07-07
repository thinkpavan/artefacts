 import java.sql.*;

 public class PreparedST {
   public static void main(String a[]) {
     try {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection con = DriverManager.getConnection("jdbc:odbc:bhagavan"
        ,"scott","tiger");
       PreparedStatement pst = con.prepareStatement("UPDATE EMP2 SET SAL = sal +  ?");
       pst.setInt(1,1000);
       int count = pst.executeUpdate();
        System.out.println(" No of Records Updated are : "+count);
     
        }catch(ArrayIndexOutOfBoundsException ae)
           {System.out.println("Please enter amount");}
         catch(Exception e){e.printStackTrace();}
   }
}
