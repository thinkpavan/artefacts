package com.INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> com.INetMod.attribHolder
<li> <b>Source File</b> com/INetMod/attribHolder.java
<li> <b>IDL Source File</b> attrib.idl
<li> <b>IDL Absolute Name</b> ::com::INetMod::attrib
<li> <b>Repository Identifier</b> IDL:com/INetMod/attrib:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/INetMod"
    interface attrib {
      attribute long count;
      readonly attribute short ro;
      exception corbaexception {
        string exstr;
      };
      void dooperation(
      )
      raises(
        ::com::INetMod::attrib::corbaexception
      );
    };
</pre>
</p>
*/
final public class attribHolder implements org.omg.CORBA.portable.Streamable {
  public com.INetMod.attrib value;
  public attribHolder() {
  }
  public attribHolder(com.INetMod.attrib value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.INetMod.attribHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.INetMod.attribHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.INetMod.attribHelper.type();
  }
}
