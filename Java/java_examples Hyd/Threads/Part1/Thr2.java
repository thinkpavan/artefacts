/* Program to create thread by implementing Runnable interface
Author : Team -J
Version : 1.0 */
class Thr2{
  static public void main(String[] args)throws Exception{
    Thread th = new Thread( new MyThr2());
	th.start();
	//Thread.currentThread().sleep(5000);
	Thread tha[] = new Thread[10];
	int not;
	not = Thread.enumerate(tha);
	for(int i = 0; i<not;i++){
		System.out.println(tha[i]);
	}
	System.out.println("=======================");	
}
}

class MyThr2  implements Runnable{
  public void run(){
	for(int i= 0;i <10; i++)
        System.out.println(Thread.currentThread());
  }
}
