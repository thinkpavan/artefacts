/* displays the log level values defined in
Version: 1.0
Author : Team -J
OFF,WARN,ERROR are constants defined in Level class.
check priority class for more information
*/

import org.apache.log4j.*;

public class LogLevels {

  public static void main(String[] args) throws Exception {
	System.out.println("=====================================");
	System.out.println(Level.toLevel(Integer.MIN_VALUE));
	System.out.println(Level.toLevel(10000));
	System.out.println(Level.toLevel(20000));
	System.out.println(Level.toLevel(30000));
	System.out.println(Level.toLevel(40000));
	System.out.println(Level.toLevel(50000));
	System.out.println(Level.toLevel(Integer.MAX_VALUE));

  }
}

//According to int values ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
