package P177_P178_ThreadSafety;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private double balance;
    //method3: ReentrantLock implements Lock
    private final Lock rl = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //method2: synchronization-method:
//    public synchronized void drawMoney(double money) {
    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();

        //method1: synchronization-code-block:
//        synchronized (this) {

        //method3: ReentrantLock implements Lock
        rl.lock();
        try {
            if (money <= balance) {
                System.out.println(name + ": Success!");
                balance -= money;
                System.out.println(name + ": Current balance: " + balance);
            } else {
                System.out.println(name + ": Failed!");
                System.out.println(name + ": Current balance: " + balance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //method3: ReentrantLock implements Lock
            rl.unlock();
        }

//        }
    }
}
