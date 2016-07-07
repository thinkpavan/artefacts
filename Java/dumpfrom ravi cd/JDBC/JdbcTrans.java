import java.sql.*;
import java.io.*;
public class JdbcTrans{
public static void main(String args[]){
try{
Connection con=null;
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Connecting to Oracle...");
con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORACLE","system","manager");
System.out.println("SuccessFully connected");
con.setAutoCommit(false);
DataInputStream dis=new DataInputStream(System.in);
System.out.println("Enter U R Choice 0- Deposit,1- WithDrwal");
int ch=Integer.parseInt(dis.readLine());
System.out.println("Enter AcNumber");
int acno=Integer.parseInt(dis.readLine());
if(ch==0){
        System.out.println("Enter Amount to Deposit");
        double am=Double.parseDouble(dis.readLine());
        PreparedStatement pstmt=con.prepareStatement("update x_bank set bal=bal+? where acno=?");
        pstmt.setDouble(1,am);
        pstmt.setInt(2,acno);
        int n=pstmt.excuteUpdate();
        con.commit();
}else if(ch==1){
        System.out.println("Enter Amount to WithDraw");
        double am1=Double.parseDouble(dis.readLine());
        PreparedStatement pstmt=con.prepareStatement("update x_bank set bal=bal-? where acno=?");
        pstmt.setDouble(1,am1);
        pstmt.setInt(2,acno);
        int n1=pstmt.executeUpdate();
}else{
        
}

                
}

}catch(Exception e){
        System.out.println("Exception is..."+e);
        }
}
}


