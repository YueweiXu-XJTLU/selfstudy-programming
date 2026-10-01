package P176_S1_CreateThread_ImplementsCallable;

import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws Exception {
        //3 methods to create threads

        //method3:
        //1.CallableClass (TaskClass) implements Callable<E> //hence CAN extend other classes
        //2.override call() method //can return the final result of Thread directly
        //3.create a FutureTask Object (FutureTask implements Runnable) (Task Object)
        FutureTask<String> futureTask1 = new FutureTask(new MyCallable());
        //4.create a Thread Object with the FutureTask Object
        Thread thread1 = new Thread(futureTask1);
        //5.call start() of the Thread Object to start the thread
        thread1.start();
        //6.get the result of the Thread
        String result = futureTask1.get(); //codes will wait here until the Child Thread above finishes and return the result
        System.out.println(result);

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread output: " + i);
        }
    }
}
