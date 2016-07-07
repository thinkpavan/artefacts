/* Program to show how to solve producer consumer
problem
Author : Team -J
Version : 1.0 */
class PCPSolv1{
  static public void main(String[] args)throws Exception{
	sharedvar v = new sharedvar();
    Thread producer = new SProducer(v);
    Thread consumer = new SConsumer(v);
	//producer.setPriority(Thread.MIN_PRIORITY);
	producer.start();
	consumer.start();
//	consumer.start();
  }
}

class SProducer  extends Thread{
sharedvar v;
 public SProducer(sharedvar s){
	v = s;
 }
 public void run(){
	for(int i= 0;i <10; i++){
		// check to see if the consumer has consumed prev data item or not
	try{
           while ( v.consumed == false)
			sleep(10);
	}catch(Exception e){}
		v.setData((v.getData())+1);
		System.out.println("Producer ");
		v.consumed = false;
	}
  }
  public int getData(){
	return v.getData();
  }
}

class SConsumer extends Thread{
sharedvar v;
 public SConsumer(sharedvar s){
	v = s;
 }
 public void run(){
	for(int i = 0;i <10;i++){
		try{
		//	sleep(3);
		}catch(Exception e){}
	try{
           while ( v.consumed == true)
			sleep(10);
	}catch(Exception e){}
		System.out.println("Consumed " + v.getData());
		v.consumed = true;
	}
 }
}
// this class object is used as a shared data object
class sharedvar{
	public boolean consumed; // let us have a lock here,to reduce code we declared this as public var
	int data;
	public void setData(int data){
		this.consumed = true; //set this to true so that the producer
		// can start producing the items
		this.data = data;
	}
	public int getData(){
		return (data);
	}
}

// can we use this technique if we have multiple consumers ????