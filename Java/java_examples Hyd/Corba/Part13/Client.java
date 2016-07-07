/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/
import INetSolv.*;
import java.util.*;

public class Client {

public static void main(String[] args) {
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    INetSolv.ArrayBasic bs = INetSolv.ArrayBasicHelper.bind(orb,"ArrayServer");

    short sseq[][] = new short[2][20];
	for(int i =0;i<20;i++){
		sseq[0][i] = (short)(i);
		sseq[1][i] = (short)(i*2);
	}
	int lseq[] = new int[20];
	for(int i =0;i<20;i++)
		lseq[i] = i; //let use store some values in sequence
	// create a holder as this is inout param
   	 INetSolv.larrayHolder sh = new INetSolv.larrayHolder(lseq);
	// call the operation
	bs.modifyArray(sh,sseq);
	for(int i =0 ;i< sh.value.length;i++)
		System.out.println(" inout val = "+ sh.value[i]);
  }
}