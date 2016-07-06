/*******************************************************************

SourceName			: Extern1.c

Dependency			: Extern2.c  

Description			: extern keyword 
*******************************************************************/
#include <stdio.h>

extern int x;	/* Declaration of x. Memory not allocated*/
void SetValue();

int main()
{
	SetValue();
	printf("Now x is :%d\n", x);
	return 0;
}
