package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.ArrayBasicHelper
<li> <b>Source File</b> INetSolv/ArrayBasicHelper.java
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
abstract public class ArrayBasicHelper {
  public static INetSolv.ArrayBasic narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static INetSolv.ArrayBasic narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof INetSolv.ArrayBasic) {
      return (INetSolv.ArrayBasic) object;
    }
    if(is_a || object._is_a(id())) {
      INetSolv._st_ArrayBasic result = (INetSolv._st_ArrayBasic)new INetSolv._st_ArrayBasic();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (INetSolv.ArrayBasic) result._this();
    }
    return null;
  }
  public static INetSolv.ArrayBasic bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static INetSolv.ArrayBasic bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static INetSolv.ArrayBasic bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
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
  public static INetSolv.ArrayBasic read(org.omg.CORBA.portable.InputStream _input) {
    return INetSolv.ArrayBasicHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, INetSolv.ArrayBasic value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, INetSolv.ArrayBasic value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static INetSolv.ArrayBasic extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "ArrayBasic");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:INetSolv/ArrayBasic:1.0";
  }
}
