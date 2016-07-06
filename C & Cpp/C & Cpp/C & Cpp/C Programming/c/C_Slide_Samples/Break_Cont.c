/*******************************************************************

SourceName         : Break_Cont.c                                       

Description        : break statment. 
*******************************************************************/
/* #include <stdio.h>
int main()
{
	int nCnt = 1;
	while(nCnt <= 10)
	{
		printf("%d\n", nCnt);
		if (8 == nCnt)
			break;
		nCnt++;
     }
	printf("Broke at %d\n", nCnt);
	return 0;
} 
*/
/*******************************************************************

SourceName         : Break_Cont.c                                       

Description        : Continue statment. 
*****************************************************************/#include <stdio.h>
int main()
{
	int nCnt = 1;
	while(nCnt <= 10)
	{
		
		if (5 == nCnt)
		{	nCnt++;
			continue;
		}
		printf("%d\n", nCnt);
		nCnt++;
     }
	printf("Used continue to skip 5\n");
	return 0;
}

 