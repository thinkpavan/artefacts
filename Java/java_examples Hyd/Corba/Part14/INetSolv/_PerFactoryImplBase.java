package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._PerFactoryImplBase
<li> <b>Source File</b> INetSolv/_PerFactoryImplBase.java
<li> <b>IDL Source File</b> NPRef.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::PerFactory
<li> <b>Repository Identifier</b> IDL:INetSolv/PerFactory:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface PerFactory {
      ::INetSolv::NPObj CreateNPObj();
      void dosomeThing();
    };
</pre>
</p>
*/
abstract public class _PerFactoryImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetSolv.PerFactory {
  protected INetSolv.PerFactory _wrapper = null;
  public INetSolv.PerFactory _this() {
    return this;
  }
  protected _PerFactoryImplBase(java.lang.String name) {
    super(name);
  }
  public _PerFactoryImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetSolv.PerFactory";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetSolv/PerFactory:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("CreateNPObj", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("dosomeThing", 0, 1),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return INetSolv._PerFactoryImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetSolv.PerFactory _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      INetSolv.NPObj _result = _self.CreateNPObj();
      INetSolv.NPObjHelper.write(_output, _result);
      return false;
    }
    case 1: {
      _self.dosomeThing();
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
