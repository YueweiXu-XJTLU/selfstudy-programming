package P176_S2_MethodsOfThread;

public class Test {
    public static void main(String[] args) throws Exception {
        Thread t1 = new MyThread();
        t1.start();

        //Methods of Thread
        //0.constructor with parameter: String name (need override the constructor)
        Thread t2 = new MyThread("Thread2");

        //1.Thread currentThread(): get the Thread in which this code contains
        Thread mainThread = Thread.currentThread();

        //2.String getName() & void setName(String name)
        System.out.println(mainThread.getName()); //main

        System.out.println(t1.getName()); //Thread-0
        t1.setName("Thread1");
        System.out.println(t1.getName()); //Thread1

        //3.sleep(long time)
        System.out.println("Sleeping~");
        mainThread.sleep(1000);
        System.out.println("Wake up~!");

        //4.join(): wait until this Thread finishes
        t2.start();
        t2.join();
        System.out.println("with join(), this code will ruin after Thread2 finishes!");
    }
}
