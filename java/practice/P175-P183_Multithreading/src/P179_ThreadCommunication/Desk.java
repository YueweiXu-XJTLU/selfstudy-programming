package P179_ThreadCommunication;

import java.util.ArrayList;
import java.util.List;

public class Desk {
    private List<String> food = new ArrayList<>();


    public synchronized void put() {
        try {
            if (food.size() == 0) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " has put food");
                food.add("food from " + name);
                Thread.sleep(1000);

                //Key point of Thread Communication: upon finish a thread-self's task, it needs:
                //!!!call methods of THE LOCK OBJECT!!!
                //1. wake up other thread
                this.notifyAll(); //wake up all other threads
                this.notify(); //wake up another thread
                //2. wait itself (instead of enter next loop immediately)
                this.wait();
            } else {
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void get() {
        try {
            if (food.size() == 1) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " has gotten " + food.get(0));
                food.clear();
                Thread.sleep(1000);

                this.notifyAll();
                this.wait();
            } else {
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
