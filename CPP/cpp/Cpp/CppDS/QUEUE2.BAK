#include<iostream.h>
#include<conio.h>

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

template <class  T>
int List<T>::put_elem(T elem, int pos)
{
   if (0 <= pos && pos < nmax)
   {
      list[pos] = elem;    // Put an element into the list
      return 1;
   }
   else
      return 0;           // zero means error
}

template <class  T>
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

template <class  T>
void List<T>::print()
{
   for (int i = 0; i < nmax; ++i)
      cout << list[i] << "\n";
}


template <class  T>
 class  Queue : public List<T>
  {
     int  front,rear;
     int  count;

     public :
      Queue(int n = Max_elem) : List<T>(n)
       {
	  front=rear=count=0;
        }
   int Insert(T  elem);
   int Delete(T& elem);
   void print();
  };

template <class  T>
  int Queue<T>::Insert(T  elem)
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

template <class  T>
int Queue<T>::Delete(T& elem)
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

template <class  T>
void Queue<T>::print()
{
   T   elem;

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
    Queue<Emp>  Q(5);
    Emp         item;
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
