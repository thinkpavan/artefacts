package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.attribHolder
<li> <b>Source File</b> INetMod/attribHolder.java
<li> <b>IDL Source File</b> attrib.idl
<li> <b>IDL Absolute Name</b> ::INetMod::attrib
<li> <b>Repository Identifier</b> IDL:INetMod/attrib:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface attrib {
      attribute long count;
      void dooperation();
    };
</pre>
</p>
*/
final public class attribHolder implements org.omg.CORBA.portable.Streamable {
  public INetMod.attrib value;
  public attribHolder() {
  }
  public attribHolder(INetMod.attrib value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetMod.attribHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetMod.attribHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetMod.attribHelper.type();
  }
}
