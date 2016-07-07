import  java.io.*;
import  java.util.Date;
public class  FileApp
{
  public  static  void  main(String  args[])throws Exception
  {
     File  f=new  File(args[0]);
     //c:\batch9\io\BuffApp.java
     if(f.exists())
     {
       if(f.isFile())
       {
         System.out.println("It is a file  "+f.getName());
         System.out.println("Parent "+f.getParent());
         System.out.println("length  "+f.length());
         System.out.println("Path  "+f.getPath());
         System.out.println("Absolute Path  "+f.getAbsolutePath());
         System.out.println("Last Modified  "+new Date(f.lastModified()));
         System.out.println("can Write  "+f.canWrite());
         System.out.println("can Read  "+f.canRead());
         System.out.println("is Hidden  "+f.isHidden());
         System.out.println("URL  "+f.toURL());

       }
       else
       {
         System.out.println("It is a directory  "+f.getName());
         System.out.println("Parent "+f.getParent());
         System.out.println("length  "+f.length());
         System.out.println("Path  "+f.getPath());
         System.out.println("Absolute Path  "+f.getAbsolutePath());
         System.out.println("Last Modified  "+new Date(f.lastModified()));
         System.out.println("can Write  "+f.canWrite());
         System.out.println("can Read  "+f.canRead());
         System.out.println("is Hidden  "+f.isHidden());
         String lst[];
         lst=f.list();
         for(int ctr=0;ctr<lst.length;ctr++)
         System.out.println(lst[ctr]);

       }


     }
     else
     System.out.println("no such file or directory "+args[0]);

  }
}
