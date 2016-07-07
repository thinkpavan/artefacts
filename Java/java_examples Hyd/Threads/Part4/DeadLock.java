/* shows details about deadlock
Author : Team -J
Version : 1.0 */
class DeadLock{
  static public void main(String[] args)throws Exception{
	Object train = new Object(); // this object should be assumed as train
	Object compartment = new Object();// this has to be assumed as a compartment
	Thread t1 = new CancelTicket (train,compartment);
	Thread t2 = new BookTicket (train,compartment);	
	// we are now spinning off two threads one for booking a ticket and
	// other for cancelling ticket
	t1.start();
	t2.start();
  }
}

class CancelTicket extends Thread{

	Object train,comp;
	public CancelTicket(Object train, Object comp){
		this.train = train;
		this.comp = comp;
	}
	public void run(){
		//grab lock on comp
		synchronized(comp){
			System.out.println(" cancel ticket grabbed lock on comp");
			try{
			sleep(100); 
			}catch(Exception e ){}

// assume that we are now getting data from server
// if cancel ticket is performed very quickely we may not face deadlock,
//try removing sleep and see. This is why we say thread programs are difficult to
// debug .In many cases due to problems with threads whole system hangs.
			System.out.println("  cancel ticket  now trying to grab lock on train");
			synchronized(train){
				System.out.println("  cancel ticket  grabbed lock on train");
			}	
		}
	}
}

class BookTicket extends Thread{

	Object train,comp;
	public BookTicket(Object train, Object comp){
		this.train = train;
		this.comp = comp;
	}
	public void run(){
		//grab lock on train
		synchronized(train){
			System.out.println("  book ticket  grabbed lock on train");
			try{
			sleep(200);
			}catch(Exception e ){}
			System.out.println("  book ticket   now trying to grab lock on comp");
			synchronized(comp){
				System.out.println("  book ticket   grabbed lock on comp");
			}	
		}
	}
}