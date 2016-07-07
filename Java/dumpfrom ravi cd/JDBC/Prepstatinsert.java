
import java.sql.*;
import java.io.*;

class Prepstatinsert
{
 public static void main(String[] args)
 {
   try
   {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("jdbc:odbc:ytrao","gscl","granada");

   PreparedStatement pst=con.prepareStatement("insert into book11 values(?,?,?)");
   DataInputStream dis=new DataInputStream(System.in);

   while(true)
   {
    System.out.println("Enter the bookno OR '0' to exit :");
    String bno=dis.readLine();
    int bno1=Integer.parseInt(bno);

    if(bno1==0)
    break;

    System.out.println("Enter the bookname");
    String bname=dis.readLine();
    System.out.println("Enter the bookprice");
    Float f=new Float(dis.readLine());
    float bprice=f.floatValue();

    pst.setInt(1,bno1);
    pst.setString(2,bname.trim());
    pst.setFloat(3,bprice);

    int n=pst.executeUpdate();
    System.out.println(n+" rows inserted" );
   }
  }catch(Exception e){e.printStackTrace();}
 }
}

