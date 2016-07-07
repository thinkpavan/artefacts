import  java.sql.*;
public class CFunc{
public static  void  main(String  args[]){
   try{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   System.out.println("Connecting to Oracle");
   Connection con=DriverManager.getConnection("jdbc:odbc:emp","scott","tiger");
   System.out.println("Connected to Oracle");
CallableStatement cs=con.prepareCall("{ ?=call add_func(?,?)}");
   cs.setInt(2,100);
   cs.setInt(3,200);
   cs.registerOutParameter(1,Types.INTEGER);
   cs.execute();
   System.out.println("Ouput of StoredFunction is"+cs.getInt(1));
   }catch(Exception e){
        System.out.println("Exception ="+e);
        e.printStackTrace();
    }
  }
}
