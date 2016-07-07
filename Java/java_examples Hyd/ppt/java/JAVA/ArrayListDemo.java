import java.util.*;

public class ArrayListDemo 
{ 
  public static void main(String[] arg) 
  {
    ArrayList myAL = new ArrayList();

    Integer[] primes = new Integer[] {
        new Integer(2), new Integer(3), new Integer(5), 
        new Integer(7), new Integer(11), new Integer(13), 
        new Integer(17), new Integer(19)};

    List li = Arrays.asList( primes );
    myAL.addAll( li );

    System.out.println("ArrayList:");
    ListIterator l = myAL.listIterator();
    while( l.hasNext() )
       System.out.print("  "+ l.next() );
    System.out.println();
    System.out.println("You have "+ myAL.size() + " primes");

    System.out.println("Remove 2nd element");
    myAL.remove(1);

    System.out.println("ArrayList:");
    l = myAL.listIterator();
    while( l.hasNext() )
       System.out.print("  "+ l.next() );
    System.out.println();
    System.out.println("You have "+ myAL.size() + " primes");

  }
} // end of ArrayListDemo
