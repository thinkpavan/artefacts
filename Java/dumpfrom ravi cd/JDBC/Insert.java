import java.sql.*;

class StatementInsert
{
  public static void main(String[] args)
  {
  try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:ytrao","gscl","granada");

      Statement st=con.createStatement();

      int i=st.executeUpdate("insert into  library2 values(1,'Java',2000 )");

      System.out.println("the no of rows inserted"+i);
      
    }catch(Exception e){e.printStackTrace();}
 }
}
