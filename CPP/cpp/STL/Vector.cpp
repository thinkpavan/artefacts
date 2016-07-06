#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

template <typename T>
void printVector(const vector<T> &vec)
{
	cout<<" The contents of the vector are \n\n";
	vector< T >::const_iterator p ;
	cout<<"\t";
	for( p = vec.begin() ;p != vec.end() ; p++)
	{
		cout<<*p<<"\t";
	}
	cout<<endl;
}
int foo()
{
	static int i = 10 ;
	i += 5 ;
	return i ;
}
int vectorDemo()
{
	const int SIZE = 6;

	int a[SIZE] = { 1 , 2 , 3 , 4 , 5 , 6 };

	// Creating a vector of Integers
	vector<int> v(6) ;
	printVector(v);
	fill(v.begin(),v.end(),10);
	printVector(v);
	fill_n(v.begin(),5,100);
	printVector(v);
	generate(v.begin(),v.end(),foo);
	printVector(v);
	generate_n(v.begin(),5,foo);
	printVector(v);
	cout<<"\n\n";
	//cout<<"Initial size of the vector\t\t\t"<<v.size()<<"\n Initial capacity of the vector is \t\t"<<v.capacity()<<endl;

	//v.push_back( 1 ) ;
	//v.push_back( 2 ) ;
	//v.push_back( 3 ) ;
	//v.push_back( 4 ) ;
	//v.push_back( 5 ) ;
	//v.push_back( 6 ) ;

	//cout<<"size of the vector after inserting 4 values \t"<<v.size()<<"\nCapacity of the vector after inserting 4 values "<<v.capacity()<<endl;
	//

	//cout<<" \n The contents of the array are\n\n";
	//for(int i = 0; i<SIZE;i++)	
	//	cout<<"\t"<<a[i];
	//cout<<endl;
	//
	//cout<<"\n The contents of the vector using iterator\n";

	//printVector(v);

	//cout<<"\n The contents of the vector using reverse _ iterator\n";

	//vector< int >::reverse_iterator p ;
	//cout<<"\t";
	//for( p = v.rbegin() ;p != v.rend() ; p++)
	//{
	//	cout<<*p<<"\t";
	//}
	//cout<<endl;


	//cout<<"Copying the contents of he array to the vector \n";
	//vector<int> new_vector(a,a+SIZE);

	//ostream_iterator<int> output(cout," ");

	//copy(v.begin(),v.end(),output);

 //   cout<<endl;

	//printVector(new_vector);

	////Replacing the first element with 7 with an array notation and using 'at' method

	//v[0] =  7 ;

	//printVector(v);

	//v.at(0) = 17 ;
	//
	//printVector(v);
	//
	//v.insert(v.begin() + 1, 22 );

	//printVector(v);

	////What happens if you try to insert at a differnet position

	//try
	//{
	//	v.at(999)  = 100 ;
	//}
	//catch(out_of_range e)
	//{
	//	cout<<"\n This is a exception\n";
	//}
	//
	//v.erase(v.begin());

	//cout<<"\nAfter performing erase\n";

	//printVector(v);
	//

	////Clearing the complete vector
	//v.erase(v.begin(),v.end());
	//
	//printVector(v);

	////using clear on vector 
	//printVector(new_vector);

	//new_vector.clear();

	//printVector(new_vector);
	
	return 0;
}



