#include<iostream>
#include<stdio.h>
using namespace std;

int main()
{
	unsigned x = 23 , *unsignedPtr ;

	void *voidPtr = &x ;
	char *charPtr = "C++";
	unsignedPtr = reinterpret_cast<unsigned *> (voidPtr) ;
	cout<<"Unsigned ptr is = "<<*unsignedPtr<<"\t";
	cout<<"char * to unsigned results in  = "<<(x = reinterpret_cast<unsigned > (charPtr) )<<"\n";
	
}
