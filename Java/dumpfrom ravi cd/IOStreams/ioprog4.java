//A Program for Reading Values
import java.io.*;
class ioprog4 
{
     public static void main(String args[])throws IOException
     {
           System.out.println("Enter Two Values to SUM");
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           try
           {
                 int n1=Integer.parseInt(br.readLine());
                 int n2=Integer.parseInt(br.readLine());
                 System.out.println("The Sum of two Values is  " + (n1+n2));
              }
              catch(IOException e)       
               {
                     System.out.println(e.getMessage());
                 }
           }
}
