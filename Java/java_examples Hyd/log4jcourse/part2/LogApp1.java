/* shows how to use log4j pacakage for logging.
Version: 1.0
Author : Team -J
show how to use various appenders.
*/

import org.apache.log4j.*;

public class LogApp1 {

  public static void main(String[] args) throws Exception {
	// first get a logger, logger is a subclass of org.apache.log4j.Category 
	// in future Catageory class will be removed so don't use it directly.
	Logger logger = Logger.getRootLogger();
	ConsoleAppender  ca = new ConsoleAppender(new SimpleLayout());
	logger.addAppender( ca);
	logger.setLevel(Level.ALL);
	//logger.setLevel(Level.OFF);
	logger.info(" This is an information message");
	logger.error("This is an error message");
	logger.fatal("This is a fatal error message");
	logger.warn(" This is a warning message");
	logger.debug("This is a debug message");

  }
}

// run this example by commenting Level.OFF line also.
