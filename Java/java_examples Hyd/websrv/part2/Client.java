package ws2;

import ws2.*;

public class Client {
	 public static void main(String[] args) {
		 try {
			 Ws2ejb_Impl proxy = new Ws2ejb_Impl(args[0]);
			 Ws2ejbPort  p = proxy.getws2ejbPort();
			 System.out.println(p);
			 System.out.println(p.method1("student"));
			 System.out.println(p.method2("student1","student2"));
			 } catch (Exception e)
		 {
		 	e.printStackTrace();
		 }
	 }
} 
