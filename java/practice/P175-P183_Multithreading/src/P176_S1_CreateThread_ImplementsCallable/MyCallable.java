package P176_S1_CreateThread_ImplementsCallable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "A String returned bu the Child Thread";
    }
}
