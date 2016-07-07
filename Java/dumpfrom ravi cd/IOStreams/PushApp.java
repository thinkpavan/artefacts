import  java.io.*;

public  class  PushApp
{
  public  static  void  main(String  arg[])throws IOException
  {
     String s="-------WELCOME-----To---------TRENDZ-------";
     ByteArrayOutputStream  out=new  ByteArrayOutputStream();
     for(int ctr=0;ctr<s.length();ctr++)
     out.write(s.charAt(ctr));
     ByteArrayInputStream  inStream=new  ByteArrayInputStream(out.toByteArray());
     PushbackInputStream  in=new  PushbackInputStream(inStream);
     int c;
     char ch;
     while((c=in.read())!=-1)
     {
     ch=(char)c;
      switch(ch)
      {
       case   '-':    in.unread((char)'*');
                      break;
      }
     }
     while((c=in.read())!=-1)
     System.out.println((char)c);


  }
}
