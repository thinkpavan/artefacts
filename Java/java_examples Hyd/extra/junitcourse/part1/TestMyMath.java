/* Class to test MyMath.
Version:1.0
Author: Team-J
*/


public class TestMyMath{
	public static void main(String args[]){
		int res=0;
		MyMath m = new MyMath();
		//Test Case 1
		res = m.add(20,30);
		if(res == 50)
			System.out.println("Test case 1 passed");
		else
			System.out.println("Test case 1 falied");
		//Test Case 2
		res = m.add(Integer.MAX_VALUE,1);
		if(res == Integer.MIN_VALUE)
			System.out.println("Test case 2 passed");
		else
			System.out.println("Test case 2 falied");
		//Test Case 3
		res = m.add(Integer.MIN_VALUE,-1);
		if(res == Integer.MAX_VALUE)
			System.out.println("Test case 3 passed");
		else
			System.out.println("Test case 3 falied");		
		// Test Case 4 ... n
	}
}