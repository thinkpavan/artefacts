/* This  Program shows how to develop a native method
Author : Team - J 
Version: 1.0*/

class NativeClass  { 
	public native void  donothing();
	static 
	{
		 System.loadLibrary("natdll");
	 }
}