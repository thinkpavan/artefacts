#include<fstream.h>


/*
  ios::in   --  Input only
  ios::out  --  Output only
  ios::app  --  Append
  ios::nocreate -- dont create if not exist
  ios::noreplace  -- Dont Replace if existing
  ios::ate    -- at the end
 */


//  Output of character to a file
 void main()
   {
      ofstream  fout;
      char  ch;

      fout.open("d:\\FileDemo\\Data.txt",ios::ate);

      if(!fout)
       cout<<"\n Unable to open file ";
      else
      {
	cout<<"\n File opened successfully\n";

	 while( (ch=cin.get())!=EOF )
            fout.put(ch);
      }

      fout.close();

  }

