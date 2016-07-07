package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._st_OneWay
<li> <b>Source File</b> INetMod/_st_OneWay.java
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
public class _st_OneWay extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetMod.OneWay {
  protected INetMod.OneWay _wrapper = null;
  public INetMod.OneWay _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/OneWay:1.0"
  };
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
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("owmethod", false);
      _output.write_short(s);
      try {
        _input = this._invoke(_output, null);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
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
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("normalmethod", true);
      try {
        _input = this._invoke(_output, null);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
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
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    int _result;
    while(true) {
      _output = this._request("normalmethod1", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_long();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
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
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("owmethod1", false);
      _output.write_short(s.value);
      try {
        _input = this._invoke(_output, null);
        s.value = _input.read_short();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
  }
}
