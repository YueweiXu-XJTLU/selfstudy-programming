package P182_Tips;

public class Test {
    //Tip1:
    //Thread 线程
    //Process 进程: a running program
    //Concurrency 并发: 1 core of CPU alertly process in multiple tasks rapidly, LOOKS LIKE all the threads are processed simultaneously
    //Parallelism 并行: multiple cores of CPU TRULY process multiple threads simultaneously

    //A Process can contain multiple Threads: these threads are executing of Concurrency and Parallelism



    //Tip2:
    //Lifespan of threads
    //6 states of threads: defined inside an enum class of Thread (.sleep() will NOT release Lock Object; .wait() WILL release Lock Object):
    //public enum State {
    //    NEW, //before .start()
    //    RUNNABLE, //after .start()
    //    BLOCKED, //Failed to get the Lock Object
    //    WAITING, //infinite_waiting: after .wait(), keep waiting until .notify()/.notifyAll() by other threads
    //    TIMED_WAITING, //timed_waiting: after .wait(millisecond) or .sleep(millisecond): keep waiting until TIME IS OUT or .notify()/.notifyAll() by other threads
    //    TERMINATED; //finished or exception occurs
    //}
}
