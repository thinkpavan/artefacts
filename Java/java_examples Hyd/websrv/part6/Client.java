package multipjc;

import multipjc.*;

public class Client {
	 public static void main(String[] args) {
		 try {
			 Pjc_Impl proxy = new Pjc_Impl(args[0]);
			 PjcPort  p = proxy.getpjcPort();
			 System.out.println(p);
			 System.out.println(p.method1("student"));
			 System.out.println(p.method2("student1","student2"));
			 } catch (Exception e)
		 {
		 	e.printStackTrace();
		 }
	 }
} 
