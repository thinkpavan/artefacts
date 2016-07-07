/* show why we have to use thread groups
Author : Team -J
Version : 1.0 */
class WhyTGroups{
  static public void main(String[] args)throws Exception{
	ThreadGroup tg = new ThreadGroup("Reservation Group");
	Thread res = new ResGroup(tg);// add this thread to new group
	// so that we can controll all the threads in this group using
	// a single method
      res.start();
  }
}

class ResGroup extends Thread{

public ResGroup(ThreadGroup group){
		super(group,"reservsation group");
	}
Reservation r[] = new Reservation[30];
	// this class creates a thread when ever a request for 
	// reserving a ticket is there, there may be more no of threads
	// at a single point of time.
	public void run(){
	for(int i = 0;i < 30;i++){
		try {
			System.out.println("Reservation group started");
			sleep(100);
			r[i] = new Reservation();
// u can use this method to suspend the execution of all the
// threads, we can have control over all the threads of the group like this
	// dangerous getThreadGroup().suspend(); // stop the execution of threads for a while
			r[i].start();
			getThreadGroup().resume(); // resume thread execution
		}catch(Exception e){}
	}
	}
}

class Reservation extends Thread{
	public void run(){
		try {
			System.out.println(" I am reservation thread and my priority is set to "+ getPriority());
			sleep(300);
		}catch(Exception e){}
	}
}