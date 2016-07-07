package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._GreetingImplBase
<li> <b>Source File</b> INetMod/_GreetingImplBase.java
<li> <b>IDL Source File</b> greeting.idl
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
abstract public class _GreetingImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetMod.Greeting {
  protected INetMod.Greeting _wrapper = null;
  public INetMod.Greeting _this() {
    return this;
  }
  protected _GreetingImplBase(java.lang.String name) {
    super(name);
  }
  public _GreetingImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetMod.Greeting";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/Greeting:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("TGreeting", 0, 0),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return INetMod._GreetingImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetMod.Greeting _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      java.lang.String _result = _self.TGreeting();
      _output.write_wstring(_result);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
