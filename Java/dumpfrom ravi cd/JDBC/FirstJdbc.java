import java.sql.*;
public class FirstJdbc{
public static void main(String args[]){
try{
Connection con=null;
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Connecting to Oracle...");
con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORACLE","scott","tiger");
System.out.println("SuccessFully connected");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select empno,ename from emp");
while(rs.next()){
        System.out.print("Eno="+rs.getString(1)+"\t");
        System.out.println("Ename="+rs.getString(2));
}

}catch(Exception e){
        System.out.println("Exception is..."+e);
        }
}
}


