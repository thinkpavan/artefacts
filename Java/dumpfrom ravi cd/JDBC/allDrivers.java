import java.sql.*;
import java.util.*;
public class allDrivers
{
    public static void main(String[] args)
    {
          try
          {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 Enumeration d=DriverManager.getDrivers();
                 System.out.println("Available Drivers are: ");
                 while(d.hasMoreElements())
                  {
                       Driver driver=(Driver)d.nextElement();
                       System.out.println("Driver: " + driver.getClass().getName());
                   }
             }
             catch(Exception e)
             {
                    System.out.println("Error: " + e);
              }
        }
}
