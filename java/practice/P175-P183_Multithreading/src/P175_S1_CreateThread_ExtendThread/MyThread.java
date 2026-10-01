package P175_S1_CreateThread_ExtendThread;

public class MyThread extends Thread {
    @Override
    public void run() {
        //write codes for a thread here
        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread output: " + i);
        }

    }
}
