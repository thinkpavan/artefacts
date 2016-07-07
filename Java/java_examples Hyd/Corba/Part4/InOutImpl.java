public class InOutImpl extends INetMod._InOutImplBase {
  public InOutImpl(java.lang.String name) {
    super(name);
  }
  public InOutImpl() {
    super();
  }
// following method takes in out params (out,inout)
  public void passParam(
    org.omg.CORBA.ShortHolder s,
    org.omg.CORBA.CharHolder w
  ) {
    // IMPLEMENT: Operation
// remember we have set the out value in client before calling this method
	System.out.println("Value of out variable before setting "+ s.value);
	s.value = (short)10;
	w.value = 'a';
  }
// following method takes in out params

  public void passParam1(
    org.omg.CORBA.StringHolder s,
    org.omg.CORBA.StringHolder ws
  ) {
    // IMPLEMENT: Operation
// value is a public field in holder classes
	System.out.println("value passed for s = " + s.value);
	System.out.println("value passed for ws = " + ws.value);
	s.value =new String("string value set by Server");
	ws.value =new String("wstring value set by Server");
  }
}
