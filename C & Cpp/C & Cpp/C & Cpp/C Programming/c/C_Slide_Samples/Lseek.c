/*******************************************************************

SourceName         : Lseek.c                                      

Description        : This program demonstrates to lseek function
 
*******************************************************************/
#include <sys/types.h>
#include <sys/stat.h>
#include <io.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct 
{
	char cName[20];
	char cAddr[20];
	int nAge;
} Person;

int main()
{
	Person p;
	int handle = 0, pos;
	int res;

	handle = open("A.Txt", O_RDONLY, 0);
	if( -1 == handle)
	{
		printf("Error Creating File\n");
		exit(-1);
     }
	printf("Enter Record Number :");
	scanf("%d", &pos);
	
	pos = (pos - 1) * sizeof(p);
	lseek(handle, (long) -44, 2);

	res = lseek(handle, (long)0, 1);
	printf("Position is %d\n\n", res);

	if(sizeof(p) == read(handle, &p, sizeof(p)))
		printf("%s %s %d\n", p.cName, p.cAddr, p.nAge);
	else
		printf("Read Unsuccessful\n");
	close(handle); /* close the file */
	return 0;
} 
