/* example on hierarchial loggers
Version: 1.0
Author : Team -J
*/

import org.apache.log4j.*;

public class LogApp3 {

  public static void main(String[] args) throws Exception {
	Logger logger1 = Logger.getLogger("com.inet");
	FileAppender  ca1 = new FileAppender(new org.apache.log4j.xml.XMLLayout(),"one.xml");
	logger1.addAppender(ca1);
	logger1.setLevel(Level.ERROR);
	Logger logger2 = Logger.getLogger("com.inet.childlogger");

	FileAppender  ca2 = new FileAppender(new org.apache.log4j.xml.XMLLayout(),"two.xml");
	logger2.addAppender(ca2);
      logger2.setLevel(Level.INFO); 
	logger1.info(" This is parent information message");
	logger1.error("This is parent error message");
	logger1.fatal("This is parent fatal error message");
	logger1.warn(" This is parent warning message");
	logger1.debug("This is parent debug message");
System.out.println("=====================================");
	logger2.info("**This is child information message");
	logger2.error("**This is child error message");
	logger2.fatal("**This is child fatal error message");
	logger2.warn("**This is child warning message");
	logger2.debug("**This is child debug message");
  }
}

//by default a child logger inherits the log level of it's parent and appender of parent
// if you uncoment the lines logger2.addAppender then each message will be displayed
// twice.