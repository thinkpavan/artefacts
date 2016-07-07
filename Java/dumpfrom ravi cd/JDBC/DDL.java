import  java.sql.*;
import java.io.*;
public class DDL{
public static  void  main(String  args[]){
   try
   {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   System.out.println("Connecting to Oracle");
   Connection con=DriverManager.getConnection("jdbc:odbc:emp","scott","tiger");
   System.out.println("Connected to Oracle");
   Statement stmt=con.createStatement();
	DataInputStream dis=new DataInputStream(System.in);
	System.out.println("Enter Any DDL Statement");
	String str=dis.readLine();
   int r=stmt.executeUpdate(str);
   System.out.println("SucessFully Table is Created");
   }catch(Exception e){
        System.out.println("Exception ="+e);
        e.printStackTrace();
    }
  }
}
