package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._st_Passval
<li> <b>Source File</b> INetMod/_st_Passval.java
<li> <b>IDL Source File</b> passval.idl
<li> <b>IDL Absolute Name</b> ::INetMod::Passval
<li> <b>Repository Identifier</b> IDL:INetMod/Passval:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface Passval {
      void passParam(
        in short s,
        in wchar w,
        in double d
      );
      long passParam1(
        in char c,
        in long long ll
      );
    };
</pre>
</p>
*/
public class _st_Passval extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetMod.Passval {
  protected INetMod.Passval _wrapper = null;
  public INetMod.Passval _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/Passval:1.0"
  };
  /**
  <p>
  Operation: <b>::INetMod::Passval::passParam</b>.
  <pre>
    #pragma prefix "INetMod/Passval"
    void passParam(
      in short s,
      in wchar w,
      in double d
    );
  </pre>
  </p>
  */
  public void passParam(
    short s,
    char w,
    double d
  ) {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("passParam", true);
      _output.write_short(s);
      _output.write_wchar(w);
      _output.write_double(d);
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
  Operation: <b>::INetMod::Passval::passParam1</b>.
  <pre>
    #pragma prefix "INetMod/Passval"
    long passParam1(
      in char c,
      in long long ll
    );
  </pre>
  </p>
  */
  public int passParam1(
    char c,
    long ll
  ) {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    int _result;
    while(true) {
      _output = this._request("passParam1", true);
      _output.write_char(c);
      _output.write_longlong(ll);
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
