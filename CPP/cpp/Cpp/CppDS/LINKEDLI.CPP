#include<iostream.h>
#include<conio.h>

 struct Node
   {
      int  data;
      Node *next;
   };

 class LinkedList
  {
     Node  *head;

      public:

       LinkedList()
	{ head=NULL; }

	void Insert(Node  item);
	int  Delete(Node&   t)
	 {
	    Node  *p;
	    if(head)
            {
              p = head;
	      head = head->next;
	      t = *p;
	      delete p;
              return 1;
	    }

           return 0;

	 }

	void Print();
	void Clear()
	 {
	 }

  };

	void LinkedList::Insert(Node  item)
	 {
           Node *t;
	    t = new Node;
	    *t = item;
	    /*t->next = head;
	    head = t;*/

	   Node  *p,*q;

	    if(head)  // if(head!=NULL)
            {
	       if(head->data > t->data)
	        {
	          t->next = head;
	          head = t; 
	         }
	       else
                {
	          q = head;
	          while(q)
	          {
	            if(q->data > t->data)
		    break;
		    p = q;
                   q = q->next;
	          }

	         p->next=t;
	         t->next=q;
	         }
            }
           else
	    {
	     t->next = head;
	     head = t;
	    }

       }



  	void LinkedList::Print()
	 {
	   Node  *t;

	   t = head;

	    while(t)
	     {
	       cout<<t->data<<endl;
               t = t-> next;
	     }

	 }



void main()
{
  LinkedList  List;
  Node  item;

  int  ch;

  do
   {
    clrscr();
     cout<<"\n  1 . Add Node ";
     cout<<"\n  2 . Delete Node";
     cout<<"\n  3 . Display ";
     cout<<"\n  4 . Delete All";
     cout<<"\n  5 . Exit ";
     cout<<"\n   Enter Choice...";
     cin>>ch;

      switch(ch)
       {
	case 1:
	 // Add Node  to Front
	  cout<<"\n Enter Data : ";
	  cin>>item.data;

	    List.Insert(item);

	 break;

	 case 2:
	  // Delete Node  from Front 
	  if ( List.Delete(item))
            cout<<item.data;

         break;

	case 3:
	  // Display Nodes

	   List.Print();

	break;

	case 4:
	  // Delete All Nodes

	    List.Clear();

	    break;

	case 5:
	   //Exit

           break;
	   }

	getch();

    }while(ch!=5);
   
  }





















  /*struct  Emp
  {
    int eno;
    char name[20];
  };  */

//  Linked List
/* struct Node
 {
   struct Emp data;
   struct Node *next;
 }; */

