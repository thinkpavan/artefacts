#include<iostream>
#include<typeinfo>

using namespace std;

void main()
{
	int i = 10 ;
	cout<<typeid(i).name();
}