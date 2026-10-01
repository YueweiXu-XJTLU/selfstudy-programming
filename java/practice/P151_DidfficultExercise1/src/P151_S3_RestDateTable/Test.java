package P151_S3_RestDateTable;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //receive and parse start time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        LocalDate startTime = LocalDate.parse(sc.nextLine() + "-01", dtf); //if LocalDate cannot directly parse yyyy-MM, we manually add "-01" here

        //first resting time
        LocalDate firstRestingTime = LocalDate.of(2022, 02, 03);

        //set end time
        LocalDate endTime = startTime.plusMonths(1).minusDays(1);

        //Period calculators
        Period outputPeriod = Period.between(startTime, endTime);

        //output
        for (int i = 0; i <= outputPeriod.getDays(); i++) {
            LocalDate tempTime = startTime.plusDays(i);
            Period tempPeriod = Period.between(firstRestingTime, tempTime);
            if (tempPeriod.getDays() % 3 == 0) {
                if (tempTime.getDayOfWeek().getValue() == 6) {
                    System.out.println(tempTime + "[Rest]" + "[Saturday]");
                } else if (tempTime.getDayOfWeek().getValue() == 7) {
                    System.out.println(tempTime + "[Rest]" + "[Sunday]");
                } else {
                    System.out.println(tempTime + "[Rest]");
                }
            } else {
                System.out.println(tempTime);
            }
        }
    }
}
