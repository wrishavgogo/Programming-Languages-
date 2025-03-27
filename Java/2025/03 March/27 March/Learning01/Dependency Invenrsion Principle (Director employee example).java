In solid principles i always forget the last 3 principles 


LID 


In this am noting down what D stands for in SOLID


/***
 * Example stating D - > dependency Inversion principle of SOLID
 * */

class MySQLDB {

    public void doDbCall() {
        System.out.println("mqSql impl");
    }
}

class SomeImplementation {

    MySQLDB dbImpl;

    public SomeImplementation(MySQLDB dbImpl) {
        this.dbImpl = dbImpl;
    }

    public void doSomeWork() {
        dbImpl.doDbCall();
    }
}


/****
 * In the above code code is tightly coupled with MySQLDB
 * */

/**
 * Remember D of SOLID as ( director -> employee relationship )
 * director directly does not manage employees but uses an abstraction called Manager to manage employee
 *
 * "Higher modules should not depend on concrete implementations of the lower modules
 * rather some interface should be there"
 *
 * Below is the fix for that
 * */


interface DbWork {
    public void doDbCall();
}
class MySQLDB1 implements DbWork{

    @Override
    public void doDbCall() {
        System.out.println("mqSql impl");
    }
}

class SomeImplementation1 {

    DbWork dbImpl;

    public SomeImplementation1(DbWork dbImpl) {
        this.dbImpl = dbImpl;
    }

    public void doSomeWork() {
        dbImpl.doDbCall();
    }
}



