package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._st_attrib
<li> <b>Source File</b> INetMod/_st_attrib.java
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
public class _st_attrib extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetMod.attrib {
  protected INetMod.attrib _wrapper = null;
  public INetMod.attrib _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/attrib:1.0"
  };
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
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("dooperation", true);
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
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("_set_count", true);
      _output.write_long(count);
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
  Reader for attribute: <b>::INetMod::attrib::count</b>.
  <pre>
    #pragma prefix "INetMod/attrib"
    attribute long count;
  </pre>
  </p>
  */
  public int count() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    int _result;
    while(true) {
      _output = this._request("_get_count", true);
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
}
