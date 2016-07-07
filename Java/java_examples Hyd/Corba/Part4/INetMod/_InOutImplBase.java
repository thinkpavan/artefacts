package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._InOutImplBase
<li> <b>Source File</b> INetMod/_InOutImplBase.java
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
abstract public class _InOutImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetMod.InOut {
  protected INetMod.InOut _wrapper = null;
  public INetMod.InOut _this() {
    return this;
  }
  protected _InOutImplBase(java.lang.String name) {
    super(name);
  }
  public _InOutImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetMod.InOut";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/InOut:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("passParam", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("passParam1", 0, 1),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return INetMod._InOutImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetMod.InOut _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      org.omg.CORBA.ShortHolder s = new org.omg.CORBA.ShortHolder();
      org.omg.CORBA.CharHolder w = new org.omg.CORBA.CharHolder();
      w.value = _input.read_wchar();
      _self.passParam(s,w);
      _output.write_short(s.value);
      _output.write_wchar(w.value);
      return false;
    }
    case 1: {
      org.omg.CORBA.StringHolder s = new org.omg.CORBA.StringHolder();
      s.value = _input.read_string();
      org.omg.CORBA.StringHolder ws = new org.omg.CORBA.StringHolder();
      ws.value = _input.read_wstring();
      _self.passParam1(s,ws);
      _output.write_string(s.value);
      _output.write_wstring(ws.value);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
