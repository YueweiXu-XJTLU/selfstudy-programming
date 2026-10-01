package P124_S2_Zone;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test {
    public static void main(String[] args) {
        //1. ZoneId
        //get system Zone Id
        ZoneId zid = ZoneId.systemDefault();
        System.out.println(zid.getId());

        //get all available ids
//        System.out.println(ZoneId.getAvailableZoneIds()); //use "Ctrl + F" to search in the console

        //encapsulate a specific ZoneId
        ZoneId zid2 = ZoneId.of("America/New_York");
        System.out.println(zid2.getId());



        System.out.println("==========");



        //2. ZonedDateTime
        //constructor
        ZonedDateTime zdt = ZonedDateTime.now(); //System default DateTime
        ZonedDateTime zdt2 = ZonedDateTime.now(zid2);
        System.out.println(zdt + "   //   " + zdt2);

        //standard statement to get "Coordinated Universal Time (UTC)"
        ZonedDateTime UTC = ZonedDateTime.now(Clock.systemUTC());
        System.out.println(UTC);

        //other methods for ZonedDateTime are highly similar to LocalDateTime
    }
}
