/* This program shows how to use wait and notify
Author : Team -J
Version : 1.0 */
class WaitNotify{
  static public void main(String[] args)throws Exception{
    Thread t1 = new DataProducer();
    Thread t2 = new DataConsumer((DataProducer)t1);
    t1.start();
    t2.start();
  }
}

class DataProducer  extends Thread{

StringBuffer sb;
boolean dataprodover = false;

 public DataProducer(){
		//System.out.println("In data Prod");
		sb = new StringBuffer("");
 }
 public void run(){
	for(int i= 0;i <10; i++){
	try{
		sb.append("."+i);
		sleep(100);
		System.out.println("appending");
	}catch(Exception e){System.out.println(e);}
	}
	dataprodover = true;
  }
  public StringBuffer getData(){
	return sb;
  }
  public boolean isDPOver(){
	return dataprodover;
  }
}

class DataConsumer extends Thread{
DataProducer dp;
public DataConsumer(DataProducer dp){
	this.dp = dp;
}
 public void run(){
	try{// if data production is not over sleep for some time and check again
//System.out.println(dp.isAlive());
	 //while(! dp.isAlive())
	//	wait(1); // let us wait till data producer starts
//System.out.println(dp.isAlive());
		while( ! dp.isDPOver())
			sleep(10);
	}catch(Exception e){}
	System.out.println(dp.getData());
  }
}