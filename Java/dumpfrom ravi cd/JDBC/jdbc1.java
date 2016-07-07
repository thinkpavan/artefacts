import java.sql.*;
public class jdbc1
{
    public static void main(String args[])
    {
          Statement st1;
          ResultSet rest;
          try{
                   try{
                             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                         }
                    catch(Exception e)
                    {
                               System.out.println("Error, Class not Found");
                    }
                    Connection con=DriverManager.getConnection("jdbc:odbc:DATS");
                    st1=con.createStatement();
                    rest=st1.executeQuery("SELECT * FROM PUBLISHER");
                    while(rest.next())
                     {
                            System.out.print(rest.getString("NUMB") + "\t");
                            System.out.print(rest.getString("NAME") + "\t");
                            System.out.print(rest.getString("ADDR") + "\t");
                            System.out.print(rest.getString("PHONE") + "\n");

                      }
                     st1.close();
                     con.close();
                  }
           catch(Exception e)
           {
                      System.out.println(e);
           }
     }
}

                            
