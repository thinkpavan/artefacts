/*******************************************************************

SourceName         : Write.c                                       

Description        : This program demonstrates the use of 
                     creat, write and close function. 
*******************************************************************/

#include <sys/types.h>
#include <sys/stat.h>
#include <io.h>
#include <fcntl.h>

#include <stdio.h>

#include <stdlib.h>

#include <string.h>


int main(void)
{
	char buf[] = "Sentence to be written in file";
	int handle = 0, len = strlen(buf);
	handle = creat("A.Txt", O_WRONLY | _S_IREAD | _S_IWRITE);
	printf("Handle = %d\n", handle);
	if( -1 == handle)
	{
		printf("Error Creating File\n");
		exit(-1);
	}
	
	if(len == write(handle, buf, len)) /* write Date to the file */
	{
		printf("Wrote %d Byte\n", len);
	}
	else
	{
		printf("Unsuccessful in writing\n");
	}
	close(handle); /* close the file */
	return 0;
}
