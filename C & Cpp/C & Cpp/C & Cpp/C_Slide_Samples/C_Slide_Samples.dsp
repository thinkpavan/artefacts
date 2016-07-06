# Microsoft Developer Studio Project File - Name="C_Slide_Samples" - Package Owner=<4>
# Microsoft Developer Studio Generated Build File, Format Version 6.00
# ** DO NOT EDIT **

# TARGTYPE "Win32 (x86) Console Application" 0x0103

CFG=C_Slide_Samples - Win32 Debug
!MESSAGE This is not a valid makefile. To build this project using NMAKE,
!MESSAGE use the Export Makefile command and run
!MESSAGE 
!MESSAGE NMAKE /f "C_Slide_Samples.mak".
!MESSAGE 
!MESSAGE You can specify a configuration when running NMAKE
!MESSAGE by defining the macro CFG on the command line. For example:
!MESSAGE 
!MESSAGE NMAKE /f "C_Slide_Samples.mak" CFG="C_Slide_Samples - Win32 Debug"
!MESSAGE 
!MESSAGE Possible choices for configuration are:
!MESSAGE 
!MESSAGE "C_Slide_Samples - Win32 Release" (based on "Win32 (x86) Console Application")
!MESSAGE "C_Slide_Samples - Win32 Debug" (based on "Win32 (x86) Console Application")
!MESSAGE 

# Begin Project
# PROP AllowPerConfigDependencies 0
# PROP Scc_ProjName ""
# PROP Scc_LocalPath ""
CPP=cl.exe
RSC=rc.exe

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 0
# PROP BASE Output_Dir "Release"
# PROP BASE Intermediate_Dir "Release"
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 0
# PROP Output_Dir "Release"
# PROP Intermediate_Dir "Release"
# PROP Target_Dir ""
# ADD BASE CPP /nologo /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_CONSOLE" /D "_MBCS" /YX /FD /c
# ADD CPP /nologo /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_CONSOLE" /D "_MBCS" /YX /FD /c
# ADD BASE RSC /l 0x409 /d "NDEBUG"
# ADD RSC /l 0x409 /d "NDEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
LINK32=link.exe
# ADD BASE LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /subsystem:console /machine:I386
# ADD LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /subsystem:console /machine:I386

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 1
# PROP BASE Output_Dir "Debug"
# PROP BASE Intermediate_Dir "Debug"
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 1
# PROP Output_Dir "Debug"
# PROP Intermediate_Dir "Debug"
# PROP Target_Dir ""
# ADD BASE CPP /nologo /W3 /Gm /GX /ZI /Od /D "WIN32" /D "_DEBUG" /D "_CONSOLE" /D "_MBCS" /YX /FD /GZ /c
# ADD CPP /nologo /W3 /Gm /GX /ZI /Od /D "WIN32" /D "_DEBUG" /D "_CONSOLE" /D "_MBCS" /YX /FD /GZ /c
# ADD BASE RSC /l 0x409 /d "_DEBUG"
# ADD RSC /l 0x409 /d "_DEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
LINK32=link.exe
# ADD BASE LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /subsystem:console /debug /machine:I386 /pdbtype:sept
# ADD LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /subsystem:console /debug /machine:I386 /pdbtype:sept

!ENDIF 

# Begin Target

# Name "C_Slide_Samples - Win32 Release"
# Name "C_Slide_Samples - Win32 Debug"
# Begin Group "Source Files"

# PROP Default_Filter "cpp;c;cxx;rc;def;r;odl;idl;hpj;bat"
# Begin Source File

SOURCE=.\Addition.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Array1.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Array2.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Binary2.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Binary3.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Binary4.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Boolean.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Break_Cont.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Buf_Read.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Buf_Write.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Check.cpp

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\CommandLine.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Conditional_Com.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\crt.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Debug.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Do.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Extern1.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Extern2.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\fflush.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\First.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\For.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Fread.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Fseek.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Fun_Ass.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Function.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Fwrite.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\If.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Inc_Dec.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\InputString.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Lseek.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Lseek_Ass.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Macro.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Macro_Problem.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\MyLib.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Open.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Operator_Precedence.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\OurMain.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer1.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer10.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer11.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer2.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer3.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer4.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer5.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer6.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer7.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer8.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer9.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Pointer_Ass.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Read.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Read_Struct.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Relational.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Return_Struct.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Static.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Struct_Ass.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Struct_Fun.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Switch.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Ternary.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\va_args.C
# End Source File
# Begin Source File

SOURCE=.\While.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Write.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# Begin Source File

SOURCE=.\Write_Struct.c

!IF  "$(CFG)" == "C_Slide_Samples - Win32 Release"

!ELSEIF  "$(CFG)" == "C_Slide_Samples - Win32 Debug"

# PROP Exclude_From_Build 1

!ENDIF 

# End Source File
# End Group
# Begin Group "Header Files"

# PROP Default_Filter "h;hpp;hxx;hm;inl"
# Begin Source File

SOURCE=.\MyLib.h
# End Source File
# End Group
# Begin Group "Resource Files"

# PROP Default_Filter "ico;cur;bmp;dlg;rc2;rct;bin;rgs;gif;jpg;jpeg;jpe"
# End Group
# End Target
# End Project
