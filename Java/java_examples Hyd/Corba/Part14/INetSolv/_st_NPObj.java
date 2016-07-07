package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._st_NPObj
<li> <b>Source File</b> INetSolv/_st_NPObj.java
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
public class _st_NPObj extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetSolv.NPObj {
  protected INetSolv.NPObj _wrapper = null;
  public INetSolv.NPObj _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetSolv/NPObj:1.0"
  };
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
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("donothing", true);
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
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("_set_name", true);
      _output.write_wstring(name);
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
  Reader for attribute: <b>::INetSolv::NPObj::name</b>.
  <pre>
    #pragma prefix "INetSolv/NPObj"
    attribute wstring name;
  </pre>
  </p>
  */
  public java.lang.String name() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String _result;
    while(true) {
      _output = this._request("_get_name", true);
      try {
        _input = this._invoke(_output, null);
        _result = _input.read_wstring();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
}
