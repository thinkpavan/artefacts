import java.sql.*;
class Cursordemo
{
 public static void main(String[] args)
 {
     int c=0,n=0;
     int arr[]=new int[15];

   try
   {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:sreedevi","gscl","granada");
     Statement st1=con.createStatement();

     st1.setCursorName("ccur1");
     ResultSet rs=st1.executeQuery("select  * from emprecord where eno>102 for update");
     ResultSetMetaData rsmd=rs.getMetaData();
     int no_cols=rsmd.getColumnCount();
     System.out.println("no of rows fetched" + no_cols);
/*   while(rs.next())
    {
     arr[c]=rs.getInt(1);
     c++;
    }
//    rs.close();
    for(int j=0; j<arr.length;j++)
    { 
        Statement st2=con.createStatement();
        st2.executeUpdate("update emprecord set sal=sal+1000 where CURRENT OF ccur1");
        c++;
    }
   System.out.println("Rows updated are" + c);   */
  }catch(Exception e){e.printStackTrace();}
 }
}


