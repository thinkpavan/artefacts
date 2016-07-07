package com.INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> com.INetMod._attribImplBase
<li> <b>Source File</b> com/INetMod/_attribImplBase.java
<li> <b>IDL Source File</b> attrib.idl
<li> <b>IDL Absolute Name</b> ::com::INetMod::attrib
<li> <b>Repository Identifier</b> IDL:com/INetMod/attrib:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/INetMod"
    interface attrib {
      attribute long count;
      readonly attribute short ro;
      exception corbaexception {
        string exstr;
      };
      void dooperation(
      )
      raises(
        ::com::INetMod::attrib::corbaexception
      );
    };
</pre>
</p>
*/
abstract public class _attribImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements com.INetMod.attrib {
  protected com.INetMod.attrib _wrapper = null;
  public com.INetMod.attrib _this() {
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
      return "Unbound instance of com.INetMod.attrib";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/INetMod/attrib:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("dooperation", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("_set_count", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("_get_count", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("_get_ro", 0, 3),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return com.INetMod._attribImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(com.INetMod.attrib _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      try {
        _self.dooperation();
      }
      catch(com.INetMod.attribPackage.corbaexception _exception) {
        com.INetMod.attribPackage.corbaexceptionHelper.write(_output, _exception);
        return true;
      }
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
	System.out.println("In skeleton count = "+ _result);
      _output.write_long(_result);
      return false;
    }
    case 3: {
      short _result = _self.ro();
      _output.write_short(_result);
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
