package P200_S4_RedPockets_1_Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeThread extends Thread {
    private List<Integer> money = new ArrayList<>();
    private int sum; //for statistic: each thread has its own sum

    public EmployeeThread(List<Integer> money, String name) {
        super(name);
        this.money = money; //reference data, address
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (money) { //lock using shared resource
                if (money.size() == 0) {
                    break;
                } //add this inside synchronized () {} to avoid concurrent issue (consider the last thread's situation)
                Random r = new Random();
                int temp = money.remove(r.nextInt(money.size()));
                sum += temp;
                System.out.println(Thread.currentThread().getName() + " grabs " + temp + "$!");
            } //unlock
            try {
                Thread.sleep(100); //wait a bit to avoid a thread get too much red pockets
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
