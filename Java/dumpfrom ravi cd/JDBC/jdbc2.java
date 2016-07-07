import java.sql.*;
public class jdbc2
{
     public static void main(String args[])throws SQLException,ClassNotFoundException
     {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection conn=DriverManager.getConnection("jdbc:odbc:DATAS");
           String sql_st="DELETE FROM PUBLISHER WHERE PUB_ID='P1111'";
           Statement stam=conn.createStatement();
           int i=stam.executeUpdate(sql_st);
           System.out.println(i + " row(s) deleted");
           conn.commit();
           conn.close();
      }
}
