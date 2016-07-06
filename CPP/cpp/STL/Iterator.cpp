#include<iostream>
#include<iterator>
using namespace std;
int iteratorDemo()
{
	cout<< " Enter 2 integers :";

	//creating a istream iterator that is capable of accepting integers
	istream_iterator<int> inputInt(cin);

	int number1 , number2 ;

	//read first int from standard input
	number1 = *inputInt;
	//move iterator to the next input value
	++inputInt;
	//read second int from the standrad input
	number2 = *inputInt;

	cout<<" The numbers you have entered are :"<<number1<<"\t "<<number2<<endl;

	return 0;
}