package S3_Arrays;

import java.util.Scanner;

public class P52_S1_Case_RandomRank {
    public static void main(String[] args) {
        //dynamic initializing and input the elements sequentially to get the origin array
        int[] IDNumber = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < IDNumber.length; i++) {
            System.out.println("No." + (i + 1) + ", please enter your ID number:");
            IDNumber[i] = scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();
        for (int i = 0; i < IDNumber.length; i++) {
            System.out.print(IDNumber[i] + " ");
        }
        System.out.println();

        //traversal the array and for EACH element, exchange it with a random element
        for (int i = 0; i < IDNumber.length; i++) {
            int randomNumber = (int)(Math.random() * (IDNumber.length)); //NOT "(IDNumber.length + 1)"!!!
            int tempI = IDNumber[i];
            IDNumber[i] = IDNumber[randomNumber];
            IDNumber[randomNumber] = tempI;
        }

        //output the randomly ranked array
        for (int i = 0; i < IDNumber.length; i++) {
            System.out.print(IDNumber[i] + " ");
        }

    }
}
