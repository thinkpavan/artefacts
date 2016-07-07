//A Program for Random Access Files
import java.io.*;
class ioprog9
{
    public static void main(String args[])throws IOException
    {
           RandomAccessFile ran=new RandomAccessFile(args[0],"rw");
           int size=-1;
           ran.seek(Integer.parseInt(args[1]));
           while(++size<args[2].length())
               ran.write((int)args[2].charAt(size));
      }
}           
