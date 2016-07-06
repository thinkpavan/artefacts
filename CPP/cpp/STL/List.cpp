#include<iostream>
#include<list>
#include<algorithm>

using namespace std;

template <typename T>
void printList(const list<T> &list)
{
	cout<<"\n The contents of the List are \n\n";

	ostream_iterator<int> output(cout," ");

	copy(list.begin(),list.end(),output);

	cout<<endl;
}

int ListDemo()
{
	const int SIZE = 4;

	int a[SIZE] = { 2,4,6,8};

	// Creating a vector of Integers
	list<int> value , otherValues  ;

	value.push_back( 2 );
	value.push_back( 3 );
	value.push_back( 3 );
	value.push_back( 3 );
	value.push_back( 3 );
	value.push_front( 1 );
	value.push_front( 0 );
	cout<<" Value contain : ";
	printList(value);

	value.sort();

	cout<<"\nValues after sorting the list\n";
	printList(value);

	//Creating a list with array
	//insert(pos, value)
	//insert(dest pos, start iter, end ite)
	//list<int> listobj(a,a+SIZE)
	value.insert(value.begin(),123);
	//list<int>::iterator itr = value.begin();
	//itr++;
	otherValues.insert(otherValues.begin(), a , a+SIZE);

	cout<<"\n other values begin\n";
	printList(otherValues);
	value.sort();
	otherValues.sort();
	cout<<"Merge operation"<<endl;
	value.merge(otherValues);
	printList(value);
	
	cout<<"Unique operation"<<endl;
	value.unique();
	printList(value);
	cout<<"POP Back operation"<<endl;

	value.pop_back();
	printList(value);
	cout<<"Remove 3 operation"<<endl;

	value.remove(3);
	printList(value);
	cout<<"Clear operation"<<endl;
	value.clear();
	printList(value);
	
	 

	// FUNCTION THAT YOU CAN TRY NOW
	// SORT()
	// MERGE()

	// UNIQUE
	// pop_front
	// pop_back
	// remove

	return 0;
}