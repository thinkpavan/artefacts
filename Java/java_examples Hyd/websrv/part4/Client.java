package NBDT;

import NBDT.*;

public class Client {
	 public static void main(String[] args) {
		Student s = new Student();
		s.setName("Student Name");
		s.setAddress("Student Address");
		 try {
			 Ws4_Impl proxy = new Ws4_Impl(args[0]);
			 Ws4Port  p = proxy.getws4Port();
			 System.out.println(p.method1(s));
			 } catch (Exception e)
		 {
		 	e.printStackTrace();
		 }
	 }
} 
