import  java.io.*;

public class ByteApp
{
  public  static  void  main(String  args[])throws IOException
  {
    BufferedReader  br=new  BufferedReader(new InputStreamReader(System.in));
    System.out.println("Type \"Bye\" to  exit");
    String s,src=new  String();
    while(true)
    {
     s=br.readLine();
     if(s.equals("Bye"))
     break;
     src+=s+"\n";
    }
   ByteArrayOutputStream  bos=new  ByteArrayOutputStream();
   for(int ctr=0;ctr<src.length();ctr++)
   bos.write(src.charAt(ctr));
   FileOutputStream  fos=new FileOutputStream("test");
   bos.writeTo(fos);
   
   ByteArrayInputStream  bis=new  ByteArrayInputStream(bos.toByteArray());
   int c;
   System.out.println("Bytes available "+bis.available());
   while((c=bis.read())!=-1)
   System.out.print((char)c);

  }
}
