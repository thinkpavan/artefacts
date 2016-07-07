import java.sql.*;
public class Fetch{
public static void main(String args[]){
	try{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection   con;
	System.out.println("Connecting to Oracle DataBase....................................");
	con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.2:1521:orcl","scott","tiger");
	Statement stmt=con.createStatement();
	System.out.println("SucessFully Connected To Oracle!");
	ResultSet rs=stmt.executeQuery("select ename from emp");
	while(rs.next()){
		System.out.println(rs.getString(1));
		}
	}catch(Exception e){System.out.println("Error"+e);
			e.printStackTrace();};
}
}

	
	