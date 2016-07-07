/* Shows how to get details of methods
Author : Team -J
Version : 1.0
*/

import java.lang.reflect.*;

public class Methods{
	public static void main(String args[])throws Exception{
		Class c = Class.forName("java.lang.String");
		System.out.println(c);
		// get reference to an array representing the constructors
		java.lang.reflect.Method metarr[] = c.getMethods();
// let us examine methods in detail here
		for(int i = 0;i<metarr.length;i++){
			System.out.println( metarr[i].getName());
			System.out.println("Modifier for Method " + i +" = "+ metarr[i].getModifiers());
			Class paramtypes[] = metarr[i].getParameterTypes();
			for(int j =0; j < paramtypes.length;j++)
				System.out.println(paramtypes[j]);
			System.out.println("-----------------------------------\n");
		}
		// Let us see how to invoke a method by using reflection API
	//	public Object invoke(Object obj, Object[] args)
		// 52 nd  method in array is toupper case, we will invoke this now.
		Object arg[] = null; // no args need to be passed to this method
		String s = "i am a string object";
		Object ret = metarr[51].invoke(s,arg);
		String newstr = (String) ret;
		System.out.println(newstr);

	
	}	
}

