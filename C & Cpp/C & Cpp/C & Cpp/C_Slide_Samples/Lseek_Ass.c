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
	handle = open("A.Txt", O_RDWR, 0);
	if( -1 == handle)
	{
		printf("Error Creating File\n");
		exit(-1);
     }
	printf("Enter Record Number :");
	scanf("%d", &pos);
	
	pos = (pos - 1) * sizeof(p);
	lseek(handle, (long) pos, 0);

	fflush(stdin);
	printf("Enter Name :");
	scanf("%s", (p.cName)); 
	
	printf("Enter Address:");
	scanf("%s", (p.cAddr));
	printf("Enter Age :");
	scanf("%d", &(p.nAge));

	if(sizeof(p) == write(handle, &p, sizeof(p)))
		printf("Write Successful\n\n");
	else
		printf("Write Unsuccessful\n");


	lseek(handle, (long) 0, 0);
	while (read(handle, &p, sizeof(p)))
	{
		printf("%s %s %d\n", p.cName, p.cAddr, p.nAge);
	}
	close(handle); /* close the file */
	return 0;
} 
