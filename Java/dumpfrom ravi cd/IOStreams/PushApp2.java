import java.io.*;

public class PushApp2
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
     char ch;
       boolean p=true;
       while((c=push.read())!=-1)
       {
        ch=(char)c;
        //System.out.print("char is "+ch);
        switch(ch)
        {
         case  't': push.unread((char)'T');
                    c--;
                    break;
        }
       System.out.print((char)c);
       }

    }
}
