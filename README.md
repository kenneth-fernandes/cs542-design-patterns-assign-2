# CS542 - Design Patterns: Assignment 2
## Name: Kenneth Peter Fernandes 

-----------------------------------------------------------------------
Assignment Goal: Observe a stream of numbers and calculate different metrics.

The program accepts one input file. This input file contains integer and/or floating point numbers.
Each number read from the input file is passed to a NumberProcessor.
The NumberProcessor operates as indicated below, for each number received.
An event is triggered based on the data type of the number. Below are the possible events that can be triggered.
INTEGER_EVENT - Triggered if the number read is an integer.
FLOATING_POINT_EVENT - Triggered if the number read is a floating point number (float or double).
Based on the type of event triggered, the appropriate Observers are notified and the number is provided to them along with the notification.
Each Observer then carries out some operations using the provided number and stores the result of the operation.
Once all the numbers have been read in from the file, the NumberProcessor would trigger a PROCESSING_COMPLETE event and would notify all the observers. The observers, when notified of this event, should persist the results into the corresponding output files.
Observers

For this assignment, you are to write three observers. Below are the observers and the their respective responsibilities.

1. RunningAverageObserver
Running average is basically the average of the most recent W numbers, where W is the size of the window (a fixed size FIFO queue). See below example for better understanding.

Let 1,2,3,4,5,6,7 be the list of numbers to be processed.
Let the window size = 3.
Number processed = 1. Running average of [1] = 1.0
Number processed = 2. Running average average of [1,2] = 1.5
Number processed = 3. Running average of [1,2,3] = 2.0
Number processed = 4. Running average of [2,3,4] = 3.0
Number processed = 5. Running average of [3,4,5] = 4.0
Number processed = 6. Running average of [4,5,6] = 5.0
Number processed = 7. Running average of [5,6,7] = 6.0

The RunningAverageObserver is very particular about not losing precision and listens to INTEGER_EVENT updates. This is because addition of floating point numbers can result in loss of precision.
Each time this observer is notified, the new number read from the input file is provided.
The running average is then computed using the new number.
The size of the window for running average calculations is provided via the command-line argument -DrunAvgWindowSize (see README for usage information).
The calculated running average is then stored in the results.
The path of the file into which the results need to be persisted is provided via command-line argument -DrunAvgOutFile (see README for usage information).
Note: running averages can be rounded to two decimal places.
Challenge: Can you make each running average calculation a constant time operation?

2. TopKNumbersObserver
Top K numbers are the largest K numbers among all the numbers that have processed so far. See below example for better understanding.

Let 1, 2, 3.45, 4.6, 4.65, 6.8, 7 be the list of numbers to be processed.
Let k = 3.
Number processed = 1. Top k = [1.0]
Number processed = 2. Top k = [2.0, 1.0]
Number processed = 3.45. Top k = [3.45, 2.0, 1.0]
Number processed = 4.6. Top k = [4.6, 3.45, 2.0]
Number processed = 4.65. Top k = [4.65, 4.6, 3.45]
Number processed = 6.8. Top k = [6.8, 4.65, 4.6]
Number processed = 7. Top k = [7, 6.8, 4.65]

The TopKNumbersObserver does not mind floating point numbers and therefore listens to both INTEGER_EVENT and FLOATING_POINT_EVENT.

Tip - Use BigDecimal to compare the numbers as either floating points or doubles.
Question: What data structure would you use to compute the top k numbers?

Each time this observer is notified, the new number read from the input file is provided.
The top K numbers are then determined.
The value of K is provided via command-line argument -Dk (see README for usage information).
The top K numbers are then stored in the results.
The path of the file into which the results need to be persisted is provided via command-line argument -DtopKNumOutFile (see README for usage information).
Note: Numbers can be rounded to two decimal places before comparing.

3. NumberPeaksObserver
A number peak is the number just preceding a dip in the value of numbers being processed. See below example for better understanding.

Let 1, 2, 1.8, 2.2, 3, 3.45, 4.65, 4.6, 6.8, 7 be the list of numbers to be processed.
Number processed = 1. No peak yet as this is the first number.
Number processed = 2. No peak yet as 2 > 1.
Number processed = 1.8. Found a peak as 1.8 < 2. The peak is 2.
Number processed = 2.2. No peak yet as 2.2 > 1.8.
Number processed = 3. No peak yet as 3 > 2.2.
Number processed = 3.45. No peak yet as 3.45 > 3.
Number processed = 4.65. No peak yet as 4.65 > 3.45.
Number processed = 4.6. Found a peak as 4.6 < 4.65. The peak is 4.65
Number processed = 6.8. No peak yet as 6.8 > 4.6.
Number processed = 7. No peak yet as 7 > 6.8.

The NumberPeaksObserver does not mind floating point numbers and therefore listens to both INTEGER_EVENT and FLOATING_POINT_EVENT.

Tip - Use BigDecimal to compare the numbers as either floating points or doubles.

Each time this observer is notified, the new number read from the input file is provided.
Whether a peak was encountered or not is then determined.
If a peak was found, then the value of that peak is stored in results.
The path of the file into which the results need to be written is provided via command-line argument -DnumPeaksOutFile (see README for usage information).

Note: Numbers can be rounded to two decimal places before comparing.
Note: Only peaks need to be stored into results.
Note: All the observers should also be registered for PROCESSING_COMPLETE updates. Otherwise, they will not know when to persist the results to the output files.

The following rules MUST be followed.

The program should not read in all the numbers, store it in a data structure, and then process them.
An observer should be notified only when the corresponding event has been triggered. Use filters for this purpose.
INPUT FORMAT 

Your program should accept 6 arguments from the commandline. See README on Github for more information on these. 

-DinputNumStream - Input file path (string).
-DrunAvgWindowSize - Size of the window for running average calculations (integer). Must be > 0.
-DrunAvgOutFile - Name of the output file to which running averages are written (string).
-Dk - Max size of the list containing the top K numbers (integer). Must be > 0.
-DtopKNumOutFile - Name of the output file to which the top K numbers are written (string).
-DnumPeaksOutFile - Name of the output file to which the peaks in the number stream are written (string).
Note: Input file will be well formatted.

EXAMPLES 

Sample run command:
```
ant -buildfile numberPlay/src/build.xml run \
-DinputNumStream="input.txt" \
-DrunAvgWindowSize=3 \
-DrunAvgOutFile="run-avg-out.txt" \
-Dk=3 \
-DtopKNumOutFile="top-k-out.txt" \
-DnumPeaksOutFile="peaks-out.txt"
```
input.txt	
```
1
2
1.8
2
2.2
3
3.45
4
4.65
4.6
5
6
6.8
7
1
1.5
1.67
2.33
3
4
5
6
```
run-avg-out.txt
```
[1]
[2, 1]
[2, 1.8, 1]
[2, 2, 1.8]
[2.2, 2, 2]
[3, 2.2, 2]
[3.45, 3, 2.2]
[4, 3.45, 3]
[4.65, 4, 3.45]
[4.65, 4.6, 4]
[5, 4.65, 4.6]
[6, 5, 4.65]
[6.8, 6, 5]
[7, 6.8, 6]
```

top-k-out.txt	
```
2
```

peaks-out.txt
```
4.65
```
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


