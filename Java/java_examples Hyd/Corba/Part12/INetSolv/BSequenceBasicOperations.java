package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.BSequenceBasicOperations
<li> <b>Source File</b> INetSolv/BSequenceBasicOperations.java
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
public interface BSequenceBasicOperations {
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
