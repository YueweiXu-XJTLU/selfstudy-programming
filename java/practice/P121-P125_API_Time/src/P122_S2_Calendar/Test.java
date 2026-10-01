package P122_S2_Calendar;

import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        //1. get object (Calendar if an abstract class)
        Calendar c = Calendar.getInstance();
        System.out.println(c); //print all CONSTANTS (MONTH start from 0)

        //2. get a constant
        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        //3. get a Date object
        Date date = c.getTime();
        System.out.println(date);

        //4. get a time in ms
        long time_ms = c.getTimeInMillis();
        System.out.println(time_ms);

        //5.modify a certain info of the Calendar object
        c.set(Calendar.MONTH, 1);
        System.out.println(c);

        //6.change the info inside a Calendar object
        c.add(Calendar.MONTH, -10);
        System.out.println(c);
    }
}
