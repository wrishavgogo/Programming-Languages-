
In this part an important info i learnt 

Executors.fixedThreadPool(numThreads) --> this will create a thread pool of fixed thread pool size , 
and it is used for CPU intensive tasks , and ideal to have number of threads close to core size , so context switching does not eat up CPU execution time 

Executors.cacheThreadPool() --> we dont provide anything here , 
* this dynamically increases or decreases the number of threads ,
and its used for I/O intensive tasks , 
if all tasks are I/O intensive , then i can spin up large number of threads and all can go to blocked state and do their I/O in parallel , 
and then come to ready or runnable queue one by one 
* this is also better for short lived tasks , as for short lived tasks , lesser number of threads can do the job for us , 


Question :- 
Then i asked chatgpt , since cacheThreadPool() creates threads dynamically , then why cant i leverage it to find a sweet spot to give me good performance in 
  CPU intensive task , such that context switching and actual task execution have a good agreement , to which the answer is 

Answer :- 
newCachedThreadPool() will spawn unlimited threads under pressure. That might:
Flood your system
Lead to massive CPU thrashing
Cause even more timeouts, not fewer , context switching increases a lot 

So the problem we are seeing in Frequency Algo , if we try to use cachedThreadPool our performance will degrade not improve , 
so better we use cached thread pool itself , 



Another difference :- 

fixedThreadPool -> keeps the thread alive untill the lifecycle of the executor
cachedThreadPool -> dynamically closes or creates a thread if its idle for abt 60 secs = defVal


Q)  what does executorservice.invokeAll() method do ?

A) <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
        throws InterruptedException;

ExecutorService executor = Executors.newFixedThreadPool(3);

List<Callable<String>> tasks = Arrays.asList(
    () -> "Task 1",
    () -> "Task 2",
    () -> "Task 3"
);

// Blocks until all 3 are done
List<Future<String>> futures = executor.invokeAll(tasks);

for (Future<String> future : futures) {
    System.out.println(future.get());  // prints Task 1, Task 2, Task 3
}

executor.shutdown();
⏰ With Timeout (optional overload):
java
Copy
Edit
executor.invokeAll(tasks, 2, TimeUnit.SECONDS);


same as submit , only here you get the list of futures youself and you dont have to create it 




* Now there is also scheduledThreadPoolExecutors , we can use this while creating Kafka , for polling in consumers 
ExecutorService exe = Executors.scheduledThreadPool(5);
exe.submit( ()-> return "cron job ran" , 2 , TimeUnit.Minutes) ; -- > will run every 2 mins   -----> wrong my bad i did a mistake the method is not submit 
exe.schedule( () -> your callable or runnable , delay , TimeUnit); --> will run as per the schedule is provided 


Lastly there is Executors.singleThreadExecutor() --> which probaby redis uses , single thread is only there , Redis is written in C
