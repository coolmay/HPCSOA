@echo off

set SRC_ROOT=D:\SOAJava

cd %SRC_ROOT%/HpcServiceHost/src
makejar.cmd

cd %SRC_ROOT%/sample/HpcSoam/src
makejar.cmd

cd %SRC_ROOT%/sample/HpcSoamSvc/src
makejar.cmd

cd %SRC_ROOT%/sample/SampleService/src
makejar.cmd

cd %SRC_ROOT%/sample/SampleClient/src
RunTest.cmd src

