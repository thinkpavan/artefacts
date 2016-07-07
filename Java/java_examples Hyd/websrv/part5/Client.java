package handler;

import handler.*;

public class Client {
	 public static void main(String[] args) {
		 try {
			 Wsrv_Impl proxy = new Wsrv_Impl(args[0]);
			 WsrvPort  p = proxy.getwsrvPort();
			 System.out.println(p.getMsg("Student"));
			 } catch (Exception e)
		 {
		 	e.printStackTrace();
		 }
	 }
} 
