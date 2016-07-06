/*******************************************************************

SourceName         : Tenth.c                                       

Description        : This program demonstrates fread functions to
					 read set of records from the file
			 . 
*******************************************************************/

#include<stdio.h>
typedef struct
{
	char cName[20];	char cAddr[20]; int nAge;
} Person;

int main()
{
	
	Person p;

	FILE* fptr = fopen("A.txt", "r");
	if(NULL == fptr)
	{     
		printf("Error Opening File\n");
		return(-1);
	}

	while(fread(&p, sizeof(p), 1, fptr))
		printf("%s\t%s\t%d\n", p.cName, p.cAddr, p.nAge);
	return(0);
}
