package P175_S2_CreateThread_ImplementsRunnable;

public class Test {
    public static void main(String[] args) {
        //3 methods to create threads

        //method2.1:
        //1.RunnableClass (TaskClass) implements Runnable //hence CAN extend other classes
        //2.override run() method
        //3.create a Runnable Object (Task Object)
        Runnable runnable1 = new MyRunnable();
        //4.create a Thread Object with the Runnable Object
        Thread thread1 = new Thread(runnable1);
        //5.call start() of the Thread Object to start the thread
        thread1.start();



        //method2.2: directly use AnonymousInnerClass of Runnable(interface) to simplify the codes
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Child Thread2 output: " + i);
            }
        }).start();


        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread output: " + i);
        }
    }
}
