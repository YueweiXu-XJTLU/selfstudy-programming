package P175_S1_CreateThread_ExtendThread;

public class Test {
    public static void main(String[] args) { //main method is running in a Main Thread by default
        //3 methods to create threads

        //method1:
        //1.Thread Class extends Thread //hence can NOT extend other classes
        //2.override run() method
        //3.create a Thread Object
        Thread thread = new MyThread();
        //4.call start() of the Thread Object to start the thread
        thread.start(); //run() will automatically run here //if we simply call run() of the sub-class, it still runs in Main Thread

        //if codes of Main Thread are before Child Thread starts, codes of Main Thread will run until finish BEFORE Child Thread start
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread output: " + i);
        }
        //Main Thread & Child Thread are running simultaneously, hence UN-fixed output order
    }
}
