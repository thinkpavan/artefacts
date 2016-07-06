/*******************************************************************
SourceName			: Pointer1.c, 
	
Description			: Structure as parameter to function
*******************************************************************/
#include <stdio.h>
typedef struct
{
	char name[20];
	float total;
	char grade;
}student_record;

void print_record(student_record s)
{
	printf("Name: %s\n", s.name);
	printf("Numerical Grade: %f\n", s.total);
	printf("Letter Grade: %c\n", s.grade);
}

int main()
{
	student_record s = {"Rahul", 99.5, 'A'};
	print_record(s);
	return 0;
}