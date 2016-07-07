
/* Shows how to use config files
Version: 1.0
Author : Team -J
*/
import org.apache.log4j.*;

public class Config {
 
  public static void main(String[] args) {
    PropertyConfigurator.configure("config.properties");
	Logger logger = Logger.getRootLogger();
	logger.info(" This is an information message");
	logger.error("This is an error message");
	logger.fatal("This is a fatal error message"); 
  }
}
