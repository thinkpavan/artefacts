package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._tie_SequenceBasic
<li> <b>Source File</b> INetSolv/_tie_SequenceBasic.java
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
public class _tie_SequenceBasic extends INetSolv._SequenceBasicImplBase {
  private INetSolv.SequenceBasicOperations _delegate;
  public _tie_SequenceBasic(INetSolv.SequenceBasicOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_SequenceBasic(INetSolv.SequenceBasicOperations delegate) {
    this._delegate = delegate;
  }
  public INetSolv.SequenceBasicOperations _delegate() {
    return this._delegate;
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
    this._delegate.modifySequence(
      inoutSeq,
      inSeq
    );
  }
}
