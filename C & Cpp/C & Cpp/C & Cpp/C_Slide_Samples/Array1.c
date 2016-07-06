/*******************************************************************

SourceName         : Array1.c                                       

Description        : Initialize array and display elements. 
*******************************************************************/
#include<stdio.h>
int main()
{
	int nArr[5] = {1, 2, 3, 4, 5};
	int nCtr;
	for(nCtr = 0; nCtr < 5; nCtr++)
		printf("%d\n", nArr[nCtr]);
	return(0);
}