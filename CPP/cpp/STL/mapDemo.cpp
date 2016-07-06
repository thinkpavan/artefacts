#include<iostream>
#include<map>
#include<algorithm>

using namespace std;

int mapDemo()
{
	//typedef multimap<int, emp ,less<int> > mid ;
	typedef multimap<int , double,less<int> > mmid ;
	mmid pairs ;
	ostream_iterator<int> out(cout,"   ");
	pairs.insert(mmid::value_type(15,2.7));
	pairs.insert(mmid::value_type(15,99.3));
	pairs.insert(mmid::value_type(1,99.3));
	pairs.insert(mmid::value_type(2,99.3));
	pairs.insert(mmid::value_type(3,99.3));

	for(mmid::const_iterator iter = pairs.begin(); iter != pairs.end() ; ++iter )
		cout<<iter->first<<'\t'<<iter->second<<'\n';
	
	return 0;
}