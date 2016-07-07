import  java.io.*;

public  class  RAF
{
   public  static  void  main(String  args[])throws IOException
   {
    RandomAccessFile  raf=new  RandomAccessFile(args[0],"rw");
                                                //       r
    System.out.println("length "+raf.length());
    BufferedReader br=new  BufferedReader(new InputStreamReader(System.in));
    String s,src=new String();
    System.out.println("type \"Bye\" to exit");
    while(true)
    {
     s=br.readLine();
     if(s.equals("Bye"))
     break;
     src+=s+"\n";
    }
    String src1="\n"+src;
    raf.seek(raf.length());
    raf.write(src1.getBytes(),0,src1.length());
    raf.seek(0);
    int c;
    while((c=raf.read())!=-1)
    System.out.print((char)c);

   }
}
