package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._NPObjImplBase
<li> <b>Source File</b> INetSolv/_NPObjImplBase.java
<li> <b>IDL Source File</b> NPRef.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::NPObj
<li> <b>Repository Identifier</b> IDL:INetSolv/NPObj:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface NPObj {
      attribute wstring name;
      void donothing();
    };
</pre>
</p>
*/
abstract public class _NPObjImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetSolv.NPObj {
  protected INetSolv.NPObj _wrapper = null;
  public INetSolv.NPObj _this() {
    return this;
  }
  protected _NPObjImplBase(java.lang.String name) {
    super(name);
  }
  public _NPObjImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetSolv.NPObj";
    }
  }
  public boolean _usesWChar() {
    return true;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetSolv/NPObj:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("donothing", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("_set_name", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("_get_name", 0, 2),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return INetSolv._NPObjImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetSolv.NPObj _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      _self.donothing();
      return false;
    }
    case 1: {
      java.lang.String name;
      name = _input.read_wstring();
      _self.name(name);
      return false;
    }
    case 2: {
      java.lang.String _result = _self.name();
      _output.write_wstring(_result);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
