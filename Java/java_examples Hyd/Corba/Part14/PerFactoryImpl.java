public class PerFactoryImpl extends INetSolv._PerFactoryImplBase {
  /** Construct a persistently named object. */
  public PerFactoryImpl(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public PerFactoryImpl() {
    super();
  }
  
  public INetSolv.NPObj CreateNPObj() {
    // IMPLEMENT: Operation
    return (INetSolv.NPObj)new NPObjImpl();
  }

  public void dosomeThing() {
    // IMPLEMENT: Operation
	System.out.println(" I am in factory object");
  }
}
