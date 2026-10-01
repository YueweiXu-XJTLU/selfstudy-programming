package S5_Cases;

import java.util.Scanner;

public class P65_RedPockets {
    public static void main(String[] args) {
        int[] redPocket = {9, 666, 188, 520, 9999};
        redPockets1(redPocket);
//        redPockets2(redPocket);
    }

    public static void redPockets1(int[] array) {
        int index = (int)(Math.random() * 5);
        int temp;
        Scanner sc = new Scanner(System.in);

        //randomly define the pocket every person will get
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        //enter to grab red pocket
        for (int i = 0; i < array.length; i++) {
        System.out.println("Enter anything to grab red pockets:");
        sc.nextLine(); //wait for user's typing
        System.out.println("your grab " + array[i] + " yuan!");
        }
    }




    public static void redPockets2(int[] array) {
        int index;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter anything to grab:");
            sc.nextLine(); //wait for user's typing
            while (true) {
                index = (int) (Math.random() * 5);
                if (array[index] != 0) {
                    System.out.println("your grab " + array[index] + " yuan!");
                    array[index] = 0;
                    break;
                }
            }
        }
    }

}

