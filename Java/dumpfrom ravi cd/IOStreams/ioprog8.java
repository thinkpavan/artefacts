//A Proagram for Sequence Input Stream
import java.io.*;
class ioprog8
{
    public static void main(String args[]) throws IOException
    {
          int c;
          InputStream in1=new FileInputStream("NEWFILE.TXT");
          InputStream in2=new FileInputStream("OLDFILE.TXT");
          SequenceInputStream seq=new SequenceInputStream(in1,in2);
          System.out.println("\nThe Content of Two  Files is  \n");
          while((c=seq.read())!=-1)
                System.out.print((char)c);
     }
}
