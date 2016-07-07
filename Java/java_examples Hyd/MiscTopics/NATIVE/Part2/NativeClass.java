/* This  Program shows how to develop a native method
Author : Team - J 
Version: 1.0*/

class NativeClass  { 
	// shows how to return java primitive types from native methods
	public native int  retint();
	public void methodCalledbyNM(int j){
		System.out.println("In java Method" + j);	
	}
	static 
	{
		 System.loadLibrary("natdll1");
	 }
}