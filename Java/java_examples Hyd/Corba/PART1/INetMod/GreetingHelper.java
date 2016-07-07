package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.GreetingHelper
<li> <b>Source File</b> INetMod/GreetingHelper.java
<li> <b>IDL Source File</b> greeting.idl
<li> <b>IDL Absolute Name</b> ::INetMod::Greeting
<li> <b>Repository Identifier</b> IDL:INetMod/Greeting:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface Greeting {
      wstring TGreeting();
    };
</pre>
</p>
*/
abstract public class GreetingHelper {
  public static INetMod.Greeting narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static INetMod.Greeting narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof INetMod.Greeting) {
      return (INetMod.Greeting) object;
    }
    if(is_a || object._is_a(id())) {
      INetMod._st_Greeting result = (INetMod._st_Greeting)new INetMod._st_Greeting();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (INetMod.Greeting) result._this();
    }
    return null;
  }
  public static INetMod.Greeting bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static INetMod.Greeting bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static INetMod.Greeting bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
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
  public static INetMod.Greeting read(org.omg.CORBA.portable.InputStream _input) {
    return INetMod.GreetingHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, INetMod.Greeting value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, INetMod.Greeting value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static INetMod.Greeting extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "Greeting");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:INetMod/Greeting:1.0";
  }
}
