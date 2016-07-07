package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.larrayHelper
<li> <b>Source File</b> INetSolv/larrayHelper.java
<li> <b>IDL Source File</b> ArrayBasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::larray
<li> <b>Repository Identifier</b> IDL:INetSolv/larray:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    typedef long larray[20];
</pre>
</p>
*/
abstract public class larrayHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static int[] read(org.omg.CORBA.portable.InputStream _input) {
    int[] result;
    {
      result = new int[20];
      for(int _i3 = 0; _i3 < 20; _i3++) {
        result[_i3] = _input.read_long();
      }
    }
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, int[] value) {
    if(value.length != 20) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    for(int _i2 = 0; _i2 < value.length; _i2++) {
      _output.write_long(value[_i2]);
    }
  }
  public static void insert(org.omg.CORBA.Any any, int[] value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static int[] extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.TypeCode original_type = _orb().create_array_tc(20, _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long));
      _type = _orb().create_alias_tc(id(), "larray", original_type);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:INetSolv/larray:1.0";
  }
}
