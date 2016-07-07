// natdll.cpp : Defines the entry point for the DLL application.
//

#include "stdafx.h"

BOOL APIENTRY DllMain( HANDLE hModule, 
                       DWORD  ul_reason_for_call, 
                       LPVOID lpReserved
					 )
{
    return TRUE;
}


JNIEXPORT void JNICALL Java_NativeClass_donothing
(JNIEnv * jenv, jobject jobj){
	printf("result of do nothing\n");
}
