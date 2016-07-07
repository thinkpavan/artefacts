package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.SequenceBasicHolder
<li> <b>Source File</b> INetSolv/SequenceBasicHolder.java
<li> <b>IDL Source File</b> sequencebasic.idl
<li> <b>IDL Absolute Name</b> ::INetSolv::SequenceBasic
<li> <b>Repository Identifier</b> IDL:INetSolv/SequenceBasic:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "INetSolv"
    interface SequenceBasic {
      void modifySequence(
        inout ::INetSolv::seq1 inoutSeq,
        in ::INetSolv::seq2 inSeq
      );
    };
</pre>
</p>
*/
final public class SequenceBasicHolder implements org.omg.CORBA.portable.Streamable {
  public INetSolv.SequenceBasic value;
  public SequenceBasicHolder() {
  }
  public SequenceBasicHolder(INetSolv.SequenceBasic value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = INetSolv.SequenceBasicHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    INetSolv.SequenceBasicHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return INetSolv.SequenceBasicHelper.type();
  }
}
