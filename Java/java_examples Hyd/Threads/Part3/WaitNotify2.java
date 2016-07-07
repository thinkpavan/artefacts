/* shows some problems with wait and notify.
Author : Team -J
Version : 1.0 */
class WaitNotify2{
  static public void main(String[] args)throws Exception{
    StringBuffer sb = new StringBuffer();
    Thread t1 = new DataProducer2(sb);
    Thread t2 = new DataConsumer2(sb);
	t2.setName("consumer 1");
    Thread t3 = new DataConsumer2(sb);
	t3.setName("consumer 2");
    Thread t4 = new DataConsumer2(sb);
	t4.setName("consumer 3");
    Thread t5 = new DataConsumer2(sb);
	t5.setName("consumer 4");
    Thread t6 = new DataConsumer2(sb);
	t6.setName("consumer 5");

    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();

    t1.start();

  }
}

class DataProducer2  extends Thread{

StringBuffer sb;
boolean dataprodover = false;
 public DataProducer2(StringBuffer o){
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
//		sb.notify();
		sb.notifyAll();

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

class DataConsumer2 extends Thread{
DataProducer2 dp;
//Object o;
StringBuffer sb;
public DataConsumer2(StringBuffer o){
	this.sb = o;
}
 public void run(){
	try{
	//	while( ! dp.isDPOver())
	//		sleep(10);
// we are not wasting a single milli also here
		synchronized(sb){
	System.out.println(" I am waiting for notification" + Thread.currentThread());
			sb.wait();
			System.out.println(sb);
	System.out.println(" I got notification" + Thread.currentThread());

		}
	}catch(Exception e){}

  }
}
