import  java.io.*;

public  class  WriteData
{
  public  static void  main(String  args[])throws IOException
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
    StringReader  sr=new  StringReader(src);
    PrintStream  ps=new  PrintStream(new  FileOutputStream("test.out"));
    int c;
    LineNumberReader  lr=new  LineNumberReader(sr);
//    lr.setLineNumber(1);
    while((s=lr.readLine())!=null)
    {
    int n=lr.getLineNumber();
    System.out.print(n+" ");
    System.out.println(s);
    ps.print(n+" ");
    ps.println(s);
    }
    sr.close();
    ps.close();
  }
}
