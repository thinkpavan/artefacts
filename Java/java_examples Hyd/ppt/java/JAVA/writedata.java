import java.io.*;  
 
public class writedata 
{
    public static void main(String args[]) 
	{
        FileOutputStream fos;
        DataOutputStream ds;
        try {
          fos = new FileOutputStream(args[0]);
          ds = new DataOutputStream( fos );
 
          int a[] = {0,1,2,3,4,5,6,7,8,9};
          for (int i=0; i<a.length; i++) { 
              ds.writeInt(a[i]); 
          }
		  ds.close();
        } 
		catch (IOException ioe) 
		{  System.out.println( "IO error: " + ioe );  }
    }
}
