#include<iostream>
#include<deque>
#include<algorithm>

using namespace std;

int dequeDemo()
{
	deque<double> value;

	ostream_iterator<double> output(cout," " );

	value.push_front(2.2);
	value.push_front(3.5);
	value.push_front(1.1);
	
	cout<<"\n Values contains\n";

	for(int i = 0 ; i < value.size() ; i++)
		cout<<value[ i ] << "\t" ;
	cout<<endl;

	value.pop_front();
	
	cout<<"After pop_front values contains :";
//	copy( value.begin() , value.end() , output );

	value[0] = 1.123 ;
	cout<<endl;
//	copy( value.begin() , value.end() ,output );
	 
	
	return 0;
}