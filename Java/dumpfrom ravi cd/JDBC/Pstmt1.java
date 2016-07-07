import java.sql.*;
import java.io.*;
public class Pstmt1{
public static void main(String args[]){
try{
Connection con=null;
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Connecting to Oracle...");
con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORACLE","system","manager");
System.out.println("SuccessFully connected");
PreparedStatement pstmt=con.prepareStatement("select * from emp where sal >?");
DataInputStream dis=new DataInputStream(System.in);
System.out.println("Enter Sal:");
String data=dis.readLine();
double sal=Double.parseDouble(data);
pstmt.setDouble(1,sal);
ResultSet rs=pstmt.executeQuery();
while(rs.next()){
        System.out.print("Eno="+rs.getString(1)+"\t");
       System.out.print("EName="+rs.getString(2)+"\t");
       System.out.println("Sal="+rs.getString(3));
}

}catch(Exception e){
        System.out.println("Exception is..."+e);
        }
}
}


