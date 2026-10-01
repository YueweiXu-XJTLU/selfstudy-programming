package P180_S3_ThreadPool_CallableTasks;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = new ThreadPoolExecutor(3, 5, 8,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //use thread pool:
        //1.void execute(Runnable command)

        //2.Future<T> submit(Callable<T> task)
        MyCallable myCallable = new MyCallable(100);
        Future<String> f1 = threadPool.submit(myCallable);
        Future<String> f2 = threadPool.submit(myCallable);
        Future<String> f3 = threadPool.submit(myCallable);
        Future<String> f4 = threadPool.submit(myCallable);
        //work queue begins
        System.out.println(f1.get()); //wait for thread reuse
        System.out.println(f2.get()); //wait for thread reuse
        System.out.println(f3.get()); //wait for thread reuse
        System.out.println(f4.get()); //wait for thread reuse

        //3.void shutdown(): shutdown thread pool until all threads above are finished
        threadPool.shutdown(); //thread pool will NOT be shut down automatically by default

        //4.List<Runnable> shutdownNow(): shut down thread pool NOW, return all un-finished tasks
//        threadPool.shutdownNow();

    }
}
