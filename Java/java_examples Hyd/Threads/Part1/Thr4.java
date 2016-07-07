/* Program to show how to check whether a threAD IS ALIVE OR NOT
Author : Team -J
Version : 1.0 */
class Thr4{
  static public void main(String[] args)throws Exception{
    Thread th1 = new MyThr4("thread one");
    Thread th2 = new MyThr4("thread two");
    Thread th3 = new MyThr4("thread three");

//	th2.setPriority(Thread.MAX_PRIORITY);
//	th1.setPriority(Thread.MIN_PRIORITY);
//	th3.setPriority(Thread.NORM_PRIORITY);

//	th1.start();
	th2.start();
//	th3.start();
	System.out.println(th2 + "is alive  "+ th2.isAlive());
	/*// just sleep for some time till three threads finishes their tasks
	Thread.currentThread().sleep(1000); // very bad technique
		System.out.println(th2 + "is alive  "+ th2.isAlive());*/
	th2.join(); // we will be again into action after th2 finishes it's action
//th2.join(100); // I can wait only for 100 ms
	System.out.println(th2 + "is alive  "+ th2.isAlive());
  }
}

class MyThr4  extends Thread{
 // we are using a constructor so that we can force to set the name
 // for thread
  public MyThr4(String name){
		setName(name);
  }
  public void run(){
	for(int i= 0;i <10; i++){
        System.out.println(Thread.currentThread());
	  /*try{
		sleep(22);
		}catch(Exception e){}*/
	}
  }
}
