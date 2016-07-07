public class ArrayBasicImpl extends INetSolv._ArrayBasicImplBase {
  public ArrayBasicImpl(java.lang.String name) {
    super(name);
  }
  public ArrayBasicImpl() {
    super();
  }
 
  public void modifyArray(
    INetSolv.larrayHolder inoutarr,
    short[][] inarr) {
//perform some operation
	for(int i = 0; i<20;i++)
		inoutarr.value[i] += inarr[0][i]+inarr[1][i];
  }
}
