package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.larrayHolder
<li> <b>Source File</b> INetSolv/larrayHolder.java
<li> <b>IDL Source File</b> ArrayBasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::larray
<li> <b>Repository Identifier</b> IDL:INetSolv/larray:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    typedef long larray[20];
</pre>
</p>
*/
final public class larrayHolder implements org.omg.CORBA.portable.Streamable {
  public int[] value;
  public larrayHolder() {
  }
  public larrayHolder(int[] value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetSolv.larrayHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetSolv.larrayHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetSolv.larrayHelper.type();
  }
}
