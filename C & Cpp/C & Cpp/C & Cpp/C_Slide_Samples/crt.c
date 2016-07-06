#include <stdio.h>
#include <malloc.h>
#include <crtdbg.h>

int main()
{
	int* p = malloc(10 * sizeof(*p));

	int tmpDbgFlag;
	tmpDbgFlag = _CrtSetDbgFlag(_CRTDBG_REPORT_FLAG);
        tmpDbgFlag |= _CRTDBG_DELAY_FREE_MEM_DF;
        tmpDbgFlag |= _CRTDBG_LEAK_CHECK_DF;
        _CrtSetDbgFlag(tmpDbgFlag);


	free(p);
}
