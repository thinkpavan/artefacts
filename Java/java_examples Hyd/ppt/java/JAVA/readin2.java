
import java.io.*;
import java.util.*;

public class readin2
{
    public static void main(String args[]) 
	{
        InputStreamReader is = new InputStreamReader( System.in );
        BufferedReader br = new BufferedReader( is );
       
        try {
          System.out.print("Please enter an integer: ");
		  System.out.flush();

		  String s = br.readLine();
          StringTokenizer st = new StringTokenizer(s);

          int i =  Integer.parseInt(st.nextToken());

          System.out.println( "You entered: " + i );
        } 
		catch (IOException ioe) {
          System.out.println( "IO error:" + ioe );
        }
    }
} // end of readin2 class
