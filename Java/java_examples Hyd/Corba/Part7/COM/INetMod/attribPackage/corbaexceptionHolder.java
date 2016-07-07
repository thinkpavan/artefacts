  package com.INetMod.attribPackage;
  /**
  <p>
  <ul>
  <li> <b>Java Class</b> com.INetMod.attribPackage.corbaexceptionHolder
  <li> <b>Source File</b> com/INetMod/attribPackage/corbaexceptionHolder.java
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
  final public class corbaexceptionHolder implements org.omg.CORBA.portable.Streamable {
    public com.INetMod.attribPackage.corbaexception value;
    public corbaexceptionHolder() {
    }
    public corbaexceptionHolder(com.INetMod.attribPackage.corbaexception value) {
      this.value = value;
    }
    public void _read(org.omg.CORBA.portable.InputStream input) {
      value = com.INetMod.attribPackage.corbaexceptionHelper.read(input);
    }
    public void _write(org.omg.CORBA.portable.OutputStream output) {
      com.INetMod.attribPackage.corbaexceptionHelper.write(output, value);
    }
    public org.omg.CORBA.TypeCode _type() {
      return com.INetMod.attribPackage.corbaexceptionHelper.type();
    }
  }
