/* shows how to use RunTime class
Author : Team - J
Version : 1.0
*/

public class RT{
	public static void main(String args[])throws Exception{
	// runtime class allows java program to interact with it's runtime
	// environment
		Runtime rt = Runtime.getRuntime();
		rt.traceInstructions(true); //depends on implementation , runtime may
		// totally ignore this
		rt.traceMethodCalls(true);
		System.out.println(rt.totalMemory());
		System.out.println(rt.freeMemory());		
//runtime.exec can be used to invoke an external program 
// check cgi-impl directory for details on how to invoke an external program
		rt.exit(0);// same as system.exit method
	}
}
