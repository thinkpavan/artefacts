import java.util.*;

public class HashSetDemo 
{
  public static void main(String[] arg) 
  {
    HashSet myHS = new HashSet();
    String s1="Pliers", s2="Hammer", s3="Wrench";
    myHS.add( s1 );
    myHS.add( s2 );
    myHS.add( s3 );

    Iterator i = myHS.iterator();
    while( i.hasNext() )
      System.out.println(" tool: " + i.next() );

    System.out.println( "You have " + myHS.size() + " tools");
  }

} // end of HashSetDemo
