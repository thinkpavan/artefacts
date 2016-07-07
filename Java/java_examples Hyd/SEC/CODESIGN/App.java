/* This shows how to give permission to the code signed  by a sender
Author : Team - J
Version : 1.0
*/


import java.io.*;

public class App{
	public static void main(String args[]){
		try{
			FileInputStream fis = new FileInputStream ("c:\\xyz.txt");
			System.out.println("file opened for read");

		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
}