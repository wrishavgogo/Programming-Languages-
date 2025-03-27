/***
 * I in solid stands for Interface segregation principle
 *
 * or interface separation principle as the word separation
 * makes the neurons in my brain more active
 *
 */

interface Worker {

    public void work();
    public void eat();
}

class Human implements Worker {

    @Override
    public void work() {
        System.out.println("humans  work");
    }

    @Override
    public void eat() {
        System.out.println("humans eat");
    }
}

class Robot implements  Worker {

    @Override
    public void work() {
        System.out.println("robots  work");
    }

    @Override
    public void eat() {
        throw new RuntimeException("robots dont eat");
    }

}


/***
 * Above example is violating interface segregation principle
 *
 * so we separate the work interface into two parts
 * 
 * No client should be forced to implement things it doesn't have to 
 * Instead of one big fat interface and multiple small interfaces
 * */

interface Workable {
    public void work();
}

interface Eatable {
    public void eat();
}

class Human1 implements Workable,Eatable {

    @Override
    public void work() {
        System.out.println("humans  work");
    }

    @Override
    public void eat() {
        System.out.println("humans eat");
    }
}

// we do not for Robots1 to implement the eat method
class Robots1 implements Workable {
    @Override
    public void work() {
        System.out.println("humans  work");
    }
}

