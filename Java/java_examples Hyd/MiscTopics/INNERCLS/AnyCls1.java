/* Shows how to create and use Anonymous  classes
Author : Team -J
Version : 1.0
*/

import java.io.*;
import java.net.*;

public class AnyCls1{
public static void main(String args[])throws Exception{
	Object o = new Object(){
		public String toString(){
			return (" object of anonymous class");
		}
		}; //end of anonymous class	
		System.out.println(o.toString());
	}	
}

