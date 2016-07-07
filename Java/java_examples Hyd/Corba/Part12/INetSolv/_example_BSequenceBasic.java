package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._example_BSequenceBasic
<li> <b>Source File</b> INetSolv/_example_BSequenceBasic.java
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
public class _example_BSequenceBasic extends INetSolv._BSequenceBasicImplBase {
  /** Construct a persistently named object. */
  public _example_BSequenceBasic(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_BSequenceBasic() {
    super();
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
    // IMPLEMENT: Operation
  }
}
