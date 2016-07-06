/*******************************************************************

SourceName         : Fseek.c                                       

Description        : This program demonstrates fseek functions to
					 read set of records from the file
			 . 
********************************************************************/

#include<stdio.h>
typedef struct
{
	char cName[20];	char cAddr[20]; int nAge;
} Person;

int main()
{
	
	Person p;
	int pos;
	int res;

	FILE* fptr = fopen("A.txt", "r");
	if(NULL == fptr)
	{     
		printf("Error Opening File\n");
		return(-1);
	}
	printf("Enter Record no:");
	scanf("%d", &pos);
	pos = (pos - 1) * sizeof(p);

	fseek(fptr, (long)pos, 0);
	
	res = ftell(fptr);

	printf("Position is %d\n\n", res);
	fread(&p, sizeof(p), 1, fptr);
	printf("%s\t%s\t%d\n", p.cName, p.cAddr, p.nAge);
	return(0);
}
