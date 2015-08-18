#!/bin/sh

export JAVA_HOME=/usr/java/jdk1.6.0_45
export CXF_HOME=/opt/apache-cxf-2.4.0
export SOA_HOME=/soa/SoamSvcHostLinux
export CLASSPATH=.:$SOA_HOME/Microsoft-HpcSession-3.0.jar:$SOA_HOME/jackson-all-1.9.0.jar:$CXF_HOME/lib/cxf-manifest.jar

cd src

find . -name *.java -print | xargs javac  -Djava.endorsed.dirs="$CXF_HOME/lib/endorsed" 

jar cvfm ../SoamSvc.jar manifestecho_linux org com sample

cp -f ../SoamSvc.jar $SOA_HOME

cd ..
