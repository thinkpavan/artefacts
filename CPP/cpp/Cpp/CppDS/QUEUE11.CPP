#include<iostream.h>
#include<conio.h>


const int Max_elem = 10;

class List
{
   int  *list;        // An array of integers
   int nmax;         // The dimension of the array

public:
   List(int n = Max_elem)
     {
       list = new int[n];
       nmax = n;
     }
   ~List()
   {delete list;}
   int put_elem(int, int);
   int get_elem(int&, int);
   int getmax() {return nmax;};
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
      return 0;           // non-zero means error
}

void List::print()
{
   for (int i = 0; i < nmax; ++i)
      cout << list[i] << "\n";
}



 class  Queue : public List
  {
     int  front,rear;
     int  count;

     public :
      Queue() {front=rear=count=0;};
      Queue(int n) : List(n)
       {
	  front=rear=count=0;
        }
   int Insert(int  elem);
   int Delete(int& elem);
   void print();
  };

  int Queue::Insert(int  elem)
   {

   int m = getmax();

   if (count < m)
   {
      put_elem(elem,rear);
      rear = ( rear + 1 ) % m;
      count++;
      return 1;
   }
   else
    {
       cout<<"\n  Queue Full !!!";
       return 0;
     }
}

int Queue::Delete(int& elem)
{
  int  m = getmax();
   if (count > 0)
   {
      get_elem(elem,front);
      front = ( front + 1 ) % m;
      count--;
      return 1;
   }
   else
   {
      cout<<"\n  Queue Empty !!!";
      return 0;
    }
}

void Queue::print()
{
   int  elem;

   int m = getmax();

   for (int i = 0; i < count; i++)
   {
     // Print in FIFO order
      get_elem(elem,(front + i ) % m );
      cout << elem << "\n";
   }
}



void main()
  {
    Queue  Q(5);
    int   item;
    int  ch;

   do
    {
     clrscr(); 							// printf("\n\n\n\n");
      cout<<"\n 1 . Add    To    Queue ";
      cout<<"\n 2 . Delete from  Queue ";
      cout<<"\n 3 . Display The  Queue ";
      cout<<"\n 4 . Exit  ";
      cout<<"\n  Enter Choice ..";
      cin>>ch;
	  switch(ch)
	   {
	    case 1:
	      cout<<"\n Enter element : ";
	      cin>>item;
              Q.Insert(item);
             break;

	    case 2:
	       if(Q.Delete(item))
	       cout<<"\n Processed Item is : "<<item;
               break;

	    case 3:
	      Q.print();
	     break;
          }
      getch();	                   
     }
    while(ch!=4);
   }
