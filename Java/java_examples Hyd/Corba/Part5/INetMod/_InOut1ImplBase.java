package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod._InOut1ImplBase
<li> <b>Source File</b> INetMod/_InOut1ImplBase.java
<li> <b>IDL Source File</b> inout1.idl
<li> <b>IDL Absolute Name</b> ::INetMod::InOut1
<li> <b>Repository Identifier</b> IDL:INetMod/InOut1:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface InOut1 {
      ::INetMod::Company passParam(
        inout ::INetMod::Company c
      );
    };
</pre>
</p>
*/
abstract public class _InOut1ImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements INetMod.InOut1 {
  protected INetMod.InOut1 _wrapper = null;
  public INetMod.InOut1 _this() {
    return this;
  }
  protected _InOut1ImplBase(java.lang.String name) {
    super(name);
  }
  public _InOut1ImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of INetMod.InOut1";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetMod/InOut1:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("passParam", 0, 0),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return INetMod._InOut1ImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(INetMod.InOut1 _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      INetMod.CompanyHolder c = new INetMod.CompanyHolder();
      c.value = INetMod.CompanyHelper.read(_input);
      INetMod.Company _result = _self.passParam(c);
      INetMod.CompanyHelper.write(_output, _result);
      INetMod.CompanyHelper.write(_output, c.value);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
