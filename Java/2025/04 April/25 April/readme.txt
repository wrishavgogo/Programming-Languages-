Learning about the fact of how collections provide an inbuilt binary search which 
is like in vector finding upper bound and lower bound 

arr = { 1 , 2 , 3 ,  5 , 7 } 
Collections.binarySearch(arr , element) ;

int index = Collections.binarySearch(arr , 5) ; ---> response will be 3 
int index = Collections.binarySearch(arr , 6) ; ---> this will return the response as -(insertionIndex + 1) == -(4 + 1 ) = -5 ... that will be the response 

very handy when dealing with binary search index identification and mostly can be used in finding Longest Increasing subsequence 
