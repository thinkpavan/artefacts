/*******************************************************************
SourceName			: Pointer8.c, 
	
Description			: Pointer to Array
*******************************************************************/
#include <stdio.h>
#include <malloc.h>
#define ROW 3
#define COL 3
int main()
{
	int (*pArr)[COL];
	int i, j, val = 10;
	pArr = (int(*)[COL]) malloc (sizeof(int[COL]) * ROW);
	
	if(NULL == pArr)
	{
		printf("Error Allocating Memory\n");
		return -1;
	}

	for(i = 0; i < ROW; i++)
	{
		for(j = 0; j < COL; j++, val+=10)
		{
			 pArr[i][j] = val;
			 printf("%d\t", pArr[i][j]);
		}
		printf("\n");
	}
		
	free(pArr);
	return(0);
}
