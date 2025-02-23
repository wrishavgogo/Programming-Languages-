1. Why practicing machine coding of Snake Ladder Game , i was stuck with the code like how to generate a random Number between 1 to 6 while rolling a dice .

then i got to know about a class called RandomGenerator ---> RandomGenerator.getDefault().nextInt(minNumber , maxNumber); 

this method helps me generate a randomInteger b/w minNumber and maxNumber 



2. adderList.stream()
    .collect(Collectors.toMap(Ladder::getStart, Function.identity(), (A, B) -> A)); 


this code i understood . 

So Collectors.toMap(keyMapper , ValueMapper , MergeFunction)


keyMapper ---> Ladder::getStart .... this is the key , 
valueMapper ---> Function.identity() . this tells in the value populate the object itself 
MergeFunction ----> (A, B) -> A ..... which ever comes first ignore the rest for the same key , in case of duplicate items 


in the valueMapper if i wanted i could make it 
valueMapper ---> Ladder :: getEnd

this could be done 

