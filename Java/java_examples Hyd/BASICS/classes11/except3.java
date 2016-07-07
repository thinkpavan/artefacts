/* this program throws mychkexception 
Author : Team - J 
Version: 1.0*/

class except3  { 
	public void Error() throws mychkexception{
		throw (new mychkexception(" exception my chkexception"));
	}
	
	public static void main(String args[]){
		
		except3 e = new except3();
		// we are not handling the error here
		System.out.println(" before method call");
		try{
		e.Error();
		} catch (mychkexception mye){
			System.out.println(mye);
		}
		System.out.println(" after method call  " );
	}
}
 