package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.sarrayHelper
<li> <b>Source File</b> INetSolv/sarrayHelper.java
<li> <b>IDL Source File</b> ArrayBasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::sarray
<li> <b>Repository Identifier</b> IDL:INetSolv/sarray:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    typedef short sarray[2][20];
</pre>
</p>
*/
abstract public class sarrayHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static short[][] read(org.omg.CORBA.portable.InputStream _input) {
    short[][] result;
    {
      result = new short[2][];
      for(int _i3 = 0; _i3 < 2; _i3++) {
        {
          result[_i3] = new short[20];
          for(int _i5 = 0; _i5 < 20; _i5++) {
            result[_i3][_i5] = _input.read_short();
          }
        }
      }
    }
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, short[][] value) {
    if(value.length != 2) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    for(int _i2 = 0; _i2 < value.length; _i2++) {
      if(value[_i2].length != 20) {
        throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
      }
      for(int _i3 = 0; _i3 < value[_i2].length; _i3++) {
        _output.write_short(value[_i2][_i3]);
      }
    }
  }
  public static void insert(org.omg.CORBA.Any any, short[][] value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static short[][] extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.TypeCode original_type = _orb().create_array_tc(2, _orb().create_array_tc(20, _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_short)));
      _type = _orb().create_alias_tc(id(), "sarray", original_type);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:INetSolv/sarray:1.0";
  }
}
