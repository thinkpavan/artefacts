/*******************************************************************
SourceName			: Pointer7.c, 
	
Description			: Array of Pointer
*******************************************************************/
#include<stdio.h>
#include <malloc.h>
#include <stdlib.h>

#define ROW 	2
#define COL1 	1
#define COL2 	2
int main(void)
{
	int Cols[ROW] = { COL1, COL2};
	int nCnt1, nCnt2;
	int *pArr[ROW];	 // or *(arr[ROW]);
	pArr[0] = (int*) malloc ( COL1 * sizeof(int));
	pArr[1] = (int*) malloc ( COL2 * sizeof(int));

	if(NULL == pArr[0] && NULL == pArr[1])
	{
		printf("Error Allocating Memory\n");
		exit(-1);
	}
	pArr[0][0] = 1;
	pArr[1][0] = 2;
	pArr[1][1] = 3;

	for(nCnt1 = 0; nCnt1 < ROW; nCnt1++)
	{
		for(nCnt2 = 0; nCnt2 < Cols[nCnt1]; nCnt2++)
			printf("%d\t", pArr[nCnt1][nCnt2]);
		printf("\n");
	}
	free(pArr[0]);
	free(pArr[1]);
	return 0;
}

