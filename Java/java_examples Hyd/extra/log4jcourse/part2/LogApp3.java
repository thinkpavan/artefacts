/* example on hierarchial loggers
Version: 1.0
Author : Team -J
*/

import org.apache.log4j.*;

public class LogApp3 {

  public static void main(String[] args) throws Exception {
	Logger logger1 = Logger.getLogger("com.inet");
	ConsoleAppender  ca1 = new ConsoleAppender(new SimpleLayout());
	logger1.addAppender(ca1);
	logger1.setLevel(Level.ERROR);
	Logger logger2 = Logger.getLogger("com.inet.childlogger");
	//ConsoleAppender  ca2 = new ConsoleAppender(new SimpleLayout());
	//logger2.addAppender(ca2);
	logger1.info(" This is an information message");
	logger1.error("This is an error message");
	logger1.fatal("This is a fatal error message");
	logger1.warn(" This is a warning message");
	logger1.debug("This is a debug message");
System.out.println("=====================================");
	logger2.info("**This is an information message");
	logger2.error("**This is an error message");
	logger2.fatal("**This is a fatal error message");
	logger2.warn("**This is a warning message");
	logger2.debug("**This is a debug message");
  }
}

//by default a child logger inherits the log level of it's parent and appender of parent
// if you uncoment the lines logger2.addAppender then each message will be displayed
// twice.