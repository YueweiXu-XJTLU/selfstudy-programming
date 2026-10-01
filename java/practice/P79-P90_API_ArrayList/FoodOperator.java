package S8_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodOperator {
    private ArrayList<Food>  foodList = new ArrayList<>(); //must initialize here, to prevent no address for line31 in this class to use

    public void addFood() {
        Scanner scanner = new Scanner(System.in);
        Food food = new Food();
        While:
        while (true) {
            System.out.println("Enter the number of food to add:");
            int enter = scanner.nextInt();
            switch (enter) {
                case 1:
                    food = new Food("小龙虾", 19.8, "麻辣");
                    break While;
                case 2:
                    food = new Food("烤蹄", 18.9, "招牌");
                    break While;
                case 3:
                    food = new Food("鸡骨架", 14.08, "单点不送");
                    break While;
                default:
                    System.out.println("Invalid value1");
            }
        }

        foodList.add(food);
        System.out.println("上架成功！");
    }

    public void showFood() {
        if (foodList.size() == 0) {
            System.out.println("Null menu");
        } else {
            for (int i = 0; i < foodList.size(); i++) {
                System.out.println("Food " + (i + 1));
                System.out.println("Name:" + (foodList.get(i)).getName());
                System.out.println("Price:" + (foodList.get(i)).getPrice());
                System.out.println("Information:" + (foodList.get(i)).getInfo());
                System.out.println("-----");
            }
        }
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to add food to menu; enter 2 to look through current menu:");
        int command = sc.nextInt();
        sc.nextLine();
        While:
        while (true) {
            switch (command) {
                case 1:
                 addFood();
                 break While;
                case 2:
                showFood();
                 break While;
                default:
                 System.out.println("Invalid!");
            }
        }
    }
}