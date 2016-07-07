import  java.io.*;

public class  SeqApp
{
   public  static  void  main(String  args[])throws IOException
   {
     FileInputStream  f1=new FileInputStream(args[0]);
     FileInputStream  f2=new FileInputStream(args[1]);
     SequenceInputStream  fis=new SequenceInputStream(f1,f2);
     int c;
     int cnt=0;
     while((c=fis.read())!=-1)
     {
     cnt++;
     System.out.print((char)c);
     }
     System.out.println("Total Bytes "+cnt);

   }
}
