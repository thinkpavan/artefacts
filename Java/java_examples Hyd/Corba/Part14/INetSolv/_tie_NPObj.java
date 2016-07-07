package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._tie_NPObj
<li> <b>Source File</b> INetSolv/_tie_NPObj.java
<li> <b>IDL Source File</b> NPRef.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::NPObj
<li> <b>Repository Identifier</b> IDL:INetSolv/NPObj:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface NPObj {
      attribute wstring name;
      void donothing();
    };
</pre>
</p>
*/
public class _tie_NPObj extends INetSolv._NPObjImplBase {
  private INetSolv.NPObjOperations _delegate;
  public _tie_NPObj(INetSolv.NPObjOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_NPObj(INetSolv.NPObjOperations delegate) {
    this._delegate = delegate;
  }
  public INetSolv.NPObjOperations _delegate() {
    return this._delegate;
  }
  /**
  <p>
  Operation: <b>::INetSolv::NPObj::donothing</b>.
  <pre>
    #pragma prefix "INetSolv/NPObj"
    void donothing();
  </pre>
  </p>
  */
  public void donothing() {
    this._delegate.donothing(
    );
  }
  /**
  <p>
  Writer for attribute: <b>::INetSolv::NPObj::name</b>.
  <pre>
    #pragma prefix "INetSolv/NPObj"
    attribute wstring name;
  </pre>
  </p>
  */
  public void name(
    java.lang.String name
  ) {
    this._delegate.name(
      name
    );
  }
  /**
  <p>
  Reader for attribute: <b>::INetSolv::NPObj::name</b>.
  <pre>
    #pragma prefix "INetSolv/NPObj"
    attribute wstring name;
  </pre>
  </p>
  */
  public java.lang.String name() {
    return this._delegate.name(
    );
  }
}
