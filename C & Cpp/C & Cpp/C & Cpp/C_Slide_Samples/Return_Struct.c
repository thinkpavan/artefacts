/*******************************************************************
SourceName			: Pointer1.c, 
	
Description			: Return a structure from a function
*******************************************************************/
#include <stdio.h>
typedef struct
{
	int hh, mm, ss;
} Time;

Time GetSystemTime()
{
	Time t;
	/* Do some processing and get time in t */
	
	t.hh = 10;
	t.mm = 45;
	t.ss = 50;
	return(t);
}

int main()
{
	Time t;
	t = GetSystemTime();
	printf("Time is : %d:%d:%d\n", t.hh, t.mm, t.ss);
	return 0;
}