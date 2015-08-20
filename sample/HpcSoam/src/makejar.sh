#!/bin/sh

export JAVA_HOME=/usr/java/jdk1.6.0_45
export CXF_HOME=/opt/apache-cxf-2.4.0
export SOA_HOME=/soa/SoamSvcHostLinux
export CLASSPATH=.


find . -name *.java -print | xargs javac  -Djava.endorsed.dirs="$CXF_HOME/lib/endorsed" 

jar cvfm HpcSoam.jar manifest_linux com

cp -f HpcSoam.jar $SOA_HOME


