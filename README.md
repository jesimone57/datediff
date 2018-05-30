# Coding Exercise
# Calculate the Difference, in Days, Between Any Two Dates

jesimone57, 6 June 2017

### Description
* Create an application that can read in pairs of dates in the following format:
<pre>
		DD MM YYYY, DD MM YYYY
</pre>

* Validate the input data, and compute the difference between the two dates in days.

* Output of the application should be of the form:
<pre>
		DD MM YYYY, DD MM YYYY, difference
</pre>

* Where the first date is the earliest, the second date is the latest and the difference is the number of days.
* Input can be from a file, or from standard input, as the developer chooses.
* Provide test data to exercise the application.

### Constraints
The application may not make use of the Java libraries for date manipulation (for example Date, Calendar classes).
The application can limit calculation on an input range of dates from 1900 to 2010

### Usage Notes
1. Blank or empty lines in the input file are ignored.
2. Dates my be entered in either order (earlier,later or later,earlier) and the code will automatically handle them.
3. All the answers can be verified at [https://www.wolframalpha.com/](https://www.wolframalpha.com/).  For example you
can enter the following: difference in days between jan 1 2000 and march 7 2001. The correct result of 431 will be displayed.
4. The text file dates.txt, located in the root directory of the project, contains the default input file for this application.
5. The main java application file is DateDiff.java.
6. You can supply DateDiff with the name of the dates file as an argument to the program.

### How To Excecute the Code
1. git clone https://github.com/jesimone57/datediff.git
2. gradlew clean build test
3. gradlew run

### Sample Input (from the file dates.txt)
<pre>
# this is a comment line
01 01 2000, 07 03 2001
02 04 1975, 04 09 1987 
05 06 1929, 17 05 1944
01 01 2000, 07 03 2000
01 01 2000, 01 01 2010

# same as above, but with the dates reversed
07 03 2001, 01 01 2000  
04 09 1987, 02 04 1975  
17 05 1944, 05 06 1929  
07 03 2000, 01 01 2000  
01 01 2010, 01 01 2000

# Days between JFK assassination of Nov 22, 1963 and the Bobby Kennedy assassination on June 5, 1968
22 11 1963, 05 06 1968

# Days between start of World War II on September 1, 1939 and its end on September 2, 1945
1 9 1939, 2 9 1945

# Days between start of World War I on July 28, 1914 and its end on November 11, 1918
28 7 1914, 11 11 1918

# Days between the start of American war of independence on Apr 19, 1775 and its end on Sept 3, 1783
19 4 1775, 3 9 1783

# Days between the start of American civil war on Apr 12, 1861 and its end on May 9, 1865
12 4 1861, 9 5 1865

# Days between the start of queen Victoria's reign on 20 June 1837 and the end, at her death, on 22 January 1901
20 6 1837, 22 1 1901

# Duration of Apollo 11 mission from launch on July 16, 1969 to return landing on July 24, 1969
16 7 1969, 24 7 1969

# Number of days for the 50th anniversary of Beatles Sgt. Pepper album release on June 1, 1967 until June 1, 2017
1 6 1967, 1 6 2017

# Number of days for the 2017 Atlantic Hurricane Season from June 1, 2017 through Nov 30, 2017
1 6 2017, 30 11 2017

# Duration of Barack Obama's presidency from start of January 20, 2009 until end of his 2nd presidential term on January 20, 2017
20 1 2009, 20 1 2017
</pre>

### Sample Output (from the file dates.txt)
<pre>
Current Working Directory: /Users/jsimone/eclipse/workspace/datediff
Input file: /Users/jsimone/eclipse/workspace/datediff/dates.txt
01 01 2000, 07 03 2001, 431
02 04 1975, 04 09 1987, 4538
05 06 1929, 17 05 1944, 5460
01 01 2000, 07 03 2000, 66
01 01 2000, 01 01 2010, 3653
01 01 2000, 07 03 2001, 431
02 04 1975, 04 09 1987, 4538
05 06 1929, 17 05 1944, 5460
01 01 2000, 07 03 2000, 66
01 01 2000, 01 01 2010, 3653
22 11 1963, 05 06 1968, 1657
01 09 1939, 02 09 1945, 2193
28 07 1914, 11 11 1918, 1567
19 04 1775, 03 09 1783, 3059
12 04 1861, 09 05 1865, 1488
20 06 1837, 22 01 1901, 23226
16 07 1969, 24 07 1969, 8
01 06 1967, 01 06 2017, 18263
01 06 2017, 30 11 2017, 182
20 01 2009, 20 01 2017, 2922
</pre>
