package S5_Cases;

import java.util.Scanner;

public class P64_S1_ScoresFromJudges {
    public static void main(String[] args) {
        System.out.println("The fianl average score is: " + scoresFormJudges(5));
    }

    public static double scoresFormJudges(int n) {
        int[] scores = new int[n];
        Scanner scanner = new Scanner(System.in);

        //ask for input
        for (int i = 0; i < n; i++) {
            System.out.println("Judge " + (i + 1) +" , enter your score:");
            scores[i] = scanner.nextInt();
            scanner.nextLine();
        }

        //find max & min
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < scores.length; i++) {
            if (max < scores[i]) {max = scores[i];}
            if (min > scores[i]) {min = scores[i];}
        }


        //calculate real sum
        int sum = 0 - max - min;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        //calculate average
        int ave = sum / (n - 2);

        //return
        return ave;
    }

}
