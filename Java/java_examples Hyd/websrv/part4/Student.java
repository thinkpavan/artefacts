/* This shows how to create our own data types to be passed as
args to web service.
Author : Team -J
Version : 1.0
*/
/*
1) Define no - arg constructor.
2) Define getXXX and setXXX methods for all variables that we need to expose.
3) All variables must be built-in or the types created like this.
*/

package NBDT;


import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private String address;
	
	public Student(){}
	public void setName(String n){
		this.name = n;
	}
	public String getName(){
		return name;
	}
	public void setAddress(String n){
		this.address = n;
	}
	public String getAddress(){
		return address;
	}
	public void printData(){
		System.out.println(" Name: " + name);
		System.out.println(" Address: " + address);
	}
}
