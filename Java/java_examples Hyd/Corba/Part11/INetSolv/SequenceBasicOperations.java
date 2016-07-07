package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv.SequenceBasicOperations
<li> <b>Source File</b> INetSolv/SequenceBasicOperations.java
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
public interface SequenceBasicOperations {
  /**
  <p>
  Operation: <b>::INetSolv::SequenceBasic::modifySequence</b>.
  <pre>
    #pragma prefix "INetSolv/SequenceBasic"
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
