import java.io.*;

public class PushApp1
{
  public static void  main(String args[])throws IOException
  {
     String s="this is a test data";

     ByteArrayOutputStream out=new ByteArrayOutputStream();
     for(int i=0;i<s.length();i++)
     out.write(s.charAt(i));
     ByteArrayInputStream in=new ByteArrayInputStream(out.toByteArray());
     int l=in.available();
     System.out.println(l);
     PushbackInputStream  push=new PushbackInputStream(in);
     int c;
     c=push.read();
       push.unread((char)'T');
       while((c=push.read())!=-1)
       System.out.print((char)c);
     }
}
