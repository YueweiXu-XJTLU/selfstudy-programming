package P200_S4_RedPockets_2_Callable;

import java.util.*;
import java.util.concurrent.FutureTask;

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
        Map<Thread, FutureTask> employees = new HashMap<>();
        Map<String, Integer> rs = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            FutureTask<Integer> futureTask = new FutureTask(new EmployeeCallable(redPockets));

            Thread thread = new Thread(futureTask, "employee " + i);
            thread.start();

            employees.put(thread, futureTask);
        }



        //3.wait for all finish (!!!important!!!)
        employees.forEach((k, v) -> {
            try {
                rs.put(k.getName(), (Integer) v.get());
                //futureTask.get() ("v.get()" here) will make the main thread progress stuck util get the result, same function as .join for threads here
            }  catch (Exception e) {
                e.printStackTrace();            }
        });
        System.out.println("===============FINISH!===============");



        //4.sort by total money
        rs.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .map(e -> e.getKey() + "-->" + e.getValue())
                .forEach(System.out::println);
    }
}
