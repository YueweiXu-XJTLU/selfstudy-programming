package P200_S4_RedPockets_1_Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws Exception {
        //1.prepare for red pockets
        List<Integer> redPockets = new ArrayList<>();
        Random r = new Random();
        int money;
        //small
        for (int i = 1; i <= 160; i++) {
            money = 1 + (int) r.nextInt(30);
            redPockets.add(money);
        }
        //large
        for (int i = 1; i <= 160; i++) {
            money = 31 + (int) r.nextInt(70);
            redPockets.add(money);
        }



        //2.prepare for employees (use multiple threads)
        List<EmployeeThread> employees = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            EmployeeThread employeeThread = new EmployeeThread(redPockets, "employee" + i);
            //make the ArrayList defined in main as a shared resource for all thread
            //!!!the assign is only for ADDRESS, hence the shared resource will automatically update upon any manipulation by any thread!!!
            employeeThread.start();
            employees.add(employeeThread);
        }



        //3.wait for all finish (!!!important!!!)
        for (Thread employee : employees) {
            employee.join();
        }
        System.out.println("===============FINISH!===============");



        //4.sort by total money
        employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSum(), e1.getSum()))
                .map(e -> e.getName() + " finally grabs " + e.getSum() + "$!")
                .forEach(System.out::println);
    }
}
