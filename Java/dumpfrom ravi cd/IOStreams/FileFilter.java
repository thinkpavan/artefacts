import  java.io.*;

public  class  FileFilter
{
  public  static  void  main(String args[])throws IOException
  {
    File  f=new  File(".");
     String lstFiles[];
     if(args.length==0)
       lstFiles=f.list();
     else
        lstFiles=f.list(new  FilterFiles(args[0]));
     for(int ctr=0;ctr<lstFiles.length;ctr++)
     System.out.println(lstFiles[ctr]);
  }
}

class  FilterFiles  implements  FilenameFilter
{
 String ext;

 FilterFiles(String ext)
 {
 this.ext=ext;
 }
 public  boolean accept(File fi,String fname)
 {                       
  return fname.endsWith(ext);
 }
}
