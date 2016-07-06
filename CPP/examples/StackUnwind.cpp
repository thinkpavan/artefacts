#include<iostream>
#include<stdexcept>
#include<exception>

using namespace std;

void function3() throw ( int ){
	throw  10 ;
}

void function2() throw( int ) {
	function3();
	throw 10;
}

void function1() throw( int ) {
	function2();
}

int main(){
	try{
		function1();
	}
	catch(int e){
		cout<<"This is in main catch"<<endl;
		//cout<<e.what();
	}
	return 0;
}
