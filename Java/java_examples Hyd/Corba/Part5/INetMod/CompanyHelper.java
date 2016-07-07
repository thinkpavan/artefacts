package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.CompanyHelper
<li> <b>Source File</b> INetMod/CompanyHelper.java
<li> <b>IDL Source File</b> inout1.idl
<li> <b>IDL Absolute Name</b> ::INetMod::Company
<li> <b>Repository Identifier</b> IDL:INetMod/Company:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    struct Company {
      string name;
      long yoe;
      string ceo;
      string otherattrib;
    };
</pre>
</p>
*/
abstract public class CompanyHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static INetMod.Company read(org.omg.CORBA.portable.InputStream _input) {
    INetMod.Company result = new INetMod.Company();
    result.name = _input.read_string();
    result.yoe = _input.read_long();
    result.ceo = _input.read_string();
    result.otherattrib = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, INetMod.Company value) {
    _output.write_string(value.name);
    _output.write_long(value.yoe);
    _output.write_string(value.ceo);
    _output.write_string(value.otherattrib);
  }
  public static void insert(org.omg.CORBA.Any any, INetMod.Company value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static INetMod.Company extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[4];
      members[0] = new org.omg.CORBA.StructMember("name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("yoe", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
      members[2] = new org.omg.CORBA.StructMember("ceo", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("otherattrib", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "Company", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:INetMod/Company:1.0";
  }
}
