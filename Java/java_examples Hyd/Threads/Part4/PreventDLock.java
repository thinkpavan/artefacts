/* shows details about deadlock
Author : Team -J
Version : 1.0 */
class PreventDLock {
  static public void main(String[] args)throws Exception{
	Object train = new Object(); // this object should be assumed as train
	Object compartment = new Object();// this has to be assumed as a compartment
	Thread t1 = new CancelTicket1 (train,compartment);
	Thread t2 = new BookTicket1 (train,compartment);	
	// we are now spinning off two threads one for booking a ticket and
	// other for cancelling ticket
	t1.start();
	t2.start();
  }
}

class CancelTicket1 extends Thread{

	Object train,comp;
	public CancelTicket1(Object train, Object comp){
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
	System.out.println("  cancel ticket  now trying to grab lock on train");
			synchronized(train){
				System.out.println("  cancel ticket  grabbed lock on train");
			}	
		}
	}
}

class BookTicket1 extends Thread{

	Object train,comp;
	public BookTicket1(Object train, Object comp){
		this.train = train;
		this.comp = comp;
	}
	public void run(){
		//grab lock on train
		synchronized(comp){
			System.out.println("  book ticket  grabbed lock on comp");
			try{
			sleep(200);
			}catch(Exception e ){}
			System.out.println("  book ticket   now trying to grab lock on train");
			synchronized(train){
				System.out.println("  book ticket   grabbed lock on train");
			}	
		}
	}
}

//If more than one lock has to be obtained in more than one thread
//It is better to obtain locks in the same sequence to avoid deadlocks. Deadlocks
// are very hard to detect . Java Run time system cannot detect deadlocks.

//Oracle database server ca detect deadlock situation.

// try out the following sequence of commands on oracle
/**

open two session using sqlplus(let us call them as session 1 and 2

ses1 > lock table emp in exclusive mode (table will be locked)

ses2 >lock table depy exclusive mode (table will be locked)

ses2> lock table emp in exclusive mode (waits for the lock)

ses1>lock table depy exclusive mode (waits for the lock)

wait for some time oracle server detects deadlock situation and 
notifies u about deadlocks
*/