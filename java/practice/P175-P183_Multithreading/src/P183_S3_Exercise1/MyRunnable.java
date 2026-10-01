package P183_S3_Exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable implements Runnable{
    private List<String> gifts = new ArrayList<>();
    private int xiaoMing;
    private int xiaoHong;

    public MyRunnable() {
        //create gifts
        for (int i = 1; i <= 100; i++) {
            gifts.add("gift" + i);
        }
    }

    @Override
    public void run() {
        while (true) {
            //send
            synchronized (this) {
                if (gifts.size() <= 10) {
                    break;
                }
                String giftSent = gifts.remove((int)(Math.random() * gifts.size()));
                System.out.println(Thread.currentThread().getName() + " sent " + giftSent);
                //count
                if (Thread.currentThread().getName().equals("Xiao Ming")) {
                    xiaoMing++;
                } else {
                    xiaoHong++;
                }
            }
        }
    }

    public void finalCount() {
        System.out.println("Xiao Ming's final count: " + xiaoMing);
        System.out.println("Xiao Hong's final count: " + xiaoHong);
        System.out.println("Gifts left: " + gifts.size());
    }
}
