package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._tie_PerFactory
<li> <b>Source File</b> INetSolv/_tie_PerFactory.java
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
public class _tie_PerFactory extends INetSolv._PerFactoryImplBase {
  private INetSolv.PerFactoryOperations _delegate;
  public _tie_PerFactory(INetSolv.PerFactoryOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_PerFactory(INetSolv.PerFactoryOperations delegate) {
    this._delegate = delegate;
  }
  public INetSolv.PerFactoryOperations _delegate() {
    return this._delegate;
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
    return this._delegate.CreateNPObj(
    );
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
    this._delegate.dosomeThing(
    );
  }
}
