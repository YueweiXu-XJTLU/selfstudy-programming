package P179_ThreadCommunication;

public class Test {
    public static void main(String[] args) {
        //Thread Communication (线程通信): have the PRE-CONDITION of Thread Safety

        //create shared resource
        Desk desk = new Desk();

        //create producer_threads
        new Thread(() -> {
            while (true) {
                desk.put();
            }
        }, "cook1").start();

        new Thread(() -> {
            while (true) {
                desk.put();
            }
        }, "cook2").start();

        new Thread(() -> {
            while (true) {
                desk.put();
            }
        }, "cook3").start();

        //create consumer_threads
        new Thread(() -> {
            while (true) {
                desk.get();
            }
        }, "customer1").start();

        new Thread(() -> {
            while (true) {
                desk.get();
            }
        }, "customer2").start();
    }
}
