import java.io.*;

public class fileread 
{
    public static void main(String args[]) 
	{
        int i;
        int bytesRead=0;

        try {
           FileReader fr = new FileReader( "animals.txt" );
           while ( (i = fr.read()) != -1 )
             bytesRead++;
		   fr.close();
        } 
		catch (IOException ioe) {  
          System.out.println( "IO error:" + ioe );
        } 

        System.out.println("bytes read from file: " + bytesRead);
    }

}

