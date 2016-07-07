/* Sample taken from examples of junit frame work
*/
import junit.framework.*;
import java.util.Vector;

/**
 * A sample test case, testing <code>java.util.Vector</code>.
 *
 */
public class VectorTest extends TestCase {
	protected Vector fEmpty;
	protected Vector fFull;

	public static void main (String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
System.out.println(" setup called");
		fEmpty= new Vector();
		fFull= new Vector();
		fFull.addElement(new Integer(1));
		fFull.addElement(new Integer(2));
		fFull.addElement(new Integer(3));
	}
	public static Test suite() {
		return new TestSuite(VectorTest.class);
	}
	public void testCapacity() {
System.out.println("test cap called");
		int size= fFull.size(); 
		for (int i= 0; i < 100; i++)
			fFull.addElement(new Integer(i));
		assertTrue(fFull.size() == 100+size);
	}
	public void testClone() {
System.out.println("test clone called");
		Vector clone= (Vector)fFull.clone(); 
		assertTrue(clone.size() == fFull.size());
		assertTrue(clone.contains(new Integer(1)));
	}
	public void testContains() {
System.out.println("test contains called");
		assertTrue(fFull.contains(new Integer(1)));  
		assertTrue(!fEmpty.contains(new Integer(1)));
	}
	public void testRemoveAll() {
System.out.println("test remove all called");

		fFull.removeAllElements();
		fEmpty.removeAllElements();
		assertTrue(fFull.isEmpty());
		assertTrue(fEmpty.isEmpty()); 
	}
	public void testRemoveElement() {
System.out.println("testRemoveElement called");

		fFull.removeElement(new Integer(3));
		assertTrue(!fFull.contains(new Integer(3)) ); 
	}
}



