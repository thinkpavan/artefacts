import  java.io.*;

public class  BuffApp
{
   public  static  void  main(String args[])throws IOException
   {
     BufferedReader  br=new  BufferedReader(new  InputStreamReader(System.in));
     //DataInputStream dis=new DataInputStream(System.in);
     //BufferedInputStream bis=new BufferedInputStream(System.in)
     String s,s1;
     int i;
     float f;
     byte b;
     short ss;
     boolean bb;
     long l;
     double d;
     System.out.println("Enter a String ");
     s1=br.readLine();
     System.out.println("Enter a byte ");
     s=br.readLine();
     b=Byte.parseByte(s);
     System.out.println("Enter a integer ");
     s=br.readLine();
     i=Integer.parseInt(s);
     System.out.println("Enter a short ");
     s=br.readLine();
     ss=Short.valueOf(s).shortValue();
     System.out.println("Enter a float ");
     s=br.readLine();
     f=Float.valueOf(s).floatValue();
     System.out.println("Enter a long ");
     s=br.readLine();
     l=Long.parseLong(s);
     System.out.println("Enter a double ");
     s=br.readLine();
     d=Double.valueOf(s).doubleValue();
     System.out.println("Enter a boolean ");
     s=br.readLine();
     bb=Boolean.valueOf(s).booleanValue();

     System.out.println("Byte "+b);
     System.out.println("String "+s1);
     System.out.println("int "+i);
     System.out.println("float "+f);
     System.out.println("long "+l);
     System.out.println("double "+d);
     System.out.println("boolean "+bb);
     System.out.println("short "+ss);
   }
}
