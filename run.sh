#!/bin/sh
THE_CLASSPATH=classes/
PROGRAM_NAME=PackingOptimizer.java

for i in `ls lib/*.jar`
  do
  THE_CLASSPATH=${THE_CLASSPATH}:${i}
done

java -classpath ".:${THE_CLASSPATH}" com.xspeedit.packing.PackingOptimizer $1

if [ $? -eq 0 ]
then
  echo "Operation completed!"
fi