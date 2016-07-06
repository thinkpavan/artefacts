/*******************************************************************
SourceName			: Pointer2.c, 
	
Description			: Accessing Pointer Elements 
*******************************************************************/
#include <stdio.h>

int main()
{
	int nArr[5] = {1, 2, 3, 4, 5};
	int*pArr = nArr;
	
	while( pArr <= &nArr[4])
	{
		printf("%d ", *pArr);
		pArr++;
	}
	printf("\n");
	return 0;
}
