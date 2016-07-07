import  java.sql.*;
public class CStmt{
public static  void  main(String  args[]){
   try{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   System.out.println("Connecting to Oracle");
   Connection con=DriverManager.getConnection("jdbc:odbc:emp","scott","tiger");
   System.out.println("Connected to Oracle");
CallableStatement cs=con.prepareCall("{call add_proc(?,?,?,?)}");
   cs.setInt(1,100);
   cs.setInt(2,20);
   cs.registerOutParameter(3,Types.INTEGER);
   cs.registerOutParameter(4,Types.INTEGER);
   cs.execute();
   System.out.println("Ouput of StoredProcedure is"+cs.getInt(3));
   System.out.println("Ouput of StoredProcedure is"+cs.getInt(4));
   }catch(Exception e){
        System.out.println("Exception ="+e);
        e.printStackTrace();
    }
  }
}
