package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._example_PerFactory
<li> <b>Source File</b> INetSolv/_example_PerFactory.java
<li> <b>IDL Source File</b> NPRef.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::PerFactory
<li> <b>Repository Identifier</b> IDL:INetSolv/PerFactory:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface PerFactory {
      ::INetSolv::NPObj CreateNPObj();
      void dosomeThing();
    };
</pre>
</p>
*/
public class _example_PerFactory extends INetSolv._PerFactoryImplBase {
  /** Construct a persistently named object. */
  public _example_PerFactory(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_PerFactory() {
    super();
  }
  /**
  <p>
  Operation: <b>::INetSolv::PerFactory::CreateNPObj</b>.
  <pre>
    #pragma prefix "INetSolv/PerFactory"
    ::INetSolv::NPObj CreateNPObj();
  </pre>
  </p>
  */
  public INetSolv.NPObj CreateNPObj() {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::INetSolv::PerFactory::dosomeThing</b>.
  <pre>
    #pragma prefix "INetSolv/PerFactory"
    void dosomeThing();
  </pre>
  </p>
  */
  public void dosomeThing() {
    // IMPLEMENT: Operation
  }
}
