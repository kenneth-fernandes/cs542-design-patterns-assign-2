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
1. Assumption:
- The input.txt file is well formatted with the numbers of integers and floating point numbers.
- If the lines in a file do not have a line, then the next number on next line would be processed.
- Each number is on one line.
- Absoulte path of the files to be passed as input arguments while executing the program.
- Input arguments to the run command are in the order input.txt file path, metrics calculated result files path.

2. Data Structures:
- List<Integer> - Used for storing the numbers for calculating the running average.
- List<Double> - Used for storing the Top K Numbers.
- List<ObserverI> - Used th objects of the observers.
- HashMap<FilterI, List<ObserverI>> - Used for storing the List of Observers pertaining to the event in the form of FilterI

3. External Materials:
- Used Collection.sort() for sorting the ArrayList while retrieving the Top K numbers.

4. Compiling:
- Follow the instructions as mentioned above.

5. Execute Program:
- Follow the instruction as mentioned above.

6. Code Working:
- First the inputs are read from command line and validated for any missing or invalid values.
- An Input Paramter class holds the values of the input parameters.
- The Observers are registered based on the requirement.
- Number is read from the file, line by line, ignoring empty lines.
- The Observers are notified based on the event filter and internally the calls the update() of the observer to execute the metrics calculation
- Once, all the processing is done, the processing complete event is triggered and the output is written to the respective files.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [02/13/2020]


