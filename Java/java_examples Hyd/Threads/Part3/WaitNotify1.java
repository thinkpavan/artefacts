/* This program shows how to use wait and notify
Author : Team -J
Version : 1.0 */
class WaitNotify1{
  static public void main(String[] args)throws Exception{
    StringBuffer sb = new StringBuffer();
    Object o = new Object();
    Thread t1 = new DataProducer1(sb);
    Thread t2 = new DataConsumer1(sb);
    t2.start();
    t1.start();

  }
}

class DataProducer1  extends Thread{

StringBuffer sb;
boolean dataprodover = false;
//Object o;
 public DataProducer1(StringBuffer o){
		//System.out.println("In data Prod");
		this.sb = o;
 }
 public void run(){
	synchronized(sb){
		for(int i= 0;i <10; i++){
			try{
				sb.append("."+i);
				sleep(100);
				System.out.println("appending");
		}catch(Exception e){System.out.println(e);}
		}
		sb.notify();
	}
	//dataprodover = true;
  }
  public StringBuffer getData(){
	return sb;
  }
  public boolean isDPOver(){
	return dataprodover;
  }
}

class DataConsumer1 extends Thread{
DataProducer1 dp;
//Object o;
StringBuffer sb;
public DataConsumer1(StringBuffer o){
	this.sb = o;
}
 public void run(){
	try{
	//	while( ! dp.isDPOver())
	//		sleep(10);
// we are not wasting a single milli also here
		synchronized(sb){
	System.out.println(" I am waiting for notification");
			sb.wait();
			System.out.println(sb);
		}
	}catch(Exception e){}

  }
}
