package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._ArrayBasicImplBase
<li> <b>Source File</b> INetSolv/_ArrayBasicImplBase.java
<li> <b>IDL Source File</b> ArrayBasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::ArrayBasic
<li> <b>Repository Identifier</b> IDL:INetSolv/ArrayBasic:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface ArrayBasic {
      void modifyArray(
        inout ::INetSolv::larray inoutarr,
        in ::INetSolv::sarray inarr
      );
    };
</pre>
</p>
*/
abstract public class _ArrayBasicImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetSolv.ArrayBasic {
  protected INetSolv.ArrayBasic _wrapper = null;
  public INetSolv.ArrayBasic _this() {
    return this;
  }
  protected _ArrayBasicImplBase(java.lang.String name) {
    super(name);
  }
  public _ArrayBasicImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetSolv.ArrayBasic";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetSolv/ArrayBasic:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("modifyArray", 0, 0),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return INetSolv._ArrayBasicImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetSolv.ArrayBasic _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      INetSolv.larrayHolder inoutarr = new INetSolv.larrayHolder();
      inoutarr.value = INetSolv.larrayHelper.read(_input);
      short[][] inarr;
      inarr = INetSolv.sarrayHelper.read(_input);
      _self.modifyArray(inoutarr,inarr);
      INetSolv.larrayHelper.write(_output, inoutarr.value);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
