/* show some details about the local var's declared in run method
Author : Team -J
Version : 1.0 */
class WhyLocal{
  static public void main(String[] args)throws Exception{
	Thread t1 = new LocalDataThread(10);
	Thread t2 = new LocalDataThread(20);
	Thread t3 = new LocalDataThread(30);
	t1.start();
	t2.start();
	t3.start();
  }
}
// in java we may not use a special class like ThreadLocal to store 
// Thread specific data, but in C and other languages we have to
// essentially use a technique to store thread specific data.
class LocalDataThread extends Thread{
	int data;
	private static ThreadLocal tl1 = new ThreadLocal();
	private static ThreadLocal tl2 = new ThreadLocal(); 
	private static int a;
	private static String s;
	

      public LocalDataThread( int i){
		data = i;
		a = 10;
		s = new String(" string");
	}
	public void run(){
		System.out.println("  data  = " + data);
		System.out.println("  a  = " + a);
		System.out.println("  tl1  = " + tl1.get());
		System.out.println("  tl2  = " + tl2.get());
		tl1.set(new Integer(data+10));
		tl2.set(new Integer(data+20));
		System.out.println("  tl1  = " + tl1.get());
		System.out.println("  tl2  = " + tl2.get());
		System.out.println(s);

	}
}