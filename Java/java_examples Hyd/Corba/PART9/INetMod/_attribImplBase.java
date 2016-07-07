package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._attribImplBase
<li> <b>Source File</b> INetMod/_attribImplBase.java
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
abstract public class _attribImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetMod.attrib {
  protected INetMod.attrib _wrapper = null;
  public INetMod.attrib _this() {
    return this;
  }
  protected _attribImplBase(java.lang.String name) {
    super(name);
  }
  public _attribImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetMod.attrib";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/attrib:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("dooperation", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("_set_count", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("_get_count", 0, 2),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return INetMod._attribImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetMod.attrib _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      _self.dooperation();
      return false;
    }
    case 1: {
      int count;
      count = _input.read_long();
      _self.count(count);
      return false;
    }
    case 2: {
      int _result = _self.count();
      _output.write_long(_result);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
