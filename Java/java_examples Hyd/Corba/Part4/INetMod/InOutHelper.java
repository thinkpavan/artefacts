package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.InOutHelper
<li> <b>Source File</b> INetMod/InOutHelper.java
<li> <b>IDL Source File</b> inout.idl
<li> <b>IDL Absolute Name</b> ::INetMod::InOut
<li> <b>Repository Identifier</b> IDL:INetMod/InOut:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface InOut {
      void passParam(
        out short s,
        inout wchar w
      );
      void passParam1(
        inout string s,
        inout wstring ws
      );
    };
</pre>
</p>
*/
abstract public class InOutHelper {
  public static INetMod.InOut narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static INetMod.InOut narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof INetMod.InOut) {
      return (INetMod.InOut) object;
    }
    if(is_a || object._is_a(id())) {
      INetMod._st_InOut result = (INetMod._st_InOut)new INetMod._st_InOut();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (INetMod.InOut) result._this();
    }
    return null;
  }
  public static INetMod.InOut bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static INetMod.InOut bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static INetMod.InOut bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
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
  public static INetMod.InOut read(org.omg.CORBA.portable.InputStream _input) {
    return INetMod.InOutHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, INetMod.InOut value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, INetMod.InOut value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static INetMod.InOut extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "InOut");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:INetMod/InOut:1.0";
  }
}
