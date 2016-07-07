import java.util.*;

public class HashMapDemo 
{
  public static void main(String[] arg) 
  {
    HashMap myHM = new HashMap();

    // stock symbols matched with prices
    myHM.put( "SUNW", new Double(64.5) );
    myHM.put( "IBM",  new Double(156.0) );
    myHM.put( "INTC", new Double(97.5) );
    myHM.put( "HWP",  new Double(64.5) );

    Object o = myHM.get("SUNW");
    System.out.println(" SUNW price "+ o );

    System.out.println("You have " + myHM.size() + " stocks");
  }

} // end of HashMapDemo
