//A Program for Reading Characters
import java.io.*;
class ioprog3 
{
     public static void main(String args[])throws IOException
     {
           System.out.println("Q for Quit ");
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           try
           {
                 char ch;
                 do
                 {
                         ch=(char)br.read();
                         System.out.print(ch);
                  }while(ch!='Q' && ch!='q');
              }
              catch(IOException e)       
               {
                     System.out.println(e.getMessage());
                 }
           }
}
