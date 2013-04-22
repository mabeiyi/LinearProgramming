LinearProgramming
=================

Linear programming exercise using GLPK JAVA

Programming exercise.

See question from the .docx file.

How to run the app.

see instruction at http://glpk-java.sourceforge.net/gettingStarted.html

if you want to run it from eclipse, you should

1. right click java project, select "Run as", select "Run configuration"

2. select "(x)=Arguments" tab, enter following sentence:

-Djava.library.path="C:Program Files\GLPK\glpk-4.48\w32"

at VM argument

3. click apply and run it.

Then you will get out put like:

Problem created
GLPK Simplex Optimizer, v4.48
2 rows, 9 columns, 12 non-zeros
*     0: obj =  0.000000000e+000  infeas = 0.000e+000 (0)
*     8: obj =  9.790000000e+003  infeas = 0.000e+000 (0)
OPTIMAL SOLUTION FOUND
z = 9790.0
yin = 4.0
bin = 8.0
min = 5.0
ynb = 8.0
bnb = 9.0
mnb = 0.0
yib = 3.0
bib = 10.0
mib = 0.0

