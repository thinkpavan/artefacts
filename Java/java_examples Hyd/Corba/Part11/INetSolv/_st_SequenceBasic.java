package INetSolv;
/**
<p>
<ul>
<li> <b>Java Class</b> INetSolv._st_SequenceBasic
<li> <b>Source File</b> INetSolv/_st_SequenceBasic.java
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
public class _st_SequenceBasic extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements INetSolv.SequenceBasic {
  protected INetSolv.SequenceBasic _wrapper = null;
  public INetSolv.SequenceBasic _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:INetSolv/SequenceBasic:1.0"
  };
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
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("modifySequence", true);
      INetSolv.seq1Helper.write(_output, inoutSeq.value);
      INetSolv.seq2Helper.write(_output, inSeq);
      try {
        _input = this._invoke(_output, null);
        inoutSeq.value = INetSolv.seq1Helper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
  }
}
