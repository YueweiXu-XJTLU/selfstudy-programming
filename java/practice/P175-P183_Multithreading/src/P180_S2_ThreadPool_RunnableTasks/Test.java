package P180_S2_ThreadPool_RunnableTasks;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(3, 5, 8,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //use thread pool:
        //1.void execute(Runnable command)
        Runnable runnable = new MyRunnable();
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        //work queue begins
        threadPool.execute(runnable); //wait for thread reuse
        threadPool.execute(runnable); //wait for thread reuse
        threadPool.execute(runnable); //wait for thread reuse
        threadPool.execute(runnable); //wait for thread reuse
        //work queue ends
        threadPool.execute(runnable); //temp thread if all core threads are busy
        threadPool.execute(runnable); //temp thread if all core threads are busy
        //time to reject
        threadPool.execute(runnable); //reject new task inside the current thread pool

        //2.Future<T> submit(Callable<T> task)

        //3.void shutdown(): shutdown thread pool until all threads above are finished
        threadPool.shutdown(); //thread pool will NOT be shut down automatically by default

        //4.List<Runnable> shutdownNow(): shut down thread pool NOW, return all un-finished tasks
//        threadPool.shutdownNow();

    }
}
