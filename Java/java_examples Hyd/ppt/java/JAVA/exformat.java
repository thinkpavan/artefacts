import java.io.*;
import java.text.*;

// write binary data as formatted characters 

public class exformat 
{
    public static void main(String args[]) 
	{
        float fls[] = { -1.1f, 2.2f, -3.33f, 4.444f, -5.5555f, 6.66666f};
        DecimalFormat df = new DecimalFormat( "#0.00;#0.00CR" );

        for (int i=0; i < fls.length; i++) 
          System.out.println( df.format(fls[i]) );
        
	}
}
