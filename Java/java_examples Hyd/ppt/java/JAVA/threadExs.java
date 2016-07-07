298. Extension of THREAD running
// threadExs.java

// The two ways to obtain a thread of code
//   1.  extend class java.lang.Thread
//   2.  implement the Runnable interface,

import java.io.*;

class threadExs {
   public static void main(String[] a) 
   {
      SimpThread t1 = new SimpThread();
      t1.start();

      Thread t2 = new Thread (new SimpRunnable());
      t2.start();
   }
}

class SimpThread extends Thread {
//   1.  extend class java.lang.Thread
   public void run() 
   {
      for(int i = 0; i < 300; i++)
	    System.out.println(i + ". Extension of THREAD running");
      // setPriority( getPriority() +1 );
   }
}

class SimpRunnable implements Runnable {
//   2.  implement the Runnable interface,
   public void run()
   {
     for (int i = 0; i < 300; i++)
       System.out.println(i + ". Implem. of RUNNABLE running");
   }
}
