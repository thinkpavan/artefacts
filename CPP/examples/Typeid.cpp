#include<typeinfo>
#include<iostream>
using namespace std;

class Base
{
	int a ;
public :
	Base(){
		a = 100 ;
	}
	 void show(){
		cout<<a;
	}
	void read(){
		a = 10 ;
	}
	virtual void disp(){
		cout<<"Base display";
	}
};

class Derived : public Base
{
	int b ;
public:
	void disp(){
		cout<<"Derived disp\n";
	}
	Derived(){
		b = 100 ;
	}
	void show(){
		cout<<b;
	}
	void read(){
		Base::read();
		b = 10;
	}
};

void main()
{
	const int i = 10 ;
	int *ptr = (int*) &i ;
	(*ptr)++ ;

	cout<<*ptr ;
	cout<<i;

}




















