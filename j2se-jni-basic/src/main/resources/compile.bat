
set PROJECT_HOME=.
set HEAD_FILE_NAME=org_hippo_sample_j2se_jni_MyJni.h
set CPP_FILE_NAME=org_hippo_sample_j2se_jni_MyJni.cpp
set DLL_FILE_NAME=myjni.dll
set SOURCE_DIR=%PROJECT_HOME%\src\main\c
set COMPILE_DIR=%PROJECT_HOME%\target\classes


# Copy library head file to taget dir
copy %JAVA_HOME%\include\jni.h %COMPILE_DIR%\
copy %JAVA_HOME%\include\win32\jni_md.h %COMPILE_DIR%\
# Copy source file to target dir
copy %SOURCE_DIR%\%HEAD_FILE_NAME% %COMPILE_DIR%\
copy %SOURCE_DIR%\%CPP_FILE_NAME% %COMPILE_DIR%\

# Use gcc to compile dll
gcc -Wall -D_JNI_IMPLEMENATION_ -Wl,--kill-at -shared -o %COMPILE_DIR%\%DLL_FILE_NAME% %COMPILE_DIR%\%CPP_FILE%

# Delete the temproray file
del %COMPILE_DIR%\jni.h %COMPILE_DIR%\jni_md.h
del %COMPILE_DIR%\%CPP_FILE% %COMPILE_DIR%\%HEAD_FILE_NAME%
