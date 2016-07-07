package com.INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> com.INetMod.attribHelper
<li> <b>Source File</b> com/INetMod/attribHelper.java
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
abstract public class attribHelper {
  public static com.INetMod.attrib narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static com.INetMod.attrib narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof com.INetMod.attrib) {
      return (com.INetMod.attrib) object;
    }
    if(is_a || object._is_a(id())) {
      com.INetMod._st_attrib result = (com.INetMod._st_attrib)new com.INetMod._st_attrib();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (com.INetMod.attrib) result._this();
    }
    return null;
  }
  public static com.INetMod.attrib bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static com.INetMod.attrib bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static com.INetMod.attrib bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
    if (orb instanceof com.visigenic.vbroker.orb.ORB) {
      return narrow(((com.visigenic.vbroker.orb.ORB)orb).bind(id(), name, host, options), true);
    }
    else {
      throw new org.omg.CORBA.BAD_PARAM();
    }
  }
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.INetMod.attrib read(org.omg.CORBA.portable.InputStream _input) {
    return com.INetMod.attribHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.INetMod.attrib value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, com.INetMod.attrib value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.INetMod.attrib extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "attrib");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/INetMod/attrib:1.0";
  }
}
