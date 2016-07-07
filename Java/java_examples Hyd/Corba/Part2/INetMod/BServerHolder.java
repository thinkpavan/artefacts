package INetMod;
/**
<p>
<ul>
<li> <b>Java Class</b> INetMod.BServerHolder
<li> <b>Source File</b> INetMod/BServerHolder.java
<li> <b>IDL Source File</b> BServer.idl
<li> <b>IDL Absolute Name</b> ::INetMod::BServer
<li> <b>Repository Identifier</b> IDL:INetMod/BServer:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetMod"
    interface BServer {
      short someShort();
      float someFloat();
      long someLong();
      double someDouble();
      unsigned long someULong();
      char someChar();
      wchar someWChar();
      boolean someBoolean();
    };
</pre>
</p>
*/
final public class BServerHolder implements org.omg.CORBA.portable.Streamable {
  public INetMod.BServer value;
  public BServerHolder() {
  }
  public BServerHolder(INetMod.BServer value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetMod.BServerHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetMod.BServerHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetMod.BServerHelper.type();
  }
}
