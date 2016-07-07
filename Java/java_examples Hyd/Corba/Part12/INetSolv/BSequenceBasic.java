package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.BSequenceBasic
<li> <b>Source File</b> INetSolv/BSequenceBasic.java
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
public interface BSequenceBasic extends com.inprise.vbroker.CORBA.Object {
  /**
  <p>
  Operation: <b>::INetSolv::BSequenceBasic::modifySequence</b>.
  <pre>
    #pragma prefix "INetSolv/BSequenceBasic"
    void modifySequence(
      inout ::INetSolv::seq1 inoutSeq,
      in ::INetSolv::seq2 inSeq
    );
  </pre>
  </p>
  */
  public void modifySequence(
    INetSolv.seq1Holder inoutSeq,
    short[] inSeq
  );
}
