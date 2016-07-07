package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._OneWayImplBase
<li> <b>Source File</b> INetMod/_OneWayImplBase.java
<li> <b>IDL Source File</b> OneWay.idl
<li> <b>IDL Absolute Name</b> ::INetMod::OneWay
<li> <b>Repository Identifier</b> IDL:INetMod/OneWay:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface OneWay {
      oneway void owmethod(
        in short s
      );
      void normalmethod();
      long normalmethod1();
      oneway void owmethod1(
        inout short s
      );
    };
</pre>
</p>
*/
abstract public class _OneWayImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetMod.OneWay {
  protected INetMod.OneWay _wrapper = null;
  public INetMod.OneWay _this() {
    return this;
  }
  protected _OneWayImplBase(java.lang.String name) {
    super(name);
  }
  public _OneWayImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetMod.OneWay";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/OneWay:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("owmethod", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("normalmethod", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("normalmethod1", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("owmethod1", 0, 3),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return INetMod._OneWayImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetMod.OneWay _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      short s;
      s = _input.read_short();
      _self.owmethod(s);
      return false;
    }
    case 1: {
      _self.normalmethod();
      return false;
    }
    case 2: {
      int _result = _self.normalmethod1();
      _output.write_long(_result);
      return false;
    }
    case 3: {
      org.omg.CORBA.ShortHolder s = new org.omg.CORBA.ShortHolder();
      s.value = _input.read_short();
      _self.owmethod1(s);
      _output.write_short(s.value);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
