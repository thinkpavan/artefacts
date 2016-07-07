package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.SequenceBasicHelper
<li> <b>Source File</b> INetSolv/SequenceBasicHelper.java
<li> <b>IDL Source File</b> sequencebasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::SequenceBasic
<li> <b>Repository Identifier</b> IDL:INetSolv/SequenceBasic:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface SequenceBasic {
      void modifySequence(
        inout ::INetSolv::seq1 inoutSeq,
        in ::INetSolv::seq2 inSeq
      );
    };
</pre>
</p>
*/
abstract public class SequenceBasicHelper {
  public static INetSolv.SequenceBasic narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static INetSolv.SequenceBasic narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof INetSolv.SequenceBasic) {
      return (INetSolv.SequenceBasic) object;
    }
    if(is_a || object._is_a(id())) {
      INetSolv._st_SequenceBasic result = (INetSolv._st_SequenceBasic)new INetSolv._st_SequenceBasic();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (INetSolv.SequenceBasic) result._this();
    }
    return null;
  }
  public static INetSolv.SequenceBasic bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static INetSolv.SequenceBasic bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static INetSolv.SequenceBasic bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
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
  public static INetSolv.SequenceBasic read(org.omg.CORBA.portable.InputStream _input) {
    return INetSolv.SequenceBasicHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, INetSolv.SequenceBasic value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, INetSolv.SequenceBasic value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static INetSolv.SequenceBasic extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "SequenceBasic");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:INetSolv/SequenceBasic:1.0";
  }
}
