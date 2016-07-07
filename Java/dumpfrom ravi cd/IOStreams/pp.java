//A Program for ByteArrayInputStream 
import java.io.*;
class ioprog6
{
    public static void main(String args[])throws IOExcpetion
    {
          String temp="It is a String to Demonstrate ByteInput/Output Stream";
          byte buf[]=temp.getBytes();
          ByteArrayInputStream in=new ByteArrayInputStream(buf);
          for(int i=0;i<2;i++)
          {
               int c;
               while((c=in.read())!=-1)
                   if(i)
                      System.out.println(Character.toUpperCase(c));
                   else
                      System.out.println(c);
                System.out.println(" ");
                in.reaset();
            }
        }
}

         
          
              