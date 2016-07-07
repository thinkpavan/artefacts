 import java.sql.*;

 public class IV {
   public static void main(String a[]) {
     try {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection con = DriverManager.getConnection("jdbc:odbc:bhagavan"
        ,"scott","tiger");
       Statement st = con.createStatement();
       boolean b = st.execute(" INSERT INTO EMP2 VALUES (' "+ a[0]+ 
              " ' ,"+  Integer.parseInt(a[1]) +")" );
        System.out.println(b);
        }catch(ArrayIndexOutOfBoundsException e){System.out.println(" Please enter ename and sal ");}
         catch(Exception e){e.printStackTrace();}
   }
}
