package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.OneWayHelper
<li> <b>Source File</b> INetMod/OneWayHelper.java
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
abstract public class OneWayHelper {
  public static INetMod.OneWay narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static INetMod.OneWay narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof INetMod.OneWay) {
      return (INetMod.OneWay) object;
    }
    if(is_a || object._is_a(id())) {
      INetMod._st_OneWay result = (INetMod._st_OneWay)new INetMod._st_OneWay();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (INetMod.OneWay) result._this();
    }
    return null;
  }
  public static INetMod.OneWay bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static INetMod.OneWay bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static INetMod.OneWay bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
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
  public static INetMod.OneWay read(org.omg.CORBA.portable.InputStream _input) {
    return INetMod.OneWayHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, INetMod.OneWay value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, INetMod.OneWay value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static INetMod.OneWay extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "OneWay");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:INetMod/OneWay:1.0";
  }
}
