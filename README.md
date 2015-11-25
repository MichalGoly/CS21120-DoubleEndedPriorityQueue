## SUMMARY
Mwg2DEPQ is an implementation of the double ended priority queue (DEPQ) interface
provided as part of the CS21100 (Program Design, Data Structures And Algorithms)
assignment at Aberystwyth University.

DEPQ has been implemented using an interval heap which makes it very efficient.
Interval heap is similar to a traditional heap, however each node, represented by
the Interval inner class, contains two Comparable elements. Left element is
typically smaller (can be equal to) than the right one. If the total amount of
elements in the interval heap is odd, the last Interval will hold a second 'dummy'
element to make the implementation simpler. All left elements in the interval heap
define a min heap, whereas all right elements define a max heap. Therefore in the
root Interval the left element is the smallest one in the heap and the right one
is the largest one in the heap. Internally all elements are stored inside a
standard array which can be expanded if necessary. Size is being tracked in an
instance variable.

## TIME COMPLEXITY

Each significant method has an associated complexity analysis in the JavaDoc,
however the summary of the efficiency of all methods is presented below.

| Method name   | Complexity |
|---------------|------------|
|size()         | O(1)       |
|isEmpty()      | O(1)       |        
|inspectLeast() | O(1)       | 
|inspectMost()  | O(1)       | 
|add()          | O(log n)   | 
|getLeast()     | O(log n)   | 
|getMost()      | O(log n)   |

## SOURCES
In order to understand the concept of an interval heap and the way to implement
it, I extensively used this web site:
http://www.cise.ufl.edu/~sahni/dsaaj/enrich/c13/double.htm

In order to see how the other developers tackled the problem I read through this
web site:
http://www.mhhe.com/engcs/compsci/sahni/enrich/c9/interval.pdf
