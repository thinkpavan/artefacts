/* shows how to synchronize and problem
presented in WhySync.java program
problem
Author : Team -J
Version : 1.0 */
class Sync{
  static public void main(String[] args)throws Exception{
    SReservation reservation = new SReservation(10); // ten tickets are available for us
    Thread banglore = new SThread(reservation);
    Thread banglore1 = new SThread(reservation);
    Thread hyderabad = new SThread(reservation);
    Thread hyderabad1 = new SThread(reservation);
    banglore.setName("blr");
    hyderabad.setName("hyd");

	// let us reserve five tickets from banglore
	banglore.start();
	banglore1.start();
	// let us reserve five tickets from hyderabad
	hyderabad.start();
	// let us reserve another five tickets from hyderabad
	// try using hyderabad.start();
	hyderabad1.start();
  }
}

class SThread  extends Thread{
 SReservation r;
 public SThread(SReservation r){
	this.r = r;
 }
 public void run(){
	System.out.println(Thread.currentThread()+" Tickets are booked " + r.reserveTicket(5));
 }
}

class SReservation{
	int not;
	public SReservation (int not){
		this.not = not;
	}
// we will lock this so that no one can perform this operation till
// this is completely finished by a thread
synchronized public boolean reserveTicket(int n){
	// get the not available from database
		if (not < n)
			return (false);
		try{
		Thread.currentThread().sleep(20); // we are doing some activity here to simulate most common
		}catch (Exception e){}
		//problem with threads
		not = not - n;
		System.out.println("no of tickets currently available = "  + not);
		return true;
	}
// we are not going to call this at all !!!
	public void cancelTicket(int n){
		not = not + n;
	}
}
