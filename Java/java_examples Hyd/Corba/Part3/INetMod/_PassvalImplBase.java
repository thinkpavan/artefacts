package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._PassvalImplBase
<li> <b>Source File</b> INetMod/_PassvalImplBase.java
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
abstract public class _PassvalImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetMod.Passval {
  protected INetMod.Passval _wrapper = null;
  public INetMod.Passval _this() {
    return this;
  }
  protected _PassvalImplBase(java.lang.String name) {
    super(name);
  }
  public _PassvalImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetMod.Passval";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/Passval:1.0"
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
      return INetMod._PassvalImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetMod.Passval _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      short s;
      s = _input.read_short();
      char w;
      w = _input.read_wchar();
      double d;
      d = _input.read_double();
      _self.passParam(s,w,d);
      return false;
    }
    case 1: {
      char c;
      c = _input.read_char();
      long ll;
      ll = _input.read_longlong();
      int _result = _self.passParam1(c,ll);
      _output.write_long(_result);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
