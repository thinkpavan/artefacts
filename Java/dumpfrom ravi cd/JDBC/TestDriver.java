import  java.sql.*;

public  class  TestDriver
{
   public  static  void  main(String  args[])
   {
     try
     {
     DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
     System.out.println("connecting");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.2:orcl","scott","tiger");
                                                             //serverip,portno,servername
     System.out.println("connected");
	Statement stmt=con.createStatement();
	Resultset rs=stmt.executeQuery("s
     }catch(Exception e){  }
   }
}
