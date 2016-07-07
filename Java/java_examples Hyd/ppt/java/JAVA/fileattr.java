import java.io.*;

public class fileattr 
{
    public static void main(String args[]) 
	{
        File f = new File("animals.txt");
        System.out.println("Length of animals.txt: " + f.length() );

		File d = new File(".");  // current dir
		String[] filesList = d.list();
		for (int i=0; i < filesList.length; i++)
		  System.out.println( filesList[i] );
    }
}

