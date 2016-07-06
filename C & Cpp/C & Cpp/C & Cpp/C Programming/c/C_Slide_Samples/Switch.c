/*******************************************************************
SourceName         : Switch.c                                       

Description        : switch statment. 
*******************************************************************/
#include <stdio.h>

int main()
{
	int month = 2, days;
	switch ( month ) 
	{
		case 2:	/* February	*/
			days = 28 ;
			break ;
		case 4:	 /* April */
		case 6:	 /* June	*/
		case 9:	 /* September	*/
		case 11: /* November	*/
			days = 30 ;
			break ;
		default:
			/* All the rest have 31 ...*/
			days = 31 ;
	}
	printf ("There are %d days. \n ", days ) ;
	return 0;
}
