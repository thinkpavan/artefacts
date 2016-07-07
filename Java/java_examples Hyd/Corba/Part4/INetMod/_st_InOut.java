package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._st_InOut
<li> <b>Source File</b> INetMod/_st_InOut.java
<li> <b>IDL Source File</b> inout.idl
<li> <b>IDL Absolute Name</b> ::INetMod::InOut
<li> <b>Repository Identifier</b> IDL:INetMod/InOut:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface InOut {
      void passParam(
        out short s,
        inout wchar w
      );
      void passParam1(
        inout string s,
        inout wstring ws
      );
    };
</pre>
</p>
*/
public class _st_InOut extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetMod.InOut {
  protected INetMod.InOut _wrapper = null;
  public INetMod.InOut _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/InOut:1.0"
  };
  /**
  <p>
  Operation: <b>::INetMod::InOut::passParam</b>.
  <pre>
    #pragma prefix "INetMod/InOut"
    void passParam(
      out short s,
      inout wchar w
    );
  </pre>
  </p>
  */
  public void passParam(
    org.omg.CORBA.ShortHolder s,
    org.omg.CORBA.CharHolder w
  ) {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("passParam", true);
      _output.write_wchar(w.value);
      try {
        _input = this._invoke(_output, null);
        s.value = _input.read_short();
        w.value = _input.read_wchar();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
  }
  /**
  <p>
  Operation: <b>::INetMod::InOut::passParam1</b>.
  <pre>
    #pragma prefix "INetMod/InOut"
    void passParam1(
      inout string s,
      inout wstring ws
    );
  </pre>
  </p>
  */
  public void passParam1(
    org.omg.CORBA.StringHolder s,
    org.omg.CORBA.StringHolder ws
  ) {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("passParam1", true);
      _output.write_string(s.value);
      _output.write_wstring(ws.value);
      try {
        _input = this._invoke(_output, null);
        s.value = _input.read_string();
        ws.value = _input.read_wstring();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
  }
}
