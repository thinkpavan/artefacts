/* shows some more deatils of  synchronized methods
Author : Team -J
Version : 1.0 */
class Sync2{
  static public void main(String[] args)throws Exception{
    SomeObject1 so = new SomeObject1();
    SomeThread1 st1 = new SomeThread1(so);
    st1.setName("Thread One");
    st1.start();
    SomeThread2 st2 = new SomeThread2(so);
    st2.setName("Thread Two");
    st2.start();
  }
}

class SomeThread1  extends Thread{
 SomeObject1  so;
 public SomeThread1(SomeObject1 so){
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

class SomeThread2  extends Thread{
 SomeObject1  so;
 public SomeThread2(SomeObject1 so){
	this.so = so;
 }
 public void run(){
	so.sync2();
	try{
	//	sleep(300);// comment out this line and see the result
	}catch(Exception e){}
	so.sync1();
 }
 public String toString(){
	return(getName());
 }
}

class SomeObject1{
	synchronized void sync1(){
		System.out.println(Thread.currentThread()+ "  in sync 1 method");
	}
	synchronized void sync2(){
		System.out.println(Thread.currentThread()+"  in sync 2 method");
	}
}
