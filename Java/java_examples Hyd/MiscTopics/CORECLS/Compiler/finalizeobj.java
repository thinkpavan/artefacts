/* Demonstrates how finalize method works
Author : Team - J
Version : 1.0
*/

// import java.awt package to use awt classes
import java.awt.*;
import java.awt.event.*;

public class finalizeobj{
	public static void main(String args[])throws Exception{
	x f;
		int i;
		for(i=0;i<2000;i++){
			f = new x();
			Thread.currentThread().sleep(1000);
			if ((i%20)==0){
				System.out.println(" before running Garbage Collector");
				System.gc();
			}
		}

	}
}
class x{
     public void	finalize(){
		System.out.println(" releasing resources");
	}
}