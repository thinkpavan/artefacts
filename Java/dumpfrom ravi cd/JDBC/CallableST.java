
 import java.sql.*;

 public class CallableST {
   public static void main(String a[]) {
     try {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection con = DriverManager.getConnection("jdbc:odbc:bhagavan"
        ,"scott","tiger"); 

 CallableStatement cst = con.prepareCall("{?= call findEmpSal(?) }");
   cst.setInt(2,Integer.parseInt(a[0]));
          cst.registerOutParameter(1,Types.INTEGER);
  
      cst.executeUpdate();
        System.out.println("Sal of eno   ="+a[0]+" is "+cst.getInt(1));
        }catch(ArrayIndexOutOfBoundsException ae)
           {System.out.println("Please enter amount");}
         catch(Exception e){e.printStackTrace();}
   }
}
