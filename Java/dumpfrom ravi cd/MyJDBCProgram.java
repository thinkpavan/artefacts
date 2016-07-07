import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
public class  MyJDBCProgram
{
	public static void main(String[] args) 
	{
		String driverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:ORACLE";
		String userName="scott";
		String password="tiger";
		try{
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url,userName,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from strutsreg");
			while(rs.next())
			{
				System.out.print(rs.getString("userid") + "  ");
				System.out.print(rs.getString("password") + "  ");
				System.out.print(rs.getString("address") + "  ");
				System.out.println("");
			}
			con.close();
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(NullPointerException e)
		{
			System.out.println(e);
		}
	}
}
