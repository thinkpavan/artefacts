#include <stdio.h>
#include <string.h>


typedef struct
{
	int nID;
	char cName[20];
	float fMark1, fMark2, fTotal, fPercentage;
} Student;

typedef union
{
	int nID;
	char cName[20];
} Search;


int main()
{
	Student s1[5];
	Search s;
	int nCnt, nChoice;

	for(nCnt = 0; nCnt < 5; nCnt++)
	{
		printf("Enter ID :");
		scanf("%d", &s1[nCnt].nID);
		
		printf("Enter Name :");
		scanf("%s", &s1[nCnt].cName);

		printf("Enter Mark1 :");
		scanf("%f", &s1[nCnt].fMark1);

		printf("Enter Mark2 :");
		scanf("%f", &s1[nCnt].fMark2);

		s1[nCnt].fTotal = s1[nCnt].fMark1 + s1[nCnt].fMark2;
		
		s1[nCnt].fPercentage = s1[nCnt].fTotal / 2;
	}
	printf("Enter Choice [0/1] :");
	scanf("%d", &nChoice);

	if(0 == nChoice)
	{
		printf("Enter ID :");
		scanf("%d", &s.nID);

		for(nCnt = 0; nCnt < 5; nCnt++)
		{
			if(s.nID == s1[nCnt].nID)
			{
				printf("\n%d\t%s\t%f\t%f\t%f\t%f", s1[nCnt].nID, s1[nCnt].cName, 
					s1[nCnt].fMark1, s1[nCnt].fMark2, 
					s1[nCnt].fTotal, s1[nCnt].fPercentage );
				break;
			}
		}
	}
	else
	{
		printf("Enter Name :");
		scanf("%s", &s.cName);

		for(nCnt = 0; nCnt < 5; nCnt++)
		{
			if(0 == strcmp(s.cName, s1[nCnt].cName))
			{
				printf("\n%d\t%s\t%f\t%f\t%f\t%f", s1[nCnt].nID, s1[nCnt].cName, 
					s1[nCnt].fMark1, s1[nCnt].fMark2, 
					s1[nCnt].fTotal, s1[nCnt].fPercentage );
				break;
			}
		}
	}
	printf("\n");
	return 0;
}


