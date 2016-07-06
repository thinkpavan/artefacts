/*******************************************************************

SourceName         : Macro_Problem.c                                       

Description        : Problems that can arise in #define
*******************************************************************/

#include <stdio.h>
#define     SUM(a, b)  a + b
int main()
{
	int nRes = 0;
	nRes = 5 * SUM(2, 3) ;
	printf("nRes = %d\n", nRes);
	return 0;
}
  

/*
#include <stdio.h>
#define     PRO (a, b)  (a * b)
int main()
{	int nRes = 0;
	nRes = PRO(3-2, 3+2);
	printf("%d", nRes);
	return 0;
}
*/