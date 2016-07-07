import java.sql.*;
class Cursordemo1
{
 public static void main(String[] args)
 {
   try
   {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("Jdbc:Odbc:sreedevi","gscl","granada");
     Statement st1=con.createStatement();
     Statement st2=con.createStatement();
     st1.setCursorName("cur2");
     ResultSet rs=st1.executeQuery("select eno from emprecord where eno>103");
     int c=0,n=0;
     int arr[]=new int[15];
   while(rs.next())
    {
     arr[c]=rs.getInt(1);
     c++;
    }
    rs.close();
    for(int j=0; j<arr.length;j++)
    {
   st2.executeUpdate("update emprecord set sal=sal+1000 where CURRENT OF cur2");
    }
   System.out.println("Rows updated are" + c);
  }catch(Exception e){e.printStackTrace();}
 }
}


