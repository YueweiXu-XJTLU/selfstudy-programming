package S5_Cases;

import java.util.Scanner;

public class P68_DuGou {
    public static void main(String[] args) {
        int[] decision = makeDecision();

         Scanner sc = new Scanner(System.in);
         System.out.println("Enter anything to view lucky numbers:");
         sc.nextLine();
        int[] prize = prize();

         System.out.println("Enter anything to view your prize:");
         sc.nextLine();
        compare(decision, prize);

         sc.close();
    }

    public static int[] makeDecision() {
        int[] decision = new int[7];
        Scanner sc = new Scanner(System.in);
        int temp;

        //red balls decision
        for (int i = 0; i < decision.length - 1; i++) {
            while (true) {
                System.out.println("Enter your No." + (i + 1) + " red ball number (number >= 1 and number <= 33, can't be repeated):");
                temp = sc.nextInt();
                sc.nextLine();
                if (temp >= 1 && temp <= 33) {
                    if (red_NoRepeat(decision, i, temp)) {
                        decision[i] = temp;
                        break;
                    } else {
                        System.out.println("Repeat number is invalid!");
                    }
                } else {
                    System.out.println("Out of available range!");
                }
            }
        }

        //blue ball decision
        while (true) {
            System.out.println("Enter your No.1 blue ball number (number >= 1 and number <= 16, can't be repeated):");
            temp = sc.nextInt();
            sc.nextLine();
            if (temp >= 1 && temp <= 16) {
                decision[decision.length - 1] = temp;
                break;
            } else {
                System.out.println("Repeat number is invalid!");
            }
        }

//        sc.close(); //don't close here!!! this will close ALL SYSTEM.IN STREAM!!!

        //return
        System.out.println("You have successfully made your decision:");
        for (int i = 0; i < decision.length; i++) {
            System.out.print(decision[i] + "\t");
        }
        System.out.println();
        System.out.println();
        return decision;
    }

    public static boolean red_NoRepeat(int[] arr, int index, int temp) {
        for (int i = 0; i < index; i++) {
            if (temp == arr[i]) return false;
        }
        return true;
    }


    public static int[] prize() {
        int[] prizeArray = new int[7];
        int temp;

        //red balls
        for (int i = 0; i < prizeArray.length; i++) {
            while (true) {
                temp = 1 + (int) (Math.random() * 33);
                if (red_NoRepeat(prizeArray, i, temp)) {
                    prizeArray[i] = temp;
                    break;
                }
            }
        }

        //blue balls
        prizeArray[prizeArray.length - 1] = 1 + (int) (Math.random() * 16);

        //return
        System.out.println("Prize is: ");
        for (int i = 0; i < prizeArray.length; i++) {
            System.out.print(prizeArray[i] + "\t");
        }
        System.out.println();
        System.out.println();
        return prizeArray;
    }


    public static void compare(int[] decision, int[] prize) {
        int redCount = 0;
        int blueCount = 0;

        //red balls
        for (int i = 0; i < decision.length - 1; i++) {
            for (int j = 0; j < prize.length; j++) {
                if (decision[i] == prize[j]) {
                    redCount++;
                    break;
                }
            }
        }

        //blue balls
        if (decision[decision.length - 1] == prize[prize.length - 1]) {
            blueCount++;
        }

        //return
        System.out.println("Result: " + redCount + "+" + blueCount);
        if (redCount == 6 && blueCount == 1) {
            System.out.println("You get $1000,0000!");
        } else if (redCount == 6 && blueCount == 0) {
            System.out.println("You get $500,0000!");
        } else if (redCount == 5 && blueCount == 1) {
            System.out.println("You get $3000!");
        } else if ((redCount == 5 && blueCount == 0) || (redCount == 4 && blueCount == 1)) {
            System.out.println("You get $200!");
        } else if ((redCount == 4 && blueCount == 0) || (redCount == 3 && blueCount == 1)) {
            System.out.println("You get $10!");
        } else if ((redCount == 2 && blueCount == 1) || (redCount == 1 && blueCount == 1) || (redCount == 0 && blueCount == 1)) {
            System.out.println("You get $50!");
        } else {
            System.out.println("Kid, are you a bot?");
        }
    }

}