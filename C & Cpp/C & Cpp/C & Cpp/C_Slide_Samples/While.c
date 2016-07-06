/*******************************************************************

SourceName         : While.c                                       

Descrip0tion        : while loop. 
*******************************************************************/
#include<stdio.h>
int main()
{     int nSum = 0, nCount = 101;
      while ( nCount <= 100)
      {	
		  nSum = nSum + nCount;
		  nCount++; 
      }
      printf("Sum is %d\n", nSum);
      return 0;
}