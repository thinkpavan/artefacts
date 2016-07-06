#include <stdio.h>

void f11()
{
	printf("f11\n");
}

void f12()
{
	printf("f12\n");
}
void f13()
{
	printf("f13\n");
}

void f21()
{
	printf("f21\n");
}
void f22()
{
	printf("f22\n");
}
void f23()
{
	printf("f23\n");
}

int main()
{
	int maincounter =1;
	int subcounter = 2;
	void (*f1[])() = {f11, f12, f13};
	void (*f2[])() = {f21, f22, f23};
	void (**f[])() = {f1, f2};
	(*(*(*(f+maincounter) + subcounter)))();
	return 0;
}

	