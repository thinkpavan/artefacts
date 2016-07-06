#include<fstream.h>

// Input of character from file
 void main()
   {
     
	 ifstream   fin("d:\\FileDemo\\Sample.txt");
     char  ch;

      if(!fin)
       cout<<"\n Unable to open file !! ";
      else
       {
         while( (ch = fin.get()) !=EOF )
	 cout<<ch;
       }

       fin.close();
   }