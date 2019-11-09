 find . -name "*.java" > sources.txt
 javac -sourcepath . @sources.txt
 java Avaj/AvajMain/Main scenario.txt