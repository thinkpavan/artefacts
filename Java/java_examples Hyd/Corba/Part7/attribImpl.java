/* shows how to use attributes /exceptions and constants
version: 1.0
Author: Team -J*/

public class attribImpl extends com.INetMod._attribImplBase {
  private int c;
  private short s;

  public attribImpl(java.lang.String name) {
    super(name);
  }
  public attribImpl() {
    super();
  }
 
  public void dooperation(
  ) throws
    com.INetMod.attribPackage.corbaexception {
    // IMPLEMENT: Operation
	//we can use java's exception mechanism to raise exceptions
	System.out.println("in do operation");
	throw (new com.INetMod.attribPackage.corbaexception("failed to carry Operation"));
  }

  public void count(int count) {
    c = count;
    System.out.println("count =" + c);
  }

  public int count() {
    // IMPLEMENT: Reader for attribute
    System.out.println("...count..." + c);
    return c;
  }

  public short ro() {
    // IMPLEMENT: Reader for attribute
    return s;// some where we will be setting s
  }
}
