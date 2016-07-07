package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._st_InOut1
<li> <b>Source File</b> INetMod/_st_InOut1.java
<li> <b>IDL Source File</b> inout1.idl
<li> <b>IDL Absolute Name</b> ::INetMod::InOut1
<li> <b>Repository Identifier</b> IDL:INetMod/InOut1:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface InOut1 {
      ::INetMod::Company passParam(
        inout ::INetMod::Company c
      );
    };
</pre>
</p>
*/
public class _st_InOut1 extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetMod.InOut1 {
  protected INetMod.InOut1 _wrapper = null;
  public INetMod.InOut1 _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/InOut1:1.0"
  };
  /**
  <p>
  Operation: <b>::INetMod::InOut1::passParam</b>.
  <pre>
    #pragma prefix "INetMod/InOut1"
    ::INetMod::Company passParam(
      inout ::INetMod::Company c
    );
  </pre>
  </p>
  */
  public INetMod.Company passParam(
    INetMod.CompanyHolder c
  ) {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    INetMod.Company _result;
    while(true) {
      _output = this._request("passParam", true);
      INetMod.CompanyHelper.write(_output, c.value);
      try {
        _input = this._invoke(_output, null);
        _result = INetMod.CompanyHelper.read(_input);
        c.value = INetMod.CompanyHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
}
