//Program for FileInput/FileOutputStream
import java.io.*;
class ioprog5
{
    public static void main(String args[]) throws IOException
    {
          String s=" ";
          DataInputStream dn=new DataInputStream(System.in); 
          OutputStream o=new FileOutputStream("newfile.txt");
          try
           {
                   System.out.println("\nEnter Text Here"); 
                    s=dn.readLine();
             }
             catch(IOException e)
             {
                    System.out.println(e.getMessage());
              }
              byte buf[]=s.getBytes();
              for(int i=0;i<buf.length;i++)
                      o.write(buf[i]);
               o.close();
               System.out.println("\nValues Stored into File\n");  
               InputStream f=new FileInputStream("newfile.txt");        
               System.out.println("\nValues Available are "+f.available());                         
                System.out.print("\n"+(char)f.read());
                System.out.print((char)f.read());
                System.out.print((char)f.read());
                System.out.println("\nValues Available are "+f.available());
                 System.out.print("\n");
                 int size=f.available();
                 for(int i=0;i<size;i++)
                         System.out.print((char)f.read());      
                  f.close();
         }
}
