/* Program to create thread by sub classing Thread class
Author : Team -J
Version : 1.0 */
class Thread1{
  static public void main(String[] args){
    Thread th = new MyThread1();
    Thread tharr[] = new MyThread1[1000];
	//th1.setDaemon(true);
	//th1.start();
	 System.out.println(Thread.currentThread());
	//th.run();
	th.setName("Thread one");
	//th.setPriority(Thread.MAX_PRIORITY);
	//th.setPriority(Thread.NORM_PRIORITY);
	//th.setPriority(Thread.MIN_PRIORITY);
	th.setPriority(2);
	th.start();
	int not = Thread.activeCount();
	System.out.println(" active thread count" + not);
	Thread tha[] = new Thread[not];
	Thread.enumerate(tha);
	for(int i = 0; i<not;i++){
		System.out.println(tha[i]);
	}
		
}
}

class MyThread1  extends Thread{
  public void run(){
	for(int i= 0;i <10; i++)
        System.out.println(Thread.currentThread());
  }
}
