import java.sql.*;
import java.io.*;
public class Cstmt1{
public static void main(String args[]){
try{
Connection con=null;
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Connecting to Oracle...");
con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORACLE","system","manager");
System.out.println("SuccessFully connected");
CallableStatement cstmt=con.prepareCall("{call proc1(?,?,?,?)}");
cstmt.setInt(1,100);
cstmt.setInt(2,200);
cstmt.registerOutParameter(3,Types.NUMERIC);
cstmt.registerOutParameter(4,Types.NUMERIC);
cstmt.execute();
int sum=cstmt.getInt(3);
int diff=cstmt.getInt(4);
System.out.println("The Sum is"+sum+"The Diff. is="+diff);
}catch(Exception e){
        System.out.println("Exception is..."+e);
        }
}
}


