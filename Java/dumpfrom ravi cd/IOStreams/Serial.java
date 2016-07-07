import  java.io.*;

public class  Serial 
{
  public  static  void  main(String  args[])throws IOException
  {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     String s,src=new String();
     System.out.println("Enter data and type \"BYE\" to exit");
     while(true)
     {
     s=br.readLine();
     if(s.equals("BYE"))break;
     src+=s+"\n";
     }
     ObjectOutputStream out=new  ObjectOutputStream(new FileOutputStream("c:/batch11/test.out"));
     out.flush();
    out.write(src.getBytes(),0,src.length());
     out.flush();
    System.out.println("Written on to remote location on file");
    out.close();
    br.close();
     ObjectInputStream in=new  ObjectInputStream(new FileInputStream("c:/batch11/test.out"));
     PrintStream  ps=new PrintStream(new FileOutputStream("abc.txt"));
     int c;
     while((c=in.read())!=-1)
     {
     System.out.print((char)c);
     ps.print((char)c);
     }in.close();
  }
}
