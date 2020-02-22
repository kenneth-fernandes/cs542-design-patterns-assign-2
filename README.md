# CS542: Assignment 2
## Name: Kenneth Peter Fernandes 

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in numberPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

```commandline
ant -buildfile numberPlay/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

```commandline
ant -buildfile numberPlay/src/build.xml all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

#### Use the below command to run the program.

```commandline
ant run -buildfile numberPlay/src/build.xml \
-DinputNumStream="inputFile/input.txt" \
-DrunAvgWindowSize=3 \
-DrunAvgOutFile="src/BUILD/resultFiles/run-avg-out.txt" \
-Dk=3 \
-DtopKNumOutFile="src/BUILD/resultFiles/top-k-out.txt" \
-DnumPeaksOutFile="src/BUILD/resultFiles/peaks-out.txt"
```

-----------------------------------------------------------------------
## Description:


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [02/13/2020]


