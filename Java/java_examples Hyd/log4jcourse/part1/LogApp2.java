/* shows how to use log4j pacakage for logging.
Version: 1.0
Author : Team -J
Note: In this example we are using XMLLayout in place of simpleLayout
*/

import org.apache.log4j.*;

public class LogApp2 {

  public static void main(String[] args) throws Exception {
	// first get a logger, logger is a subclass of org.apache.log4j.Category 
	// in future Catageory class will be removed so don't use it directly.
	Logger logger = Logger.getRootLogger();
	FileAppender fa = new FileAppender(new org.apache.log4j.xml.XMLLayout(),"logapp2.xml");
	logger.addAppender( fa);
	logger.info(" This is an information message");
	Thread.currentThread().sleep(1000);
	logger.error("This is an error message");
	Thread.currentThread().sleep(1000);
	logger.fatal("This is a fatal error message");

  }
}
