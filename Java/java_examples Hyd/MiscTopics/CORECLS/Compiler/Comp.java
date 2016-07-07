/* Shows about Complier class
Author : Team -J
Version : 1.0

invoke this program by following command line
java -djava.compiler=abc Comp
*/


public class Comp{
	public static void main(String args[])throws Exception{
		String comp = System.getProperty("java.compiler");
		System.out.println(comp);
	}	
}

