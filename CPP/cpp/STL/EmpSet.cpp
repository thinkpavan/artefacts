#include<iostream>
#include<iterator>
#include<set>

class Emp
{
	int eid ;
	int sal ;
	char name[10] ;
	Emp(int eid , int sal , char name[])
	{
		this->eid = eid ;
		this->sal = sal ;
		this->name = name ;
	}
	void show()
	{
		cout<<"Name = "<<name<<"Salary ="<<sal<<"Eid = "<<eid<<endl;
	}
 
};
//void main()
//{
//	set<Emp> a;
//	Emp obj(1,123,"PAvan");
//	Emp obj1(2,123,"PAvan");
//	Emp obj2(1,123,"PAvan");
//	a.insert(obj);
//	a.insert(obj1);
//	a.insert(obj2);
//	set<Emp>::iterator i ;
//	for( i = a.begin();i!=a.end();i++)
//	{
//		Emp temp = *i;
//		temp.show();
//	}
//}