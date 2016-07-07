package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._example_SequenceBasic
<li> <b>Source File</b> INetSolv/_example_SequenceBasic.java
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
public class _example_SequenceBasic extends INetSolv._SequenceBasicImplBase {
  /** Construct a persistently named object. */
  public _example_SequenceBasic(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_SequenceBasic() {
    super();
  }
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
  ) {
    // IMPLEMENT: Operation
  }
}
