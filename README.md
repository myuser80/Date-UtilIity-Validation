# Date-UtilIity-Validation

Problem Statement
=================
Using OOAD,OOPS  concepts, write  a java program that  : 
1)      Accepts an user input of date time in number format . 
2)      This input  has following  Pattern dd-mm-yyyy hh:mm:ss AM/PM 
3)      AM will be considered as Morning and PM will be considered as Evening 
4)      Validate the date and time correctness without using java api 
5)      In case of validation fails, print message invalid date time with input 
6)      Prints the word equivalent of date and time 
7)      Print the  day of the week for given input without using java api. 
8)      This program will not use Java Calendar,  LocalDatetime and Day of week api .It can use java util date api for date creation only.9)      Add junit test cases 
For example  
Input date time : 21-01-2021 06:07:10 AM  

Output: 	
Valid Date : 21st-Jan -Twenty Twenty One 
Valid Time : Six Hours Seven Minutes Ten Seconds - Morning 
Day of week : Thursday  

Please upload the assignment on github and share the url .

Solution
=========

Please Input the Date and Time in DD-MM-YYYY HH:MM:SS AM/PM Format
11-01-2021 04:47:110 PM
11-01-2021
04:47:110
PM
Valid Date: 11-01-2021
Day of the week: Monday
Invalid time 04:47:110 Evening //seconds invalid
Leap year check true

Pleae see source attached.

Test Cases
=========
ValidDateCheck by AM / PM / Day , Month  Year 
Valid Time Check by HH MM SS AM /PM
findaDayofWeek 
DatetoWords

Test Results
=================

Valid Date : one JAN two thousand and twenty one
Valid Date : two FEB two thousand and twenty one
Valid Date : three MAR two thousand and twenty one
Valid Date : four APR two thousand and twenty one
Valid Date : five MAY two thousand and twenty one
Valid Date : six JUN two thousand and twenty one
Valid Date : seven JUL two thousand and twenty one
Valid Date : eight AUG two thousand and twenty one
Valid Date : nine JAN two thousand and twenty one
Valid Date : ten JAN two thousand and twenty one
Valid Date : one JAN two thousand and twenty one
Valid Date : one JAN two thousand and twenty one
Valid Date : one JAN two thousand and twenty one
Valid Date : one JAN two thousand and twenty one
Valid Date : one JAN two thousand and twenty one
Valid Date : one JAN two thousand and twenty one
Valid time Six Hours Seven MinutesTen Seoncds Morning
Valid time Zero Hours Seven MinutesTen Seoncds Morning
Valid time Eleven Hours Seven MinutesTen Seoncds Morning
Valid time One Hours Twenty nine MinutesTwenty three Seoncds Morning
Invalid time23:57:59 Morning
Valid time One Hours Seven MinutesTen Seoncds Morning
Valid time Two Hours Seven MinutesTen Seoncds Morning
Valid time Seventeen Hours Seven Minutes  Ten Seoncds Evening
Valid time Fifteen Hours Twenty nine Minutes  Twenty three Seoncds Evening
Invalid time23:57:59 Morning
Valid time Sixteen Hours Seven Minutes  Ten Seoncds Evening
Invalid time 01:07:10 Evening
InValid time 25:07:10 Morning
InValid time 17:67:10 Evening
InValid time 15:29:110 Evening
Invalid time21:09:59 Morning
Invalid time16:07:10 Morning
InValid time 25:07:10 Morning
Valid time Twenty four Hours Seven Minutes  Ten Seoncds Morning
twenty five JAN two thousand and twenty one

