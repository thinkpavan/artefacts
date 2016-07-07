
// Counter.java
// Andrew Davison, Jan. 2001, dandrew@ratree.psu.ac.th

/* Illustrates a *good* use of synchronized methods.
   
   If raise() in Counter class does not have the 
   keyword 'synchronised', then the output is wrong
   (e.g. 705, 495, often 1500). 
   
   With 'synchronised' the output is correct (15).
 */

public class Counter 
{
   int counter = 0;

   synchronized public void raise()
   {
     if (counter < 10) {
	   // wait briefly to simulate some calculations
       try{ Thread.sleep(100); } catch (Exception e){}
	   counter +=15;
	 }
   }

   public int getCounter()
   {  return counter;  }


   public static void main( String[] args ) 
   {
       Counter c = new Counter();
	   CounterAdjuster ca[] = new CounterAdjuster[100];

       for (int i=0; i<100; i++) {  // create 100 threads
           ca[i] = new CounterAdjuster(c);              
           ca[i].start();
       }

       try{ // wait for all the threads to stop
         for (int i=0;i<100;i++)
           ca[i].join(); 
       } 
       catch(Exception e){}
        
       System.out.println("Counter reads: " + c.getCounter() );
   } // end of main()
   
} // end Counter class


class CounterAdjuster extends Thread 
{
  Counter c;

  public CounterAdjuster(Counter cnt)
  {  c = cnt;  }
	
  public void run() 
  {  c.raise();  }

} // end CounterAdjuster class



