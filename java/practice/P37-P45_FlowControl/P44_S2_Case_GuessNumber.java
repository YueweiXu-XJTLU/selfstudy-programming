package S2_FlowControl;

import java.util.Random;
import java.util.Scanner;

public class P44_S2_Case_GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int r = 1 + random.nextInt(100);

        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("Please enter an integer: ");
            int s = scanner.nextInt(); //"int variable" can appear inside a loop, but if "int variable" has appeared out of a loop, then it can't appear inside the loop again.
            scanner.nextLine();

            if (s == r) {
                System.out.println("Correct! The random number is " + r);
                break;
            } else if (s > r) {
                System.out.println("The integer you enter is too large!");
            } else {
                System.out.println("The integer you enter is too small!");
            }

        }
        scanner.close();

    }
}
