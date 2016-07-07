package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.seq2Holder
<li> <b>Source File</b> INetSolv/seq2Holder.java
<li> <b>IDL Source File</b> BSequenceBasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::seq2
<li> <b>Repository Identifier</b> IDL:INetSolv/seq2:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    typedef sequence&ltshort,10&gt seq2;
</pre>
</p>
*/
final public class seq2Holder implements org.omg.CORBA.portable.Streamable {
  public short[] value;
  public seq2Holder() {
  }
  public seq2Holder(short[] value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetSolv.seq2Helper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetSolv.seq2Helper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetSolv.seq2Helper.type();
  }
}
