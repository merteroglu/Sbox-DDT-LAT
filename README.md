# S-Box & LAT & DDT

## Usage

1. Select S-Box creation mode
2. If selection is auto ; 
    * Choose the function
    * Choose the mapping
3. If selection is manual ;
    * Enter the bit size (4 bits 16 digits)
    * Enter the S-Box values. (Copy from simple.txt and paste all to console)


## Sample

~~~
0 - Create S-Box Manual

1 - Create S-Box Auto

Selection : 1
~~~

~~~
0 - (x^4) + x + 1

1 - (x^4) + (x^3) + 1

2 - (x^4) + (x^3) + (x^2) + x + 1

Enter the select : 0
~~~

~~~
Mapping x -> x^? : -2
x^1 -> x^13
x^2 -> x^11
x^3 -> x^9
x^4 -> x^7
x^5 -> x^5
x^6 -> x^3
x^7 -> x^1
x^8 -> x^14
x^9 -> x^12
x^10 -> x^10
x^11 -> x^8
x^12 -> x^6
x^13 -> x^4
x^14 -> x^2
x^15 -> x^0
~~~~

~~~

S-Box

0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f  

0  1  d  b  e  9  6  7  a  4  f  2  8  3  5  c  

~~~


~~~
---- LAT ---- 

8	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
0	2	0	-2	-2	4	2	4	-2	0	2	0	0	-2	0	2	
0	2	2	0	4	-2	2	0	0	-2	2	4	0	-2	-2	0	
0	4	-2	2	2	2	0	0	-2	-2	0	0	0	4	2	-2	
0	0	0	0	2	2	-2	-2	0	4	4	0	2	-2	2	-2	
0	-2	0	2	0	2	0	-2	-2	0	-2	4	2	0	2	4	
0	2	2	0	-2	0	0	-2	4	-2	2	0	-2	0	4	2	
0	0	-2	-2	4	0	-2	2	2	2	0	0	-2	2	0	4	
0	-2	0	-2	0	-2	4	2	0	2	0	2	0	2	4	-2	
0	4	0	0	-2	-2	-2	2	2	2	-2	2	4	0	0	0	
0	0	2	-2	0	0	2	-2	0	0	2	-2	4	4	-2	2	
0	-2	-2	4	-2	0	0	2	2	0	4	2	0	2	-2	0	
0	-2	4	2	2	0	-2	4	0	-2	0	-2	2	0	2	0	
0	0	4	0	0	4	0	0	2	2	-2	2	-2	2	-2	-2	
0	0	-2	2	2	2	4	0	4	0	-2	-2	2	-2	0	0	
0	2	2	4	0	-2	2	0	-2	4	0	-2	-2	0	0	2	


NLM : 4


NLMmax : 6.0


NLM Percent : %66
~~~


~~~
 ---- DDT ---- 

16	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
0	4	0	0	0	0	2	2	0	2	0	2	0	2	2	0	
0	0	0	0	0	2	2	0	2	0	2	0	0	4	2	2	
0	0	0	0	2	0	2	0	2	2	0	4	2	0	0	2	
0	0	2	0	0	0	0	2	2	0	2	2	2	0	4	0	
0	0	0	2	0	0	0	2	0	4	2	0	2	2	0	2	
0	2	2	2	0	0	4	2	2	0	0	0	0	0	0	2	
0	2	0	0	2	2	2	4	0	0	2	0	2	0	0	0	
0	0	2	2	0	2	2	0	0	2	4	2	0	0	0	0	
0	2	2	0	4	0	0	0	0	0	2	2	0	2	0	2	
0	0	0	2	2	2	0	2	0	0	0	2	0	0	2	4	
0	2	4	0	0	2	0	0	0	2	0	0	2	0	2	2	
0	0	2	0	2	2	0	2	4	2	0	0	0	2	0	0	
0	2	0	4	2	0	0	0	2	2	2	0	0	0	2	0	
0	2	0	2	0	4	0	0	2	0	0	2	2	2	0	0	
0	0	2	2	2	0	2	0	0	0	0	0	4	2	2	0	

~~~

