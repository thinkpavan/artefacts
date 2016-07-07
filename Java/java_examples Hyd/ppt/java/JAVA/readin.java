import java.io.*;

public class readin 
{
    public static void main(String args[]) 
	{
      int i;
      try {
        while ( (i = System.in.read()) != -1 ) 
          System.out.println( "read char: " + (char) i +
                               " hex value: " + Integer.toString(i,16) );
      } 
      catch (IOException ioe) {  
        System.out.println( "IO error:" + ioe );
      } 
    }

} // end of readin class

