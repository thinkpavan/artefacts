#include <stdio.h>

typedef struct
{
	int hh;
	int mm;
	int ss;
} Time;

Time Input()
{
	Time x;
	printf("Enter Hour: ");
	scanf("%d", &x.hh);

	printf("Enter Minute: ");
	scanf("%d", &x.mm);

	printf("Enter Second");
	scanf("%d", &x.ss);
	return x;
}
void Print(Time z)
{
	printf("%d:%d:%d\n", z.hh, z.mm, z.ss);
}
int main()
{
	Time Now;
	Now = Input();
	Print(Now);
	return 0;
} 


















