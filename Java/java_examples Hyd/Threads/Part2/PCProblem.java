/* Program to demonstrate Producer/consumer Problem
Author : Team -J
Version : 1.0 */
class PCProblem{
  static public void main(String[] args)throws Exception{
    Thread producer = new Producer();
    Thread consumer = new Consumer((Producer)producer);
	//producer.setPriority(Thread.MIN_PRIORITY);
	producer.start();
	consumer.start();
//	consumer.start();
  }
}

class Producer  extends Thread{
	int data  = 0;
  public void run(){
	for(int i= 0;i <10; i++){
		data ++;
		System.out.println("Producer ");
	}
  }
  public int getData(){
	return data;
  }
}

class Consumer extends Thread{
	Producer pr;
	public Consumer (Producer pr){
		this.pr = pr;
	}
	public void run(){
		for(int i = 0;i <10;i++){
			try{
			//	sleep(3);
			}catch(Exception e){}

			System.out.println("Consumed " + pr.getData());
		}
	}
}