/*******************************************************************
SourceName			: Pointer6.c, 
	
Description			: Accessing element, be careful
*******************************************************************/
#include<stdio.h>
#include <malloc.h>
#include <stdlib.h>
int main()
{
    double* pArr = NULL;
    int nSz, nCnt;
    printf("Enter Size :");
    scanf("%d", &nSz);
	
    pArr = (float*)malloc( nSz * sizeof(*pArr));
    if (NULL == pArr)
    {
        printf("Allocation Failed. Exiting!!!\n");
        exit(1);
    }
    for (nCnt = 0; nCnt < nSz; nCnt++)
    {
        *(pArr + nCnt) = 100 * (nCnt+1);
    }

	for (nCnt = 0; nCnt < nSz; nCnt++)
    {
		printf("%f\n", *(pArr  + nCnt));
    }
	free(pArr);
	pArr = NULL;
    return 0;
}
