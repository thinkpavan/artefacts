/* running multiple tests
*/
import junit.framework.*;

public class Suite{
	public static Test suite() { 
		TestSuite suite = new TestSuite();
		suite.addTest(new VectorTest());
		suite.addTest(new JUnitTest());
		suite.addTest(new TCOne());
		suite.addTest(new TCTwo());

	 	return suite; 
	} 
	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	} 
}