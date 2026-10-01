package P124_S1_LocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Test {
    public static void main(String[] args) {
        //Constructor
        //system date
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        //certain date
        LocalDateTime ldt0 = LocalDateTime.of(2077, 12, 30, 1, 12, 3, 34);
        System.out.println(ldt0);



        System.out.println("==========");



        //Get Info
        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getDayOfYear());
        System.out.println(ldt.getDayOfWeek().getValue());



        System.out.println("==========");



        //Modify Info: Always return new objects
        //with
        LocalDateTime ldt2 = ldt.withYear(2077);
        System.out.println(ldt2);

        //plus
        LocalDateTime ldt3 = ldt.plusDays(20);
        System.out.println(ldt3);

        //minus
        LocalDateTime ldt4 = ldt.minusDays(20);
        System.out.println(ldt4);



        System.out.println("==========");



        //adjust between dates
        System.out.println(ldt.isEqual(ldt0)); //false
        System.out.println(ldt.isBefore(ldt0)); //true
        System.out.println(ldt.isAfter(ldt0)); //false


        //All methods up to now are same as LocalDate & LocalTime & LocalDateTime
        System.out.println("==========");



        //some special methods for LocalDateTime
        //break
        LocalDate ld = ldt.toLocalDate();
        System.out.println(ld);
        LocalTime lt = ldt.toLocalTime();
        System.out.println(lt);

        //recover
        LocalDateTime ldt666 = LocalDateTime.of(ld, lt);
        System.out.println(ldt666);
    }
}
