/* Show how to write a TestCase using junit framework.
Version:1.0
Author:Team-J
*/

import junit.framework.*;

public class JUnitTest extends TestCase {
	MyMath m = null;

	protected void setUp() {
		System.out.println("Setup called");
		m = new MyMath();
	}
	public static Test suite() {
		return new TestSuite(JUnitTest.class);
	}
	public void testAdd1() {
		int result= m.add(20,30);
		assertTrue(result == 50);
	}
	public void testAdd2() {
		int result= m.add(Integer.MAX_VALUE,1);
		assertTrue(result == Integer.MIN_VALUE);
	}
	public void testAdd3() {
		int result= m.add(Integer.MIN_VALUE,-1);
		assertTrue(result == Integer.MAX_VALUE);
	}
	public void testAdd4() {
		int result= m.add(Integer.MIN_VALUE,-1);
		assertTrue(result == 10);// we know the actual result is not 10, but still
						 // to show the failure result we wrote like this.
	}
	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}