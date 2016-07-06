/*******************************************************************

SourceName         : Do.c                                       

Description        : do...while loop. 
*******************************************************************/
#include<stdio.h>
int main()
{     
	int nSum = 0, nCount = 101;
	do
	{
		nSum = nSum + nCount;
		nCount++;
	} while ( nCount <= 100);
	printf("Sum is %d", nSum);
	return 0; 	
}
