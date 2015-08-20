#!/bin/sh

export JAVA_HOME=/usr/java/jdk1.6.0_45
export CXF_HOME=/opt/apache-cxf-2.4.0
export SOA_HOME=/soa/SoamSvcHostLinux
export CLASSPATH=.:$SOA_HOME/jackson-all-1.9.0.jar:$SOA_HOME/HpcSoam.jar:$CXF_HOME/lib/cxf-manifest.jar


find . -name *.java -print | xargs javac  -Djava.endorsed.dirs="$CXF_HOME/lib/endorsed" 

jar cvfm SampleService.jar manifest_linux sample

cp -f SampleService.jar $SOA_HOME


