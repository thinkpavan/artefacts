#include<iostream>
#include<exception>
#include<memory>

using namespace std;
/*
int main(){

	double *ptr[50];

	for(int i = 0 ;i < 10 ;i ++ ){

		ptr[i] = new double[50000000];

		if(ptr[i] == 0 ){
			cout<<"Memory allocation failed for ptr [ "<<i <<" ] \n";
			break;
		}
		else{
			cout<<"Memory allocated for ptr [ " << i <<" ] \n"; 
		}
		delete ptr[i];
	}
	return 0;
}


*/

void foo()
{
	cout<<"This is the terminate function\n";
}
int main(){

	double *ptr[50];

		try{

			ptr[0] = new double[65000000000000u];
			cout<<"ptr["<<"0"<<"] allocated\n";
		}
		catch(bad_alloc e){
			cout<<e.what();
		}
	
}

	//assert(false);
/*	int c = 0  ;
	int a = 10 / c;
	void *test = set_terminate(foo);
	cout<<"test"<<test;
	 a = 10 / c;
	 test = set_terminate(foo);
	cout<<"test"<<test;
	
	return 0;
}
*/