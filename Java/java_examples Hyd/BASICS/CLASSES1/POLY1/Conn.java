/* This  class is created to serve as a super class for different types of electrical
conections
Author : Team - J 
Version: 1.0*/

class Conn  { 
	private int connid;
      private String custname;
	Conn(int connid,String custname){
		this.connid=connid;
		this.custname=custname;
	}
	int getId(){
		return connid;
	}
	String  getName(){
		return custname;
	}
// we can provide setters, but we are not doing it 
	float claculateBill(int noofunits){
		return 0; // we cannot implement this here so we are using this tech here.
	}
		
}