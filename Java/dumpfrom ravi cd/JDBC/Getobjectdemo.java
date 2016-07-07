import java.sql.*;
class Getobjectdemo
{
  public static void main(String[] args)
  {
   try
    {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("Jdbc:Odbc:sreedevi","gscl","granada");
      Statement st=con.createStatement();
      ResultSet rs=st.executeQuery("select * from emprecord");
      ResultSetMetaData rsmd=rs.getMetaData();
      int no_cols=rsmd.getColumnCount();
      while(rs.next())
      {
        for(int i=1;i<=no_cols;i++)
        {
          System.out.println(rs.getObject(i));
        }
      }
    }catch(Exception e){e.printStackTrace();}
  }
}
 
