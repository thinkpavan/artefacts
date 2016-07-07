/* Shows how to get details of Fields
Author : Team -J
Version : 1.0
*/

import java.lang.reflect.*;

public class Fields{
	public static void main(String args[])throws Exception{
		INetSolv in = new INetSolv();
		Class c = in.getClass();
		System.out.println(c);
		// get reference to an array representing the fields
		java.lang.reflect.Field fldarr[] = c.getFields();
	System.out.println(fldarr.length);
// let us examine fields in detail here
		for(int i = 0;i<fldarr.length;i++){
			System.out.println( fldarr[i].getName());
			System.out.println(fldarr[i].getType());
			System.out.println("-----------------------------------\n");
		}
// let us get /set the field values
		in.print();
		Object i = fldarr[0].get(in);
		Object s = new String("set by methods of Field class");
		fldarr[1].set(in,s);
		in.print();
		

	
	}	
}

