package P180_S1_ThreadPool_Creating;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        //Thread Pool 线程池

        //WorkThread = CoreThread
        //TempThread: create when: 1.upon new task is coming; 2.core threads are using; 3.work queue is fully; 4.temp thread creating is available
        //WorkQueue 任务队列 (tasks implements Runnable/Callable)

        //Create Thread Pool:
        //Method1: ThreadPoolExecutor implements ExecutorService
        /*
        public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)
         */
        //maximumPoolSize = corePoolSize + tempPoolSize
        //keepAliveTime + unit: for TempThreads
        //BlockingQueue: LinkedBlockingQueue<>(): based on chain-list, no limit for task number; ArrayBlockingQueue<>(capacity): bases on array, limit task number
        //keepAliveTime: create threads
        //handler: reject strategy (Abort Policy) for coming tasks:
          //reject when: 1.upon new task is coming; 2.both core thread and temp thread are busy; 3.work queue is full
          //reject policies:
            //ThreadPoolExecutor.AbortPolicy: throw Exception
            //ThreadPoolExecutor.DiscardPolicy: discard new tasks without Exception (not recommended)
            //ThreadPoolExecutor.DiscardOldestPolicy: discard the oldest task, use its thread to handle new task
            //ThreadPoolExecutor.CallerRunsPolicy: use main-thread to handle the new task

        ExecutorService threadPool = new ThreadPoolExecutor(3, 5, 8,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

    }
}
