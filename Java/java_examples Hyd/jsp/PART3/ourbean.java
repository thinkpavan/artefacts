/* a simple bean with some getter and setters plus one method
version : 1.0
Author : Team-J*/
package ourpack;
public class ourbean{
	int prop1=0;
	public void setProp1(int i){
		prop1 = i;
	}
	public int getProp1(){
		return prop1;
	}
	public int someMethod(int k){
		return (k *100);
	}
}