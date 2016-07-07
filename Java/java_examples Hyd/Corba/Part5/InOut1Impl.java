/* implementation of Server Object
Version : 1.0
Author : Team - J
*/
public class InOut1Impl extends INetMod._InOut1ImplBase {
  public InOut1Impl(java.lang.String name) {
    super(name);
  }
  public InOut1Impl() {
    super();
  }
  
  public INetMod.Company passParam(
    INetMod.CompanyHolder c
  ) {
    // IMPLEMENT: Operation
	INetMod.Company lc = c.value;
	System.out.println("----Company Received from Client----");
	System.out.println(lc.name);
	System.out.println(lc.yoe);
	System.out.println(lc.ceo);
	System.out.println(lc.otherattrib);
	System.out.println("------------------------------------");
	//lc = new INetMod.Company(); //comment this and run the server
	lc.name = new String("ABC Inc");
	lc.yoe =212112; // some no indicating a date
	lc.ceo = new String("new Ceo");
	lc.otherattrib = new String("abcdef");
    //return null; 
	return lc;
  }
}
