# XspeedIt
-----------
Implémenter un algorithme qui permettrait de maximiser le nombre d'articles par carton, en utilisant un langage pouvant être exécuté sur une JVM 1.7 minimum ou en node.js.

## REQUIREMENTS
------------
- JDK7 at least must be installed
- JDK7 should have all the configuration updated (JAVA_HOME should exist, commands "java" and "javac" should work)
	
## INSTRUCTIONS:
------------
* 	Clone the repository
		```
		git clone https://github.com/torresaa/XspeedIt.git
		```
*	Compile the project using the install.sh script
		```
		sh install.sh
		```
*	Run the project using the run.sh scrip
		```
		sh run.sh
		```
    - If no argument is specified, the program will ask to type the entry chain: 
        ```
			sh run.sh
			Please, enter a valid input chain:
		```
	- Arguments can be:
	    ```
			<chain of integers>    Entry chain. Ex. 163841689525773
    		test                   Run JUnit test.
    	```
* Run the Unit Test:
    	``` 
		sh run.sh test
		```

## INFORMATION: 
------------
The project contains the Java classes in order to be checked if needed. The .java files can be found under directories src and test.
	
## SOLUTION ALGORITHM:
-------------------
In order to maximize the number of articles by box, I implemented the dynamic algorithm mostly used to solve the BoundedKnapsackProblem (BKP) [https://fr.wikipedia.org/wiki/Problème_du_sac_à_dos]. In fact, this use case can be considered as a BKP where Values and Weights for each article in the input chains are the same.  