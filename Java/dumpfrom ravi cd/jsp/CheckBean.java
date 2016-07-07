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
                try{
                DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
		Connection con;
                con=DriverManager.getConnection("jdbc:odbc:7am","system","manager");
		Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select passwd from unames where uname='"+uname+"'");
               /* rs.last();
                int i=rs.getRow();
		if(i==1)
			return true;
		else
                        return false; */


		if(rs.next())
			return true;
		else
			return false;

                }catch(Exception e){e.printStackTrace();return false;}
 
	}
}

