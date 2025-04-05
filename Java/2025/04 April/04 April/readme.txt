Was doing the N queens problem , now before calling the next dfs  , i was adding the position of the queen which i placed last 
now during backtrack i need to remove this last placed queen 
so either arrayList.remove(arrayList.size() - 1) -> this removes the element in the last index and its an O(1) operation 
or we can directly use linkedList 
in java linkedList.removeLast() removes the last element in O(1) . 

Important learning in this code , during recursion i was wondering how , after the backtrack process 

 positionList.add(j); // adding in the list
 backTrack(queensPlaced + 1 , positionList  , n);
 positionList.removeLast(); // removing from the list O(1) 

when we declare List<Integer> positionList = new LinkedList<>();
LinkedList gives us a function removeLast() or removeFirst() whichever we do takes O(1) operation 

also one more important learning , in ArrayList -> list.remove(list.size() - 1 ) -> is O(1) operation and not O(n) operation 
