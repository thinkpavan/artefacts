/* shows how to use log4j pacakage for logging.
Version: 1.0
Author : Team -J
show how to use various appenders.
*/

import org.apache.log4j.*;

public class LogApp {

  public static void main(String[] args) throws Exception {
	// first get a logger, logger is a subclass of org.apache.log4j.Category 
	// in future Catageory class will be removed so don't use it directly.
	Logger logger = Logger.getRootLogger();
	FileAppender fa = new FileAppender(new org.apache.log4j.SimpleLayout(),"logapp.log");
	logger.addAppender( fa);
	ConsoleAppender  ca = new ConsoleAppender(new SimpleLayout());
	logger.addAppender( ca);

	logger.info(" This is an information message");
	logger.error("This is an error message");
	logger.fatal("This is a fatal error message");

  }
}
