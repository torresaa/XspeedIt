#!/bin/sh
THE_CLASSPATH=
PROGRAM_NAME=PackingOptimizer.java
find . -name "*.java" > sources.txt

for i in `ls lib/*.jar`
  do
  THE_CLASSPATH=${THE_CLASSPATH}:${i}
done

mkdir ./classes
javac -classpath ".:${THE_CLASSPATH}" -d "./classes" @sources.txt

if [ $? -eq 0 ]
then
  echo "Compilation completed!"
  rm -f sources.txt
fi