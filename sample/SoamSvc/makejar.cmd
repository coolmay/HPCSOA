@echo off
setlocal

set JAVA_HOME=%ProgramFiles%\Java\jdk1.6.0_45
set CXF_HOME=c:\java\apache-cxf-2.4.0
set SOA_HOME=D:\HPCSOA\SoamSvcHost
set CLASSPATH=.;%SOA_HOME%\Microsoft-HpcSession-3.0.jar;%SOA_HOME%\jackson-all-1.9.0.jar;%CXF_HOME%\lib\cxf-manifest.jar;
set JAVAC="%JAVA_HOME%\bin\javac.exe"

cd src

FOR /F %%i IN ('dir /b/s *.java') DO %javac% -Djava.endorsed.dirs="%CXF_HOME%\lib\endorsed" %%i

"%JAVA_HOME%\bin\jar.exe" cvfm ..\SoamSvc.jar manifestecho org com sample

copy /Y ..\SoamSvc.jar %SOA_HOME%
