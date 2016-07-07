/* shows why we need use synchoronized keyword to perform
an operation
problem
Author : Team -J
Version : 1.0 */
class WhySync{
  static public void main(String[] args)throws Exception{
    Reservation reservation = new Reservation(10); // ten tickets are available for us
    Thread banglore = new WSThread(reservation);
    Thread banglore1 = new WSThread(reservation);
    Thread hyderabad = new WSThread(reservation);
    Thread hyderabad1 = new WSThread(reservation);
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

class WSThread  extends Thread{
 Reservation r;
 public WSThread(Reservation r){
	this.r = r;
 }
 public void run(){
	System.out.println(Thread.currentThread()+" Tickets are booked " + r.reserveTicket(5));
 }
}

class Reservation{
	int not;
	public Reservation (int not){
		this.not = not;
	}
	public boolean reserveTicket(int n){
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
// we are not going to call this
	public void cancelTicket(int n){
		not = not + n;
	}
}
