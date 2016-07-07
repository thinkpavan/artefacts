package mypack;
import java.sql.*;
public class CheckBean{
	String uname;
	String passwd;
	public void setUname(String uname){
		this.uname=uname;
		}
	public void setPasswd(String passwd){
		this.passwd=passwd;
		}
			
	public String getUname(){
		return uname;
		}
	public String getPasswd(){
		return passwd;
		}
	public boolean validate(){
	/*	try{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con;
		con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.2:1521:orcl","scott","tiger");
		Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select passwd from unames where uname='"+uname+"'");
		rs.last();
                int i=rs.getRow();
		if(i==1)
			return true;
		else
			return false; 


		if(rs.next())
			return true;
		else
			return false;
		}catch(Exception e){e.printStackTrace();}*/

	if(uname.equals(passwd)
			return true;
	else
			return false;
	}
}
		
					