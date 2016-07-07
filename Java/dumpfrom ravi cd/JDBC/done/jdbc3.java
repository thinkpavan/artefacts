//A Prog. with Prepared Statement
import java.sql.*;
public class jdbc3
{
     public static void main(String args[])throws SQLException,ClassNotFoundException
     {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection conn=DriverManager.getConnection("jdbc:odbc:DATAS");
           String sql_st="INSERT INTO PUBLISHER VALUES(?,?,?,?)";
           PreparedStatement stam=conn.prepareStatement(sql_st);
           stam.setString(1,"P1111");
           stam.setString(2,"Aptech Publishers");
           stam.setString(3,"DI Road - Chittoor");
           stam.setInt(4,34450);
           int i=stam.executeUpdate();
           System.out.println(i + " row(s) inserted");
           conn.commit();
           conn.close();
      }
}
