
public class SequenceBasicImpl extends INetSolv._SequenceBasicImplBase {
  public SequenceBasicImpl(java.lang.String name) {
    super(name);
  }
  public SequenceBasicImpl() {
    super();
  }
  
  public void modifySequence(
    INetSolv.seq1Holder inoutSeq,
    short[] inSeq
  ) {
    // IMPLEMENT: Operation
	int i =0;
	for(i=0;i<inSeq.length;i++){
		System.out.println(" seq val = "+ inSeq[i]);
		inoutSeq.value[i] = inSeq[i]; // a simple stmt manuplating out sequence
	}
  }
}
