
// threadExs2.java

// The two ways to obtain a thread of code
//   1.  extend class java.lang.Thread
//   2.  implement the Runnable interface,
// And how to sleep

import java.io.*;

class threadExs2 {
   public static void main(String[] a) 
   {
      SleepThread t1 = new SleepThread();
      t1.start();

      Thread t2 = new Thread (new SleepRunnable());
      t2.start();
   }
}

class SleepThread extends Thread {
   public void run() 
   {
      for(int i = 0; i < 300; i++) {
	    System.out.println(i + ". Extension of THREAD running");
		if (i == 50) {
          System.out.println("**** SleepThread going to sleep");
          try{ sleep(5000); }
          catch (InterruptedException ie) { return; }
          System.out.println("**** SleepThread waking up");
        }
      }
   }
}

class SleepRunnable implements Runnable {
   public void run()
   {
     for (int i = 0; i < 300; i++) {
       System.out.println(i + ". Implem. of RUNNABLE running");
		if (i == 250) {
          System.out.println("**** SleepRunnable going to sleep");
          Thread rt = Thread.currentThread();
          try{ rt.sleep(7000); }
          catch (InterruptedException ie) { return; }
          System.out.println("**** SleepRunnable waking up");
       }
      }
   }
}
