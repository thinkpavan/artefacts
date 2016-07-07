//A Program for Listing the Files and Folders
import java.io.File;
class ioprog2
{
    public static void main(String args[])
    {
          File fl=new File(args[0]);
          if(fl.isDirectory())
          {
               System.out.println("Exploring:  " + fl.getAbsolutePath());
               String s[]=fl.list();
               for(int i=0;i<s.length;i++)
               {
                      File f=new File(args[0]+"/"+s[i]);
                       if(f.isDirectory())
                             System.out.println("\t<DIR>   " + s[i]);
                        else
                              System.out.println("\tFILES   " + s[i]);
                }
           }
           else
                System.out.println(args[0] + " is not a Directory to List");
        }
}

              
 
