package P183_S1_PessimisticLock;

public class MyRunnable implements Runnable{
    private int count;

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            synchronized (this) {
                System.out.println("count: " + (++count));
            }
        }
    }
}
