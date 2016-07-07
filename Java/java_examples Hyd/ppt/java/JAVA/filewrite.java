import java.io.*;

public class filewrite 
{
    public static void main(String args[]) 
	{
        FileWriter fw;
        int i;
        try {
          fw = new FileWriter( args[0] );
          while ( (i = System.in.read()) != -1 )
              fw.write( (char) i );              
          fw.close();
        } 
		catch (IOException ioe) 
		{ System.out.println( "IO error:" + ioe );  } 
    }
}
