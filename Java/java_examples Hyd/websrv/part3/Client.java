package PJWS;

import PJWS.*;

public class Client {
	 public static void main(String[] args) {
		 try {
			 Pjws_Impl proxy = new Pjws_Impl(args[0]);
			 PjwsPort  p = proxy.getpjwsPort();
			 System.out.println(p);
			 System.out.println(p.method1("student"));
			 System.out.println(p.method2("student1","student2"));
			 } catch (Exception e)
		 {
		 	e.printStackTrace();
		 }
	 }
} 
