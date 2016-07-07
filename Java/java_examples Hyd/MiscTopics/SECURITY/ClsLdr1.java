/* Shows how to use classloaders
Author : Team -J
Version : 1.0
*/
public class ClsLdr1{
	public static void main(String args[])throws Exception{
		INSClsLdr1 cl = new INSClsLdr1();
		Class c = cl.loadClass("INetSolv");
		System.out.println(c);
		Object in = c.newInstance();
		System.out.println(in);
		System.out.println(c.getClassLoader());
		INetSolv i = (INetSolv)in;
		i.print();
	}	
}

