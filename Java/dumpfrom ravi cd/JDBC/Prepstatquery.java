import java.sql.*;
import java.io.*;

class PrepstatSelect
{
 public static void main(String[] args)
 {
  try
  {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          Connection con=DriverManager.getConnection("jdbc:odbc:ytrao","gscl","granada");

          PreparedStatement pst=con.prepareStatement("select * from library2 where bno=?");

          DataInputStream dis=new DataInputStream(System.in);
    while(true)
    {
     System.out.println("Enter the bookno or 0 to exit");
     String  bno=dis.readLine();
     int bno1=Integer.parseInt(bno);
     if(bno1==0)
     break;
     pst.setInt(1,bno1);
     ResultSet rs=pst.executeQuery();
          rs.next();
     String bname=rs.getString(2);
     float bprice=rs.getFloat(3);
     System.out.println("Bookno="+bno1 + "Bookname=" +bname +"bookprice=" + bprice);
     rs.close();
    }
  }catch(Exception e){}
 }
}
