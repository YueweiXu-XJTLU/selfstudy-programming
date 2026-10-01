package S8_ArrayList;

import java.util.Scanner;

public class P82_Case_Restaurant {
    public static void main(String[] args) {
/*
    DATA BASE
    Food food1 = new Food("小龙虾", 19.8, "麻辣");
    Food food2 = new Food("烤蹄", 18.9, "招牌");
    Food food3 = new Food("鸡骨架", 14.08, "单点不送");
*/
        FoodOperator foodOperator = new FoodOperator();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter run or quit:");
            String enter = scanner.nextLine();
            if (enter.equals("run")) {
                foodOperator.start();
            } else if (enter.equals("quit")) {
                break;
            } else {
                System.out.println("Invalid value!");
            }
        }
    }
}