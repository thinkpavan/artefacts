

#include "stdafx.h"

	HWND hWnd1,hWnd2,hWnd3,hWnd4; //hwnd is a handle to the window

LRESULT CALLBACK EventProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{

	int wmId, wmEvent;
	PAINTSTRUCT ps;
	HDC hdc;
	TCHAR szHello[]="Hello World";
	switch (message) 
	{
		case WM_COMMAND:
			wmId    = LOWORD(wParam); 
			wmEvent = HIWORD(wParam); 
			// Parse the menu selections:
			switch (wmId)
			{
				case 1:
				  // DialogBox(hInst, (LPCTSTR)IDD_ABOUTBOX, hWnd, (DLGPROC)About);
				   break;
				case 2:
				   DestroyWindow(hWnd);
				   break;
				default:
				   return DefWindowProc(hWnd, message, wParam, lParam);
			}
			break;
		case WM_PAINT:
			hdc = BeginPaint(hWnd, &ps);
			// TODO: Add any drawing code here...
			RECT rt;
			GetClientRect(hWnd, &rt);
			if(hWnd == hWnd1)
			DrawText(hdc, szHello, strlen(szHello), &rt, DT_CENTER);
			if(hWnd == hWnd2)
			DrawText(hdc,"Window  Two",12, &rt, DT_CENTER);
		//	if(hWnd == hWnd3)
		//	DrawText(hdc,"my button", 10, &rt, DT_CENTER);
			EndPaint(hWnd, &ps);
			break;
		case WM_DESTROY:
			if(hWnd == hWnd1)
			PostQuitMessage(0);
			else
				return DefWindowProc(hWnd, message, wParam, lParam);
			break;
		default:
			return DefWindowProc(hWnd, message, wParam, lParam);
   }
   return 0;
}

int APIENTRY WinMain(HINSTANCE hInstance,
                     HINSTANCE hPrevInstance,
                     LPSTR     lpCmdLine,
                     int       nCmdShow)
{
 	// TODO: Place code here.
		MSG msg;


	WNDCLASSEX wcl; // type of window we want to display
	TCHAR szWindowClass[100]="INetSOlv";

	wcl.cbSize = sizeof(WNDCLASSEX); 

	wcl.style			= CS_HREDRAW | CS_VREDRAW;
	wcl.lpfnWndProc	= (WNDPROC)EventProc;
	wcl.cbClsExtra		= 0;
	wcl.cbWndExtra		= 0;
	wcl.hInstance		= hInstance;
	//wcl.hIcon			= LoadIcon(hInstance, (LPCTSTR)IDI_WINAPP);
	wcl.hIcon			= NULL;
	wcl.hCursor		= LoadCursor(NULL, IDC_ARROW);
	wcl.hbrBackground	= (HBRUSH)(COLOR_WINDOW+1);
//	wcl.lpszMenuName	= (LPCSTR)IDC_WINAPP;
	wcl.lpszMenuName	= NULL;
	wcl.lpszClassName	= "INetSOlv";
//	wcl.hIconSm		= LoadIcon(wcl.hInstance, (LPCTSTR)IDI_SMALL);
		wcl.hIconSm		= NULL;

	RegisterClassEx(&wcl);

	// once after registering a window we can show window

	hWnd1 = CreateWindow(szWindowClass, "WinAPP", WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, 0, CW_USEDEFAULT, 0, NULL, NULL, hInstance, NULL);
		hWnd2 = CreateWindow(szWindowClass, "WinAPP22222", WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, 0, CW_USEDEFAULT, 0, NULL, NULL, hInstance, NULL);
	
	hWnd3 = CreateWindow("button", "Button", BS_AUTOCHECKBOX,
      CW_USEDEFAULT, 0,20, 60, hWnd2, NULL, hInstance, NULL);
	
	hWnd4 = CreateWindow("button", "Button 2", BS_PUSHBUTTON,
      CW_USEDEFAULT, 0,20, 60, hWnd2, NULL, hInstance, NULL);
	

   ShowWindow(hWnd1, nCmdShow);
    ShowWindow(hWnd2, nCmdShow);
	ShowWindow(hWnd3, nCmdShow);
	ShowWindow(hWnd4, nCmdShow);
  // UpdateWindow(hWnd);

	while (GetMessage(&msg, NULL, 0, 0)) 
	{
			TranslateMessage(&msg);
			DispatchMessage(&msg);
	
	}
	return 0;
}



