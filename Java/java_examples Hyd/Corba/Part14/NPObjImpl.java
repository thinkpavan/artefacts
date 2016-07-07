public class NPObjImpl extends INetSolv._NPObjImplBase {
  /** Construct a persistently named object. */
	String myname;
  public NPObjImpl(java.lang.String name) {
    super(name);
	myname = new String("unknown");
  }
  /** Construct a transient object. */
  public NPObjImpl() {
    super();
	myname = new String("unknown");
  }

  public void donothing() {
    // IMPLEMENT: Operation
		System.out.println(" State = " + myname);
  }
  
  public void name(
    java.lang.String name
  ) {
    // IMPLEMENT: Writer for attribute
	myname = name;
  }

  public java.lang.String name() {
    // IMPLEMENT: Reader for attribute
    return myname;
  }
}
