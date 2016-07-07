/*shows difference b/w one way and normal method invocation
Author : Team -J
Version :1.0*/

public class OneWayImpl extends INetMod._OneWayImplBase {
  /** Construct a persistently named object. */
  public OneWayImpl(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public OneWayImpl() {
    super();
  }

  public void owmethod(
    short s
  ) {
    // IMPLEMENT: Operation
	System.out.println(" In oneway method");
	try{
		Thread.currentThread().sleep(60000);
	}catch(Exception e){}
	System.out.println("oneway method over");

  }

  public void normalmethod() {
    // IMPLEMENT: Operation
	System.out.println(" Normal method");
	try{
		Thread.currentThread().sleep(30000);
	}catch(Exception e){}
	System.out.println("Normal method over");
  }
  public int normalmethod1() {
    // IMPLEMENT: Operation
	System.out.println(" Normal method 1");
	try{
		Thread.currentThread().sleep(30000);
	}catch(Exception e){}
	System.out.println("Normal method 1 over");
    return 888;
  }
  
  public void owmethod1(
    org.omg.CORBA.ShortHolder s
  ) {
        // IMPLEMENT: Operation
	System.out.println(" In oneway method 1" + s.value);
	try{
		Thread.currentThread().sleep(30000);
	}catch(Exception e){}
	s.value = (short) 556;
	System.out.println("oneway method 1 over");  }
}
