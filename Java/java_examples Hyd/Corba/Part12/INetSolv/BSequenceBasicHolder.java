package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.BSequenceBasicHolder
<li> <b>Source File</b> INetSolv/BSequenceBasicHolder.java
<li> <b>IDL Source File</b> BSequenceBasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::BSequenceBasic
<li> <b>Repository Identifier</b> IDL:INetSolv/BSequenceBasic:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface BSequenceBasic {
      void modifySequence(
        inout ::INetSolv::seq1 inoutSeq,
        in ::INetSolv::seq2 inSeq
      );
    };
</pre>
</p>
*/
final public class BSequenceBasicHolder implements org.omg.CORBA.portable.Streamable {
  public INetSolv.BSequenceBasic value;
  public BSequenceBasicHolder() {
  }
  public BSequenceBasicHolder(INetSolv.BSequenceBasic value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetSolv.BSequenceBasicHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetSolv.BSequenceBasicHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetSolv.BSequenceBasicHelper.type();
  }
}
