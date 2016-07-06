/*******************************************************************

SourceName         : Array2.c                                       

Description        : Initialize and access 2D array elements. 
*******************************************************************/
#include <stdio.h>

int main()
{
	int nArr[3][3] = { 1, 2, 3, 4, 5, 6, 7, 8, 9}, nCnt1, nCnt2;

	for(nCnt1 = 0; nCnt1 < 3; nCnt1++)
	{
		for(nCnt2 = 0; nCnt2 < 3; nCnt2++)
			printf("%d\t", nArr[nCnt1][nCnt2]);
		printf("\n");
	}
	return 0;
}