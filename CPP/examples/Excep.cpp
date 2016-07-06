 # include<iostream.h>
void xtest(int test)
{
cout<<“inside xtest”<<test;
if(test = = 1)
	throw test;
}
void main( )
{
try
{
      cout<<in try block”;
      xtest(0);
      xtest(1);
      xtest(2);
}
catch(int i)
{
cout<<“invalid”;
cout<<i<<endl;
}
}

