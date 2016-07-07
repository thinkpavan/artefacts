/* Program to demonstrate Producer/consumer Problem
here in this problem the producer reads data from file.
In most of the thread programs we will come across such a problem
Author : Team -J
Version : 1.0 */

import java.io.*;

class PCProblem1{
  static public void main(String[] args)throws Exception{
    Thread producer = new FProducer();
    Thread consumer = new FConsumer((FProducer)producer);
	//producer.setPriority(Thread.MIN_PRIORITY);
	consumer.start();
	producer.start();
	consumer.start();
//	consumer.start();
  }
}

class FProducer  extends Thread{
	int data  = 0;
	File f;
	FileInputStream is ;
  public FProducer(){
	f = new File("contents.txt");
	try{
	is = new  FileInputStream(f);	
	}catch(Exception e){}
  }
  public void run(){
	for(int i= 0;i <100; i++){
		try{
		data   = is.read();
		System.out.println(data);
		}catch(Exception e){}
	}
  }
  public int getData(){
	return data;
  }
}

class FConsumer extends Thread{
	FProducer pr;
	public FConsumer (FProducer pr){
		this.pr = pr;
	}
	public void run(){
		for(int i = 0;i <100;i++){
			try{
			//	sleep(3);
			}catch(Exception e){}

			System.out.println("Consumed " + pr.getData());
		}
	}
}