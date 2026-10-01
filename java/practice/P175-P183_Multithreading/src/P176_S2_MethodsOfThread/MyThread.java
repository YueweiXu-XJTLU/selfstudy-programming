package P176_S2_MethodsOfThread;

public class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        //write codes for a thread here
        for (int i = 1; i <= 5; i++) {
            System.out.println(this.getName() + " output: " + i);
        }

    }
}
