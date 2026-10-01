package P125_S2_PeriodAndDuration;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Test {
    public static void main(String[] args) {
        //1. Period: calculate difference between year/month/day
        //Only access to LocalDate

        //Constructor
        LocalDate startLD = LocalDate.of(2004, 12, 30);
        LocalDate finishLD = LocalDate.of(2104, 12, 30);
        Period p = Period.between(startLD, finishLD);

        //Usage
        System.out.println("Period: " + p.getYears() + " Years; " + p.getMonths() +  " Months; " + p.getDays() + " Days");



        //2. Duration
        //accessible to LocalDate/LocalTime/LocalDateTime/Instant

        //Constructor
        LocalDateTime startLDT = LocalDateTime.now();
        LocalDateTime finishLDT = LocalDateTime.of(2025, 1, 9, 16, 0, 0, 0);
        Duration d = Duration.between(startLDT, finishLDT);

        //Usage
        System.out.println("Duration: " + d.toDays() + " Days; OR " + d.toHours() + " Hours; OR " + d.toMinutes() + " Minutes; OR " +  d.toMillis() + " Milli_Second; OR " + d.getNano() + " Nano_Second");
    }
}
