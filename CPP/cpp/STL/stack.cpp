#include<iostream>
#include<stack>
#include<algorithm>
#include<vector>
#include<list>

using namespace std;

template <class T>
void popElements( T &s)
{
	while( !s.empty() )
	{
		cout<<s.top() << ' ' ;
		s.pop();
	}
}

int stackDemo()
{
	stack<int> intDequeStack ;
	stack<int , vector< int > > intVectorStack ;
	stack<int ,  list<int> > intListStack ;

	for(int i = 0 ; i < 10 ; ++i )
	{
		intDequeStack.push( i );
		intVectorStack.push( i );
		intListStack.push( i );
	}

	cout<<"\nPoping from int Deque stack\n";

	popElements(intDequeStack);

	cout<<"\nPoping from vector Deque stack\n";

	popElements(intVectorStack);

	cout<<"\nPoping from List Deque stack\n";

	popElements(intListStack);

	return 0;
}