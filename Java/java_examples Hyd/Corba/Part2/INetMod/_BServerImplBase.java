package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._BServerImplBase
<li> <b>Source File</b> INetMod/_BServerImplBase.java
<li> <b>IDL Source File</b> BServer.idl
<li> <b>IDL Absolute Name</b> ::INetMod::BServer
<li> <b>Repository Identifier</b> IDL:INetMod/BServer:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface BServer {
      short someShort();
      float someFloat();
      long someLong();
      double someDouble();
      unsigned long someULong();
      char someChar();
      wchar someWChar();
      boolean someBoolean();
    };
</pre>
</p>
*/
abstract public class _BServerImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetMod.BServer {
  protected INetMod.BServer _wrapper = null;
  public INetMod.BServer _this() {
    return this;
  }
  protected _BServerImplBase(java.lang.String name) {
    super(name);
  }
  public _BServerImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetMod.BServer";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/BServer:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("someShort", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("someFloat", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("someLong", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("someDouble", 0, 3),
      new org.omg.CORBA.portable.MethodPointer("someULong", 0, 4),
      new org.omg.CORBA.portable.MethodPointer("someChar", 0, 5),
      new org.omg.CORBA.portable.MethodPointer("someWChar", 0, 6),
      new org.omg.CORBA.portable.MethodPointer("someBoolean", 0, 7),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return INetMod._BServerImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetMod.BServer _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      short _result = _self.someShort();
      _output.write_short(_result);
      return false;
    }
    case 1: {
      float _result = _self.someFloat();
      _output.write_float(_result);
      return false;
    }
    case 2: {
      int _result = _self.someLong();
      _output.write_long(_result);
      return false;
    }
    case 3: {
      double _result = _self.someDouble();
      _output.write_double(_result);
      return false;
    }
    case 4: {
      int _result = _self.someULong();
      _output.write_ulong(_result);
      return false;
    }
    case 5: {
      char _result = _self.someChar();
      _output.write_char(_result);
      return false;
    }
    case 6: {
      char _result = _self.someWChar();
      _output.write_wchar(_result);
      return false;
    }
    case 7: {
      boolean _result = _self.someBoolean();
      _output.write_boolean(_result);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
