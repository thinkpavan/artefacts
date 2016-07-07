
// ExecDemo1.java
// Andrew Davison, 3rd February 2005, ad@fivedots.coe.psu.ac.th


import java.io.*;
    

public class ExecDemo1
{
  public static void main(String args[]) 
  {
    try {
      // start the ls command running
      Runtime rt = Runtime.getRuntime();
      // Process proc = rt.exec("ls -alF");
      Process proc = rt.exec("start c:\\Windows\\command.com /c dir /L /W");

      // put a BufferedReader on the ls output
      InputStream is = proc.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
    
      // read the ls output
      String line;
      while ((line = br.readLine()) != null)
         System.out.println(line);
        
      // check for ls failure
      try {
        if (proc.waitFor() != 0)
          System.err.println("exit value = " + proc.exitValue());
      }
      catch (InterruptedException e) {
        System.err.println(e);
      }
    }
    catch (IOException e) {
      System.out.println(e);
    }
  } // end of main()

} // end of ExecDemo1 class
