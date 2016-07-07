import java.sql.*;
public class SecJdbc{
public static void main(String args[]){
try{
Connection con=null;
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Connecting to Oracle...");
con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:oracle","scott","tiger");
System.out.println("SuccessFully connected");
Statement stmt=con.createStatement();
int n=stmt.executeUpdate("insert into emp(empno,ename) values(1234,'XXXX')");
System.out.println("No.of Record insert="+n);
con.commit();
}catch(Exception e){
        System.out.println("Exception is..."+e);
        }
}
}


