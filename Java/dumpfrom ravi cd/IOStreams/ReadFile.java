import  java.io.*;

public  class  ReadFile
{
  public  static  void  main(String  args[])throws IOException
  {
    FileInputStream  fis=new  FileInputStream(args[0]);
    int c;
    while((c=fis.read())!=-1)
    System.out.print((char)c);
    System.out.println("Press anykey to continue...");
    System.in.read();
    BufferedReader br=new BufferedReader(new FileReader(args[0]));
    String s;
    while((s=br.readLine())!=null)
    System.out.println(s);

  }
}
