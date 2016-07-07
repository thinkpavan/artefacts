// exCalc.java
// Andrew Davison, August 2002, dandrew@ratree.psu.ac.th

/*
  Execute the calculator Windows application.

  The Java process waits for calc to finish by calling waitFor()
  but this is not necessary.
*/

import java.io.*;

public class exCalc 
{
  public static void main(String args[]) 
  {
   try {
     Runtime rt = Runtime.getRuntime();
     Process prc = rt.exec("c:\\windows\\calc.exe");

     int retval = prc.waitFor();    // wait for process to finish
     System.out.println("Process return value: " + retval);  
        // the retval should be 0 if ok

     prc.destroy();
   } 
   catch (IOException e) {
      System.out.println("IOException");
   }
   catch (InterruptedException e) {
      System.out.println("InterruptedException");
   }
  } // end of main()

} // end of exCalc class
