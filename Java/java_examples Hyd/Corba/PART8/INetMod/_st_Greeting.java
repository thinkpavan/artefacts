package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._st_Greeting
<li> <b>Source File</b> INetMod/_st_Greeting.java
<li> <b>IDL Source File</b> Greeting.idl
<li> <b>IDL Absolute Name</b> ::INetMod::Greeting
<li> <b>Repository Identifier</b> IDL:INetMod/Greeting:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface Greeting {
      wstring TGreeting();
    };
</pre>
</p>
*/
public class _st_Greeting extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetMod.Greeting {
  protected INetMod.Greeting _wrapper = null;
  public INetMod.Greeting _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/Greeting:1.0"
  };
  /**
  <p>
  Operation: <b>::INetMod::Greeting::TGreeting</b>.
  <pre>
    #pragma prefix "INetMod/Greeting"
    wstring TGreeting();
  </pre>
  </p>
  */
  public java.lang.String TGreeting() {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String _result;
    while(true) {
      _output = this._request("TGreeting", true);
      try {
		System.out.println(" Client trying to invoke method on Server");
        _input = this._invoke(_output, null);
		System.out.println("after invoking method on server");
        _result = _input.read_wstring();
		System.out.println("Result received by stub "+ _result);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
}
