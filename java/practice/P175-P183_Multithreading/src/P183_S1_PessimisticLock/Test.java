package P183_S1_PessimisticLock;

public class Test {
    public static void main(String[] args) {
        //All code before are: Pessimistic Lock(悲观锁)
        //Pessimistic Lock(悲观锁): add lock to thread first, after completing running, unlock: thread safe & worse in efficiency

        //1 variable in one task, 100 threads, each add 1000 to it
        Runnable target = new MyRunnable();
        for (int i = 1; i <= 100; i++) {
            new Thread(target).start();
        }
        //without pessimistic lock, multiple threads get count, add, output in SAME count, hence, multiple times but only result in count += 1:
        //hence: line number == 100000 & count <= 10000 & count output in random rank & if count < 10000, there must be some line(s) of output have same count

    }
}
