package P175_S2_CreateThread_ImplementsRunnable;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread1 output: " + i);
        }
    }
}
