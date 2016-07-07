package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._tie_attrib
<li> <b>Source File</b> INetMod/_tie_attrib.java
<li> <b>IDL Source File</b> attrib.idl
<li> <b>IDL Absolute Name</b> ::INetMod::attrib
<li> <b>Repository Identifier</b> IDL:INetMod/attrib:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface attrib {
      attribute long count;
      void dooperation();
    };
</pre>
</p>
*/
public class _tie_attrib extends INetMod._attribImplBase {
  private INetMod.attribOperations _delegate;
  public _tie_attrib(INetMod.attribOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_attrib(INetMod.attribOperations delegate) {
    this._delegate = delegate;
  }
  public INetMod.attribOperations _delegate() {
    return this._delegate;
  }
  /**
  <p>
  Operation: <b>::INetMod::attrib::dooperation</b>.
  <pre>
    #pragma prefix "INetMod/attrib"
    void dooperation();
  </pre>
  </p>
  */
  public void dooperation() {
    this._delegate.dooperation(
    );
  }
  /**
  <p>
  Writer for attribute: <b>::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "INetMod/attrib"
    attribute long count;
  </pre>
  </p>
  */
  public void count(
    int count
  ) {
    this._delegate.count(
      count
    );
  }
  /**
  <p>
  Reader for attribute: <b>::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "INetMod/attrib"
    attribute long count;
  </pre>
  </p>
  */
  public int count() {
    return this._delegate.count(
    );
  }
}
