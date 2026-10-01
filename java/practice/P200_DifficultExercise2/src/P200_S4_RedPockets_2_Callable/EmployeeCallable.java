package P200_S4_RedPockets_2_Callable;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class EmployeeCallable implements Callable {
    private List<Integer> redPockets;
    private int sum = 0;

    public EmployeeCallable(List<Integer> redPocket) {
        this.redPockets = redPocket;
    }

    @Override
    public Object call() throws Exception {
        while (true) {
            synchronized (redPockets) {
                if (redPockets.size() == 0) {
                    break;
                }
                Random r = new Random();
                int temp = redPockets.remove(r.nextInt(redPockets.size()));
                sum += temp;
                System.out.println(Thread.currentThread().getName() + " " + temp);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sum;
    }
}
