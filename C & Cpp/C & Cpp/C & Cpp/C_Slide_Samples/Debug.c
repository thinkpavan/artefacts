#include <stdio.h>

void Print(int nData)
{
		printf("Result is %d\n", nData);
}

int Factorial(int nNum)
{
	int nRes = 1;
	int nCnt;
	for(nCnt = 1; nCnt <=nNum; nCnt++)
		nRes *= nCnt;
	return nRes;
}


int main()
{
	int nData = 5;
	int nRes;
	nRes = Factorial(nData);
	Print(nRes);
	
	return 0;
}