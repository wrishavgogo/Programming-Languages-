First 1 hr of the video :- https://www.youtube.com/watch?v=Rot2QnaUqBU&list=PLpxM6m39X_t-Rk9lZVVD4U6JycAAIIEDW&index=41

Few things worth noting down 

1. checked ( compile time) & unchecked exceptions 

2. runnable -> void return type, callable<T> generic return type 

3. Thread class itself implements Runnable interface -> so has run method override only , callable you create custom class 
In new Thread(new runnable()) can be passed but not new Callable() as it has no constructor to handle that 


4. difference b/w -> sleep(time)[sleep until time seconds , does not release locks] & wait()->[waits until notify() method is called , releases locks]

5. when notify()/notifyAll() is called immediately thread does not start running , it is moved into ready queue to get CPU opputunity
