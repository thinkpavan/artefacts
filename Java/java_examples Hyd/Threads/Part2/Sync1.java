/* shows what happens when more than one sync method is
there in a class problem
Author : Team -J
Version : 1.0 */
class Sync1{
  static public void main(String[] args)throws Exception{
    SomeObject so = new SomeObject();
    SomeThread st1 = new SomeThread(so);
    st1.setName("Thread One");
    st1.start();
    SomeThread st2 = new SomeThread(so);
    st2.setName("Thread Two");
    st2.start();
  }
}

class SomeThread  extends Thread{
 SomeObject  so;
 public SomeThread(SomeObject so){
	this.so = so;
 }
 public void run(){
	so.sync1();
	try{
		sleep(300);// comment out this line and see the result
	}catch(Exception e){}
	so.sync2();
 }
 public String toString(){
	return(getName());
 }
}

class SomeObject{
	synchronized void sync1(){
		System.out.println(Thread.currentThread()+ "  in sync 1 method");
	}
	synchronized void sync2(){
		System.out.println(Thread.currentThread()+"  in sync 2 method");
	}
}
