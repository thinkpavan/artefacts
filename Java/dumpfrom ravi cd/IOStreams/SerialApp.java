import  java.io.Serializable;
import  java.io.*;
public class  SerialApp
{
  public  static  void  main(String  args[])throws IOException
  {
   ObjectOutputStream  out=new  ObjectOutputStream(new  FileOutputStream("test.out"));
   BufferedReader br=new  BufferedReader(new InputStreamReader(System.in));
   System.out.println("Type \"Bye\" to exit");
   String s,src=new String();
   while(true)
   {
    s=br.readLine();
    if(s.equals("Bye"))break;
    src+=s+"\n";
   }
   out.write(src.getBytes(),0,src.length());
   ObjectInputStream  in=new  ObjectInputStream(new FileInputStream("test.out"));
   int c;
   while((c=in.read())!=-1)
   System.out.print((char)c);

  }
}
