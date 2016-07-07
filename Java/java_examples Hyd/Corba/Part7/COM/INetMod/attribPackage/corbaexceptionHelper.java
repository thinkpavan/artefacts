  package com.INetMod.attribPackage;
  /**
  <p>
  <ul>
  <li> <b>Java Class</b> com.INetMod.attribPackage.corbaexceptionHelper
  <li> <b>Source File</b> com/INetMod/attribPackage/corbaexceptionHelper.java
  <li> <b>IDL Source File</b> attrib.idl
  <li> <b>IDL Absolute Name</b> ::com::INetMod::attrib::corbaexception
  <li> <b>Repository Identifier</b> IDL:com/INetMod/attrib/corbaexception:1.0
  </ul>
  <b>IDL definition:</b>
  <pre>
    #pragma prefix "com/INetMod/attrib"
    exception corbaexception {
      string exstr;
    };
  </pre>
  </p>
  */
  abstract public class corbaexceptionHelper {
    private static org.omg.CORBA.ORB _orb() {
      return org.omg.CORBA.ORB.init();
    }
    public static com.INetMod.attribPackage.corbaexception read(org.omg.CORBA.portable.InputStream _input) {
      if(!_input.read_string().equals(id())) {
        throw new org.omg.CORBA.MARSHAL("Mismached repository id");
      }
      com.INetMod.attribPackage.corbaexception result = new com.INetMod.attribPackage.corbaexception();
      result.exstr = _input.read_string();
      return result;
    }
    public static void write(org.omg.CORBA.portable.OutputStream _output, com.INetMod.attribPackage.corbaexception value) {
      _output.write_string(id());
      _output.write_string(value.exstr);
    }
    public static void insert(org.omg.CORBA.Any any, com.INetMod.attribPackage.corbaexception value) {
      org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
      write(output, value);
      any.read_value(output.create_input_stream(), type());
    }
    public static com.INetMod.attribPackage.corbaexception extract(org.omg.CORBA.Any any) {
      if(!any.type().equal(type())) {
        throw new org.omg.CORBA.BAD_TYPECODE();
      }
      return read(any.create_input_stream());
    }
    private static org.omg.CORBA.TypeCode _type;
    public static org.omg.CORBA.TypeCode type() {
      if(_type == null) {
        org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[1];
        members[0] = new org.omg.CORBA.StructMember("exstr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
        _type = (_orb()).create_exception_tc(id(), "corbaexception", members);
      }
      return _type;
    }
    public static java.lang.String id() {
      return "IDL:com/INetMod/attrib/corbaexception:1.0";
    }
  }
