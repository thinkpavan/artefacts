import  java.util.zip.*;
import java.io.*;

public  class CompressFile
{
  public static void  main(String args[])throws IOException
  {
   BufferedInputStream  br=new  BufferedInputStream(new FileInputStream(args[0]));
   BufferedOutputStream  out=new BufferedOutputStream(new  GZIPOutputStream(new FileOutputStream(args[1])));
   int c;
   while((c=br.read())!=-1)
   out.write((char)c);
   out.close();
   br.close();
   BufferedInputStream  in=new  BufferedInputStream(new GZIPInputStream(new  FileInputStream(args[1])));
   while((c=in.read())!=-1)
   System.out.print((char)c);
  }
}
