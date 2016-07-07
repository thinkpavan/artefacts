/*  this program shows how to solve problem with previous program
Author : Team -J
Version : 1.0 */
class PCPSPSolv    {
  static public void main(String[] args)throws Exception{
	sharedvar v = new sharedvar();
    Thread producer = new SProducer1(v);
    Thread consumer = new SConsumer1(v);
	//producer.setPriority(Thread.MIN_PRIORITY);
	producer.start();
	consumer.start();
//	consumer.start();
  }
}

class SProducer1  extends Thread{
sharedvar v;
 public SProducer1(sharedvar s){
	v = s;
 }
 public void run(){
	for(int i= 0;i <10; i++){
		// check to see if the consumer has consumed prev data item or not
	try{
           while ( v.consumed == false)
			sleep(10);
	}catch(Exception e){}
			System.out.println("Producer ");
			v.setData((v.data)+1);
	}
  }
  public int getData(){
	return v.getData();
  }
}

class SConsumer1 extends Thread{
sharedvar v;
 public SConsumer1(sharedvar s){
	v = s;
 }
 public void run(){
	for(int i = 0;i <10;i++){
		try{
		//	sleep(3);
		}catch(Exception e){}
	try{
// we could do this by continuously sitting in loop which eats
// cpu time. to reduce cpu usage we are using sleep. But this is
// also considered as bad technique as in some cases we may 
//unnecessarily be sleeping.
           while ( v.consumed == true)
			sleep(1);
		System.out.println("Consumed " + v.getData());
	}catch(Exception e){}

	}
 }
}
// this class object is used as a shared data object
class sharedvar{
	public boolean consumed=true; // let us have a lock here,to reduce code
		//we declared this as public var
	public int data;// we know very well that we should not use data
		// as public but we still do it to show to s/w develop write bad programs
	synchronized public void setData(int data){
		consumed = false;
		try{
		Thread.currentThread().sleep(200);
		}catch(Exception e){}
		this.data = data;
	}
	synchronized public int getData(){
		consumed = true;
		return (data);
	}
}

// can we use this technique if we have multiple consumers ????