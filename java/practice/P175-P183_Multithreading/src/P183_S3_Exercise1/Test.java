package P183_S3_Exercise1;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        MyRunnable target = new MyRunnable();

        Thread xiaoMing = new Thread(target, "Xiao Ming");
        Thread xiaoHong = new Thread(target, "Xiao Hong");

        xiaoMing.start();
        xiaoHong.start();

        xiaoMing.join();
        xiaoHong.join();

        target.finalCount();
    }
}
