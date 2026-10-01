package P183_S2_OptimisticLock;

import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable implements Runnable{
    //Optimistic Lock for Integer: AtomicInteger
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            synchronized (this) {
                System.out.println("count: " + count.incrementAndGet());
            }
        }
    }
}
