package ws1;

import ws1.*;

public class Client {
	 public static void main(String[] args) {
		 try {
			 Ws1ejb_Impl proxy = new Ws1ejb_Impl(args[0]);
			 Ws1ejbPort  p = proxy.getws1ejbPort();
			 System.out.println(p);
			 System.out.println(p.getMessage("student"));
			 } catch (Exception e)
		 {
		 	e.printStackTrace();
		 }
	 }
} 
