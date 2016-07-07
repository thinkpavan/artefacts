/* shows what happens if mor than one client requests for a service
on same CORBA object
version: 1.0
Author: Team -J*/

public class attribImpl extends INetMod._attribImplBase {
  private int c=0;

  public attribImpl(java.lang.String name) {
    super(name);
  }
  public attribImpl() {
    super();
  }
 
  public void dooperation() {
    // IMPLEMENT: Operation
	//we can use java's exception mechanism to raise exceptions
	System.out.println("in do operation");
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
}
