/* A sample program that calls a method on corba server
* version : 1.0
* Author : Team -J*/
import INetSolv.*;
import java.util.*;

public class Client {

public static void main(String[] args) {
    org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
    INetSolv.SequenceBasic bs = INetSolv.SequenceBasicHelper.bind(orb,"SeqBasicServer");
    //create a short array and long array which has to be passed as param
    short sseq[] = new short[10];
//    short sseq[] = new short[14];

	for(int i =0;i<10;i++)
		sseq[i] = (short)(i*10); //let use store some values in sequence
	int lseq[] = new int[20];
	for(int i =0;i<20;i++)
		lseq[i] = i; //let use store some values in sequence
	// create a holder as this is inout param
   	 INetSolv.seq1Holder sh = new     INetSolv.seq1Holder(lseq);
	// call the operation
	bs.modifySequence(sh,sseq);
	for(int i =0 ;i< sh.value.length;i++)
		System.out.println(" inout val = "+ sh.value[i]);
  }
}