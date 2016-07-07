/* Program to create multiple threads from a single class
Author : Team -J
Version : 1.0 */
class Thr3{
  static public void main(String[] args)throws Exception{
    Thread th1 = new MyThr3("thread one");
    Thread th2 = new MyThr3("thread two");
    Thread th3 = new MyThr3("thread three");

	th2.setPriority(Thread.MAX_PRIORITY);
	th1.setPriority(Thread.MIN_PRIORITY);
	th3.setPriority(Thread.NORM_PRIORITY);

	th1.start();
	th2.start();
	th3.start();
  }
}

class MyThr3  extends Thread{
 // we are using a constructor so that we can force to set the name
 // for thread
  public MyThr3(String name){
		setName(name);
  }
  public void run(){
	for(int i= 0;i <10; i++){
        System.out.println(Thread.currentThread());
	  try{
		sleep(22);
		}catch(Exception e){}
	}
  }
}
