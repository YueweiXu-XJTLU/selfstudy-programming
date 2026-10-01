package P121_S1_Date;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        //1.Non-parameter Constructor (Current Time)
        Date d1 = new Date();
        System.out.println(d1);

        //2.get time in ms: .getTime()
        long time_ms = d1.getTime();
        System.out.println(time_ms);

        long tenSecondsLater = time_ms + 10000;

        //3.Constructor with parameter of time in ms
        Date d2 = new Date(tenSecondsLater);
        System.out.println(d2);

        //4.set a time to the Date object:
        d1.setTime(tenSecondsLater);
        System.out.println(d1);
    }
}
