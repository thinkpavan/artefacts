package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._tie_BSequenceBasic
<li> <b>Source File</b> INetSolv/_tie_BSequenceBasic.java
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
public class _tie_BSequenceBasic extends INetSolv._BSequenceBasicImplBase {
  private INetSolv.BSequenceBasicOperations _delegate;
  public _tie_BSequenceBasic(INetSolv.BSequenceBasicOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_BSequenceBasic(INetSolv.BSequenceBasicOperations delegate) {
    this._delegate = delegate;
  }
  public INetSolv.BSequenceBasicOperations _delegate() {
    return this._delegate;
  }
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
  ) {
    this._delegate.modifySequence(
      inoutSeq,
      inSeq
    );
  }
}
