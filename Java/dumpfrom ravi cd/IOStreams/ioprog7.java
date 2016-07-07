	/*A Program for ByteArrayOutputStream .*/
import java.io.*;
class ioprog7
{
    public static void main(String args[])throws IOException
    {
          String temp="It is a String to Demonstrate ByteInput/Output Stream";
          byte buf[]=temp.getBytes();
          ByteArrayOutputStream out=new ByteArrayOutputStream();
          out.write(buf);
          buf=out.toByteArray();
          for(int i=0;i<buf.length;i++)
              System.out.print((char)buf[i]);
          out.close();         
        }
}

         
          
              