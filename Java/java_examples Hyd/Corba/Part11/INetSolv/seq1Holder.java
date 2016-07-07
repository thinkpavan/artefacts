package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.seq1Holder
<li> <b>Source File</b> INetSolv/seq1Holder.java
<li> <b>IDL Source File</b> sequencebasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::seq1
<li> <b>Repository Identifier</b> IDL:INetSolv/seq1:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    typedef sequence&ltlong&gt seq1;
</pre>
</p>
*/
final public class seq1Holder implements org.omg.CORBA.portable.Streamable {
  public int[] value;
  public seq1Holder() {
  }
  public seq1Holder(int[] value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetSolv.seq1Helper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetSolv.seq1Helper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetSolv.seq1Helper.type();
  }
}
