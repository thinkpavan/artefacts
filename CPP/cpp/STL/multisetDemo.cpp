#include<iostream>
#include<algorithm>
#include<set>

using namespace std;

int multisetDemo()
{
	const int MAX = 10 ;	
	int a[MAX] = { 7,22 , 9 , 1 , 18 , 30 , 100 , 22 , 85 , 13};
	// using a typedef to create a new type for a multiset of integers ordering in ascending order using the function
	// object te funciton object less<int>  this new type is used to instantitate a variable
	typedef multiset<int , less<int> > ims ;
	ims multiset1;

	cout<<" There are currently:" <<multiset1.count(15)<<endl  ;
	
	multiset1.insert(15);
	multiset1.insert(15);
	multiset1.insert(15);

	cout<<" There are currently:" <<multiset1.count(15)<<endl  ;

	ims::const_iterator result ;

	result = multiset1.find( 15 ) ;

	if( result != multiset1.end() )
		cout<<"Found value 15 \n";
	else
		cout<<" No such element 15";

	multiset1.insert ( a , a+MAX);

	ostream_iterator<int> out( cout, "   ");

	copy( multiset1.begin() , multiset1.end() , out ); 

	cout<<"\n\nLower bound of 22 "<< *(multiset1.lower_bound(22));

	cout<<"\n\n upper bound of 22 "<< *(multiset1.upper_bound(22));

	return 0;
}

