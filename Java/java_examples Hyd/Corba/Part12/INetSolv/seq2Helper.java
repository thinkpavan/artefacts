package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.seq2Helper
<li> <b>Source File</b> INetSolv/seq2Helper.java
<li> <b>IDL Source File</b> BSequenceBasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::seq2
<li> <b>Repository Identifier</b> IDL:INetSolv/seq2:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    typedef sequence&ltshort,10&gt seq2;
</pre>
</p>
*/
abstract public class seq2Helper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static short[] read(org.omg.CORBA.portable.InputStream _input) {
    short[] result;
    {
      int _length3 = _input.read_long();
      if(_length3 > 10) {
        throw new org.omg.CORBA.BAD_PARAM("Sequence exceeded bound");
      }
      result = new short[_length3];
      for(int _i3 = 0; _i3 < _length3; _i3++) {
        result[_i3] = _input.read_short();
      }
    }
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, short[] value) {
    if(value.length > 10) {
      throw new org.omg.CORBA.BAD_PARAM("Sequence exceeded bound");
    }
    _output.write_long(value.length);
    for(int _i2 = 0; _i2 < value.length; _i2++) {
      _output.write_short(value[_i2]);
    }
  }
  public static void insert(org.omg.CORBA.Any any, short[] value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static short[] extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.TypeCode original_type = _orb().create_sequence_tc(10, _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_short));
      _type = _orb().create_alias_tc(id(), "seq2", original_type);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:INetSolv/seq2:1.0";
  }
}
