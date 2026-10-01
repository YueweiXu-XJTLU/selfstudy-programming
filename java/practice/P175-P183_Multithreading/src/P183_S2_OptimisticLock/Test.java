package P183_S2_OptimisticLock;

public class Test {
    public static void main(String[] args) {
        //Optimistic Lock(乐观锁): run first, after encountering threads safety issues, add lock: thread safe & better in efficiency
        //CAS Algorithm (Compare And Swap)

        //1 variable in one task, 100 threads, each add 1000 to it
        Runnable target = new MyRunnable();
        for (int i = 1; i <= 100; i++) {
            new Thread(target).start();
        }
    }
}
