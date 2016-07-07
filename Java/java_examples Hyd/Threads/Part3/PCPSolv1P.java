/* this program shows one of the major problem in the solution 
proposed in PCPSolv1 program. In that solution we have not 
taken care of synchronizing the shared var methods which may
lead to potential problems.
Author : Team -J
Version : 1.0 */
class PCPSolv1P  {
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
// we could do this by continuously sitting in loop which eats
// cpu time. to reduce cpu usage we are using sleep. But this is
// also considered as bad technique as in some cases we may 
//unnecessarily be sleep.
           while ( v.consumed == true)
			sleep(1);
		v.consumed = true;
			sleep(20); // simulate some delay
		System.out.println("Consumed " + v.getData());
	}catch(Exception e){}

	}
 }
}
// this class object is used as a shared data object
class sharedvar{
	public boolean consumed; // let us have a lock here,to reduce code we declared this as public var
	int data;
// the below two steps are atomic but we are not taking care of this fact.
	public void setData(int data){
		consumed = false;// since we are setting data this should be set
// to false.
		// introduce some delay to show the problem
		try{
		Thread.currentThread().sleep(200);
		}catch(Exception e){}
		this.data = data;
	}
	public int getData(){
		return (data);
	}
}

// can we use this technique if we have multiple consumers ????