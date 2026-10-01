package P180_S3_ThreadPool_CallableTasks;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= n ; i++) {
            sum += 1;
        }
        return Thread.currentThread().getName() + " get sum from 1 to " + n + ": " + sum;
    }
}
