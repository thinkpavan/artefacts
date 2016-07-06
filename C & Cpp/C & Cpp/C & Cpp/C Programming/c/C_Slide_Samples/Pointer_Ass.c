# include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
#include <crtdbg.h>

typedef struct 
{
	char cName[20];
	float M1, M2, Total;
} Student;


void Print( Student* pS, int nSz)
{
	int nCnt;
	for(nCnt = 0; nCnt < nSz; nCnt++)
	{
		printf("%s\t\t%f\t%f\t%f\n", (pS+nCnt)->cName, (pS+nCnt)->M1, (pS+nCnt)->M2, (pS+nCnt)->Total);
	}
}

void Input(Student* pS, int nSz)
{
	int nCnt;
	for(nCnt = 0; nCnt < nSz; nCnt++)
	{
		printf("Enter Name :");
		scanf("%s", (pS+nCnt)->cName);
		fflush(stdin);

		printf("Enter M1 :");
		scanf("%f", &((pS+nCnt)->M1));
		fflush(stdin);

		printf("Enter M2 :");
		scanf("%f", &((pS+nCnt)->M2));
		fflush(stdin);

		(pS+nCnt)->Total = (pS+nCnt)->M1  + (pS+nCnt)->M2;
		
	}
}


int main()
{
	Student* pS;
	int nCnt, nSz;

	int tmpDbgFlag;

    
    tmpDbgFlag = _CrtSetDbgFlag(_CRTDBG_REPORT_FLAG);
    tmpDbgFlag |= _CRTDBG_DELAY_FREE_MEM_DF;
    tmpDbgFlag |= _CRTDBG_LEAK_CHECK_DF;
    _CrtSetDbgFlag(tmpDbgFlag);

	printf("Enter Size: ");
	scanf("%d", &nSz);

	pS = (Student*) malloc(nSz * sizeof(*pS));

	if(NULL == pS)
	{
		printf("Error");
		exit(-1);
	}
	Input(pS, nSz);
	Print(pS, nSz);
	
	free(pS);
	return 55;
}