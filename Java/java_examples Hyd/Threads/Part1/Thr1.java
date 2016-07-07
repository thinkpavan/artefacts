/* Program to create thread by sub classing Thread class
Author : Team -J
Version : 1.0 */
class Thr1{
  static public void main(String[] args)throws Exception{
    Thread th = new MyThr1();
	th.start();
	//Thread.currentThread().sleep(5000);
	Thread tha[] = new Thread[10];
	int not;
	not = Thread.enumerate(tha);
	for(int i = 0; i<100;i++){
		System.out.println("===");
	//	Thread.currentThread().sleep(10);
	}
	System.out.println("=======================");	
}
}

class MyThr1  extends Thread{
  public void run(){
	for(int i= 0;i <100; i++)
        System.out.println(Thread.currentThread());
  }
}
