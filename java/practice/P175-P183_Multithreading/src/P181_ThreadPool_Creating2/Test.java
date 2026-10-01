package P181_ThreadPool_Creating2;

import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        //Create Thread Pool:
        //Method2: Tool Class: Executors

        //public static ExecutorService newFixedThreadPool(int nThreads) //fixed core thread number (no temp threads)//upon Exception which make a thread finish, thread pool will create a new thread
        Executors.newFixedThreadPool(3);

        //public static ExecutorService newSingleThreadExecutor() //a single thread in thread pool //upon Exception which make a thread finish, thread pool will create a new thread
        Executors.newSingleThreadExecutor();

        //public static ExecutorService newCachedThreadPool() //thread number increase as task number increase //task finish & empty for 60s: thread will be recycled

        //public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) //can execute after given delay or execute at regular times



        //how to number of Core Threads:
        //计算密集属性任务: CoreThreadNumber = CPU_CoreNumber + 1
        //IO密集型任务: CoreThreadNumber = CPU_CoreNumber * 2
    }
}
