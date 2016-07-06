#include<fstream.h>

//  Output of Text to a file
 void main()
   {
      ofstream  fout("d:\\FileDemo\\Data.txt");
      char  text[80];

      while ( (cin.getline(text,80)) != NULL )
      {
       fout<<text<<endl;
      }
  
      fout.close();

  }

