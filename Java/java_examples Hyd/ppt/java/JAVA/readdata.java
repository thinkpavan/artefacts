import java.io.*;

public class readdata 
{
    public static void main(String args[]) 
	{
        FileInputStream fis;
        DataInputStream dis;
        try {
          fis = new FileInputStream( args[0] );
          dis = new DataInputStream( fis );
          System.out.println( "input file: " + args[0] );

          int i;
          while ( true ) {   // eof is caught as an exception
		    i = dis.readInt();
            System.out.println( "read: " + i );
	      }
        } 
		catch (EOFException eof)  
        {  System.out.println( "EOF reached " ); }
        catch (IOException ioe) 
        { System.out.println( "IO error: " + ioe ); }
    }
 
} // end of readdata class
