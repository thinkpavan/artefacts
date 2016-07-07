/* Server implementing Passval interface
* Author : Team - J
* Version : 1.0*/

public class PassvalImpl extends INetMod._PassvalImplBase {

  public PassvalImpl(java.lang.String name) {
    super(name);
  }
  public PassvalImpl() {
    super();
  }
  
  public void passParam(
    short s,
    char w,
    double d
  ) {
    // IMPLEMENT: Operation
	System.out.println("Short = "+s);
	System.out.println("char = "+(int)w);
	System.out.println("double = "+d);

  }
  public int passParam1(
    char c,
    long ll
  ) {
    // IMPLEMENT: Operation
    return (int)(c + ll);
  }
}
