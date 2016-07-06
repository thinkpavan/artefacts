/*******************************************************************

SourceName         : For.c                                       

Description        : for loop. 
*******************************************************************/
#include<stdio.h>
int main()
{
    int nSum = 0, nCnt = 1;
	for(nCnt = 101; nCnt <=100; nCnt++)
	{
		nSum = nSum + nCnt;
		
	}
	printf("Sum is %d\n", nSum);
	return 0;
}