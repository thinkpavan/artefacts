// natdll1.cpp : Defines the entry point for the DLL application.
//

#include "stdafx.h"

BOOL APIENTRY DllMain( HANDLE hModule, 
                       DWORD  ul_reason_for_call, 
                       LPVOID lpReserved
					 )
{
    return TRUE;
}

JNIEXPORT jint JNICALL Java_NativeClass_retint
(JNIEnv * jenv, jobject jobj){
		jint i,j=44;
		// get the class object on which the method has to be called
		jclass cls = jenv->GetObjectClass(jobj);
		// get the metho id of the method to be called
		jmethodID metid = jenv->GetMethodID(cls, "methodCalledbyNM", "(I)V");
		if (metid == 0)
				return 0;
		printf("before calling java method");
	jenv->CallVoidMethod(jobj, metid,j);
			printf("After calling java method");
		return(i);
		// find the bug ???
}