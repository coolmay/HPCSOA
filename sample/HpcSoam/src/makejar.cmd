@echo off
setlocal

set JAVA_HOME=%ProgramFiles%\Java\jdk1.6.0_45
set CXF_HOME=c:\java\apache-cxf-2.4.0
set SOA_HOME=D:\HPCSOA\SoamSvcHost
set CLASSPATH=.
set JAVAC="%JAVA_HOME%\bin\javac.exe"


FOR /F %%i IN ('dir /b/s *.java') DO %javac% -Djava.endorsed.dirs="%CXF_HOME%\lib\endorsed" %%i

"%JAVA_HOME%\bin\jar.exe" cvfm HpcSoam.jar manifest com

copy /Y HpcSoam.jar %SOA_HOME%
