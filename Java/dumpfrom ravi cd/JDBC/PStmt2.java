import java.sql.*;
import java.io.*;
public class Pstmt2{
public static void main(String args[]){
try{
Connection con=null;
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Connecting to Oracle...");
con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORACLE","system","manager");
System.out.println("SuccessFully connected");
PreparedStatement pstmt=con.prepareStatement("update emp set sal=? where eno=?");
DataInputStream dis=new DataInputStream(System.in);
System.out.println("Enter Eno:");
String data=dis.readLine();
int eno=Integer.parseInt(data);
pstmt.setInt(2,eno);
System.out.println("Enter Sal");
String data1=dis.readLine();
double sal=Double.parseDouble(data1);
pstmt.setDouble(1,sal);
int n=pstmt.executeUpdate();
System.out.println("No.of rows updated="+n);
}catch(Exception e){
        System.out.println("Exception is..."+e);
        }
}
}


