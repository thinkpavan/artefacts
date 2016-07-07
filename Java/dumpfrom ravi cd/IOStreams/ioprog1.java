//A Program for Printing File Properties
import java.io.File;
class ioprog1 
{
    static void prn(String s)
    {
           System.out.println("\t" + s);
     }
     public static void main(String args[])
     {
            File fl=new File("ioprog1.java");
            prn("File Name            :    " + fl.getName());
            prn("File Path              :    " + fl.getPath());
            prn("AbsolutePath     :    " + fl.getAbsolutePath());
            prn(fl.exists()?"Exists":"Does not Exists");
            prn(fl.canWrite()?"Writeable":"Not Writeable");
            prn(fl.canRead()?"Readable":"Not Readable");
            prn(fl.isDirectory()?"Is a Directory":"Not a Directory");
            prn("Last Modified     :    " + fl.lastModified());   
            prn("File Length          :    " + fl.length());
        }

} 