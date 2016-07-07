 import java.sql.*;

 public class ResultSMD {
   public static void main(String a[]) {
     try {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection con = DriverManager.getConnection("jdbc:odbc:bhagavan"
        ,"scott","tiger");
       
    Statement st = con.createStatement();
    
ResultSet rs =   st.executeQuery("select empno,ename,sal from emp where deptno= "+Integer.parseInt(a[0]));

  while(rs.next()) {
    System.out.println( ""+ rs.getInt(1)+"  "+rs.getString(2)+" "+ rs.getInt(3));
   } 

  ResultSetMetaData rsmd = rs.getMetaData();

   System.out.println("\n Column Count  " +rsmd.getColumnCount()+"\n Column Name "       +rsmd.getColumnName(1) + "\n Column Label   "+rsmd.getColumnLabel(1));


    }catch(ArrayIndexOutOfBoundsException ae)
           {System.out.println("Please enter deptno");}
         catch(Exception e){e.printStackTrace();}
   }
}
