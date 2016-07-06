#include<iostream>
#include<algorithm>
#include<set>

using namespace std;

int setDemo()
{
	const int MAX = 6 ;	
	double a[MAX] = { 1.2, 4.5 , 2.3  , 5.6 };
	set<double, > double_set(a,a+MAX) ;

	ostream_iterator<double> out(cout," ");

	copy(double_set.begin() , double_set.end() , out );

	// inserting a double value to the set

		double_set.insert(1.2);
		double_set.insert(6.5);
		set<double>::iterator i;
		i = double_set.find(2.3);
		if(i!= double_set.end())
		{
			cout<<"Element 2.3 found in the set";
		}
		else
		{
			cout<<"Element 2.3 is not found in the set";
		}
	
	cout<<"\n\n"; 
	copy(double_set.begin() , double_set.end() , out );
	return 0;
}

