#include<iostream.h>
#include<conio.h>

class List
{
   int  *list;        // An array of integers
   int nmax;         // The dimension of the array
   int nelem;        // The number of elements

public:
   List(int n = 10)
     {
       list = new int[n];
       nmax = n;
       nelem = 0;
     }
   ~List()
   {delete list;}

   int put_elem(int , int);
   int get_elem(int&, int);
   int getmax()
    {
     return nmax;
     }
   void print();
};

int List::put_elem(int  elem, int pos)
{
   if (0 <= pos && pos < nmax)
   {
      list[pos] = elem;    // Put an element into the list
      return 1;
   }
   else
      return 0;           // zero means error
}

int List::get_elem(int& elem, int pos)
{
   if (0 <= pos && pos < nmax)
   {
      elem = list[pos];    // Retrieve a list element
      return 1;
   }
   else
      return 0;           // zero means error
}

void List::print()
{
   for (int i = 0; i < nelem; ++i)
      cout << list[i] << "\n";
}


class Stack : public List
{
   int top;

public:
   Stack() {top = 0;}
   Stack(int n) : List(n)
     {
       top = 0;
      }
   int push(int  elem);
   int pop(int& elem);
   void print();
};

int Stack::push(int  elem)
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

int Stack::pop(int& elem)
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

void Stack::print()
{
   int  elem;

   for (int i = top-1; i >= 0; i--)
   {
     // Print in LIFO order
      get_elem(elem,i);
      cout << elem << "\n";
   }
}


void main()
  {
    Stack  S(3);
    int   item;
    int  ch;

      do
       {
         clrscr();
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

