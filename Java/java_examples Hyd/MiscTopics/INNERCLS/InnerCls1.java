/* Shows how to create and use inner classes
Author : Team -J
Version : 1.0
*/

import java.io.*;
import java.net.*;

public class InnerCls1{
		private int x ;
		public InnerCls1(int var){
			x=var;
		}
	// class declared inside a class
	class innercls{
	//	private int x=44 ;  ??
		public void method1(){
			// let us try to access private class of InnerCls1
			System.out.println("In inner class var x = "+ x);
		}
	}
// methods of InnerCls1
	public static void main(String args[])throws Exception{
		InnerCls1 ic1 = new InnerCls1(11);
		InnerCls1 ic2 = new InnerCls1(22);
	//	innercls inc = new innercls(); ??
		ic2.somemethod();
		ic1.somemethod();
	}	
	public void somemethod(){
		innercls ic = new innercls();
		ic.method1();
	}
}

