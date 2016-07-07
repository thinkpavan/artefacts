// demonstrates the use of threads to test a number for primality
 
public class testPrime {
 
   public static void main(String s[]) 
   {
      if (s.length != 1) {
        System.out.println("Usage: java testPrime number");
        System.exit(1);
      }
      long possPrime = Long.parseLong(s[0]);
      int numHundreds = (int)(possPrime/100) +1;
 
      for(int i=0; i<numHundreds; i++)
        new testRange(possPrime, i*100, i*100+99).start();
   }
} // end of testPrime

class testRange extends Thread 
{  long possPrime;
   long from, to;
 
   testRange(long number, int start, int end) 
   {
     possPrime = number;
     if (start == 0) 
       from = 2; 
     else 
       from = start;
     to = end;
     System.out.println("starting " + getName() + ": " +
					from + "-" + to );
   }
 
   public void run() 
   {
     for (long i=from; i<=to && i<possPrime; i++) {
       if (possPrime%i == 0) {  // i divides possPrime exactly
         System.out.println("*** factor "+i+" found by thread "+getName());
	     return;
       }
       // yield();   // for solaris
     }   
   }
} // end of testRange
 

