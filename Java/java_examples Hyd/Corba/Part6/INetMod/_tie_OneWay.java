package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._tie_OneWay
<li> <b>Source File</b> INetMod/_tie_OneWay.java
<li> <b>IDL Source File</b> OneWay.idl
<li> <b>IDL Absolute Name</b> ::INetMod::OneWay
<li> <b>Repository Identifier</b> IDL:INetMod/OneWay:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface OneWay {
      oneway void owmethod(
        in short s
      );
      void normalmethod();
      long normalmethod1();
      oneway void owmethod1(
        inout short s
      );
    };
</pre>
</p>
*/
public class _tie_OneWay extends INetMod._OneWayImplBase {
  private INetMod.OneWayOperations _delegate;
  public _tie_OneWay(INetMod.OneWayOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_OneWay(INetMod.OneWayOperations delegate) {
    this._delegate = delegate;
  }
  public INetMod.OneWayOperations _delegate() {
    return this._delegate;
  }
  /**
  <p>
  Operation: <b>::INetMod::OneWay::owmethod</b>.
  <pre>
    #pragma prefix "INetMod/OneWay"
    oneway void owmethod(
      in short s
    );
  </pre>
  </p>
  */
  public void owmethod(
    short s
  ) {
    this._delegate.owmethod(
      s
    );
  }
  /**
  <p>
  Operation: <b>::INetMod::OneWay::normalmethod</b>.
  <pre>
    #pragma prefix "INetMod/OneWay"
    void normalmethod();
  </pre>
  </p>
  */
  public void normalmethod() {
    this._delegate.normalmethod(
    );
  }
  /**
  <p>
  Operation: <b>::INetMod::OneWay::normalmethod1</b>.
  <pre>
    #pragma prefix "INetMod/OneWay"
    long normalmethod1();
  </pre>
  </p>
  */
  public int normalmethod1() {
    return this._delegate.normalmethod1(
    );
  }
  /**
  <p>
  Operation: <b>::INetMod::OneWay::owmethod1</b>.
  <pre>
    #pragma prefix "INetMod/OneWay"
    oneway void owmethod1(
      inout short s
    );
  </pre>
  </p>
  */
  public void owmethod1(
    org.omg.CORBA.ShortHolder s
  ) {
    this._delegate.owmethod1(
      s
    );
  }
}
