/* running multiple tests
*/
import junit.framework.*;

public class Suite{
	public static Test suite() { 
		TestSuite suite = new TestSuite();
		suite.addTest(VectorTest.suite());
		suite.addTest(JUnitTest.suite());
	 	return suite; 
	} 
	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	} 
}