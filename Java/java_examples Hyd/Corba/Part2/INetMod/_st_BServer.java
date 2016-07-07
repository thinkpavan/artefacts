package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._st_BServer
<li> <b>Source File</b> INetMod/_st_BServer.java
<li> <b>IDL Source File</b> BServer.idl
<li> <b>IDL Absolute Name</b> ::INetMod::BServer
<li> <b>Repository Identifier</b> IDL:INetMod/BServer:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface BServer {
      short someShort();
      float someFloat();
      long someLong();
      double someDouble();
      unsigned long someULong();
      char someChar();
      wchar someWChar();
      boolean someBoolean();
    };
</pre>
</p>
*/
public class _st_BServer extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetMod.BServer {
  protected INetMod.BServer _wrapper = null;
  public INetMod.BServer _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/BServer:1.0"
  };
  /**
  <p>
  Operation: <b>::INetMod::BServer::someShort</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    short someShort();
  </pre>
  </p>
  */
  public short someShort() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    short _result;
    while(true) {
      _output = this._request("someShort", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_short();
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
  Operation: <b>::INetMod::BServer::someFloat</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    float someFloat();
  </pre>
  </p>
  */
  public float someFloat() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    float _result;
    while(true) {
      _output = this._request("someFloat", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_float();
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
  Operation: <b>::INetMod::BServer::someLong</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    long someLong();
  </pre>
  </p>
  */
  public int someLong() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    int _result;
    while(true) {
      _output = this._request("someLong", true);
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
  Operation: <b>::INetMod::BServer::someDouble</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    double someDouble();
  </pre>
  </p>
  */
  public double someDouble() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    double _result;
    while(true) {
      _output = this._request("someDouble", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_double();
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
  Operation: <b>::INetMod::BServer::someULong</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    unsigned long someULong();
  </pre>
  </p>
  */
  public int someULong() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    int _result;
    while(true) {
      _output = this._request("someULong", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_ulong();
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
  Operation: <b>::INetMod::BServer::someChar</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    char someChar();
  </pre>
  </p>
  */
  public char someChar() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    char _result;
    while(true) {
      _output = this._request("someChar", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_char();
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
  Operation: <b>::INetMod::BServer::someWChar</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    wchar someWChar();
  </pre>
  </p>
  */
  public char someWChar() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    char _result;
    while(true) {
      _output = this._request("someWChar", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_wchar();
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
  Operation: <b>::INetMod::BServer::someBoolean</b>.
  <pre>
    #pragma prefix "INetMod/BServer"
    boolean someBoolean();
  </pre>
  </p>
  */
  public boolean someBoolean() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("someBoolean", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_boolean();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
}
