/* Shows how to get details of  constructors
Author : Team -J
Version : 1.0
*/

import java.lang.reflect.*;

public class Constructors{
	public static void main(String args[])throws Exception{
		Class c = Class.forName("java.lang.String");
		System.out.println(c);
		// get reference to an array representing the constructors
		java.lang.reflect.Constructor conarr[] = c.getConstructors();
		for(int i = 0;i<conarr.length;i++){
			System.out.println("Modifier for Constructor " + i +" = "+ conarr[i].getModifiers());
			Class paramtypes[] = conarr[i].getParameterTypes();
			for(int j =0; j < paramtypes.length;j++)
				System.out.println(paramtypes[j]);
			System.out.println("-----------------------------------\n");
		}
		// where can this be used ???
		// in earlier classes we have seen how to dynamically 
		// create an object by using zero arg constructors
		// now let us see how to create a constructor which takes
		// parameters
		//public Object newInstance(Object[] initargs)
		// we know that second constructor takes string as param, let us use
		// second constructor to dynamically create a string object
		String s = new String("INetSolv");
		Object initargs[] = new Object[1]; // create init args array to hold only one object
		initargs[0] = s;
		String dynstring =(String) conarr[1].newInstance(initargs);
		System.out.println("string that is dynamically constructed "+dynstring);
	}	
}

