package S3_Arrays;

import java.util.Scanner;

public class P49_S2_Case_AverageScoresFromJudges {
    public static void main(String[] args) {
        double[] scores = new double[6];
        double sum  = 0;

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Judge " + (i + 1) + " , please give a score:");
            scores[i] = scanner.nextDouble();
            scanner.nextLine();
            sum += scores[i];
        }
        scanner.close();

        double averageScore = sum / 6;
        System.out.println("The average score is: " + averageScore);

    }
}
