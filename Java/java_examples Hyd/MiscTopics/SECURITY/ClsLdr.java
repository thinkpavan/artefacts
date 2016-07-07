/* Shows how to use classloaders
Author : Team -J
Version : 1.0
Run this example by placing inetsolv class file on web server once and
then on java CLASSPATH
*/
public class ClsLdr{
	public static void main(String args[])throws Exception{
		INSClsLdr cl = new INSClsLdr();
		Class c = cl.defineClass("INetSolv");
		System.out.println(c);
		Object in = c.newInstance();
		System.out.println(in);
		System.out.println(c.getClassLoader());
		INetSolv i = (INetSolv)in;
		i.print();
	}	
}

