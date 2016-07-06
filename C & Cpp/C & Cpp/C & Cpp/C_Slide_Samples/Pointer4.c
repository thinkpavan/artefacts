/*******************************************************************
SourceName			: Pointer4.c, 
	
Description			: Accessing 2D array using pointer variable
*******************************************************************/

#include <stdio.h>

#define NUM_ROWS	3
#define NUM_COLS	3

int main()
{
	int arr[NUM_ROWS][NUM_COLS] = { { 1, 2, 3},
									{ 4, 5, 6},
									{7, 8, 9}
								};
	int nCnt1, nCnt2;
	int *p = arr[0]; 	
	for (p = &arr[0] [0]; p <= &arr[NUM_ROWS - 1][NUM_COLS - 1]; p++)
		*p = 0;

	for(nCnt1 = 0; nCnt1 < NUM_ROWS; nCnt1++)
	{
		for(nCnt2 = 0; nCnt2 < NUM_ROWS; nCnt2++)
			printf("%d\t", arr[nCnt1][nCnt2]);
		printf("\n");
	}
	return 0;
}
