package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.sarrayHolder
<li> <b>Source File</b> INetSolv/sarrayHolder.java
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
final public class sarrayHolder implements org.omg.CORBA.portable.Streamable {
  public short[][] value;
  public sarrayHolder() {
  }
  public sarrayHolder(short[][] value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetSolv.sarrayHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetSolv.sarrayHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetSolv.sarrayHelper.type();
  }
}
