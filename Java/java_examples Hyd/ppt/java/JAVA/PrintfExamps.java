
// PrintfExamps.java
// 2nd Feb 2005, Andrew Davison, ad@fivedots.coe.psu.ac.th

public class PrintfExamps
{
  public static void main(String[] args)
  {
    int a = 150000, b = 10;
    float c = 5.0101f, d = 3.14f;
		
    System.out.printf("%4d %4d%n", a, b);
    System.out.printf("%x %x%n", a, b);
    System.out.printf("%3.2f %1.1f%n", c, d);
    System.out.printf("%1.3e %1.3e%n", c, d*100);
  }
}  // end of PrintfExamps class

