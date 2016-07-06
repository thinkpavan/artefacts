#include<iostream.h>
 
 class  Emp
   {
      int empno;
      char  name[20];

       public :
	 friend ostream& operator<<(ostream&,Emp&);
	 friend istream& operator>>(istream&,Emp&);
   };

   ostream& operator<<(ostream&  ost,Emp&  E)
     {

       ost<<"\n Empno  : " <<E.empno
          <<"\n  Name  : "<<E.name; 

          return ost;
     }

   istream& operator>>(istream&  ist,Emp&  E)
     {

       cout<<"\n Enter Empno  : ";
       ist>>E.empno;
       cout<<"\n Enter Name  : ";
       ist>>E.name; 

       return ist;
     }


const int Max_elem = 10;

template <class  T>
class List
{
   T  *list;        // An array of integers
   int nmax;         // The dimension of the array

public:
   List(int n = Max_elem)
     {
       list = new T[n];
       nmax = n;
     }
   ~List()
   {delete list;}
   int put_elem(T, int);
   int get_elem(T&, int);
   int getmax() {return nmax;};
   void print();
};

template <class T>
int List<T>::put_elem(T  elem, int pos)
{
   if (0 <= pos && pos < nmax)
   {
      list[pos] = elem;    // Put an element into the list
      return 1;
   }
   else
      return 0;           // Non-zero means error
}

template <class T>
int List<T>::get_elem(T& elem, int pos)
{
   if (0 <= pos && pos < nmax)
   {
      elem = list[pos];    // Retrieve a list element
      return 1;
   }
   else
      return 0;           // non-zero means error
}

template <class T>
void List<T>::print()
{
   for (int i = 0; i < nmax; ++i)
      cout << list[i] << "\n";
}

template <class T>
class Stack : public List<T>
{
   int top;
public:
   Stack() {top = 0;};
   Stack(int n) : List<T>(n)
   {
       top = 0;
   }
   int push(T  elem);
   int pop(T& elem);
   void print();
};

template <class T>
int Stack<T>::push(T  elem)
{
   int m = getmax();

   if (top < m)
   {
      put_elem(elem,top);
      top = top + 1;
      return 1;
   }
   else
    {
       cout<<"\n  Stack Over Flow !!!";
       return 0;
     }
}

template <class T>
int Stack<T>::pop(T& elem)
{
   if (top > 0)
   {
      top = top - 1;
      get_elem(elem,top);
      return 1;
   }
   else
   {
      cout<<"\n  Stack Under Flow !!!";
      return 0;
    }
}

template <class T>
void Stack<T>::print()
{
   T  elem;

   for (int i = top-1; i >= 0; i--)
   {
     // Print in LIFO order
      get_elem(elem,i);
      cout << elem << "\n";
   }
}


void main()
  {
    Stack<Emp>  S(3);
    Emp  item;
    int  ch;

      do
       {
       
	 cout<<"\n 1 . Push into Stack";
	 cout<<"\n 2 . Pop  from Stack";
	 cout<<"\n 3 . Display the Stack";
	 cout<<"\n 4 . Exit ";
	 cout<<"\n Enter a choice : ";
	 cin>>ch;

	  switch(ch)
	   {
	    case 1:
	      cout<<"\n Enter element : ";
	      cin>>item;
              S.push(item);
             break;

	    case 2:
	       if(S.pop(item))
	       cout<<"\n Processed Item is : "<<item;
               break;

	    case 3:
	      S.print();
	     break;
          }
      getch();	                   
     }
    while(ch!=4);
   }
