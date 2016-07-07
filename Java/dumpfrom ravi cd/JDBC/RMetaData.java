import java.sql.*;
import java.io.*;
public class RMetaData{
public static void main(String args[]){
try{
Connection con=null;
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Connecting to Oracle...");
con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORACLE","system","manager");
System.out.println("SuccessFully connected");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from emp");
ResultSetMetaData rsm=rs.getMetaData();
for(int i=1;i<=rsm.getColumnCount();i++){
System.out.print("ColName="+i+"="+rsm.getColumnName(i));
System.out.println("DataType="+i+"="+rsm.getColumnType(i));
      
}
}catch(Exception e){
        System.out.println("Exception is..."+e);
        }
}
}


