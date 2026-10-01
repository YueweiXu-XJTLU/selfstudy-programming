package P121_S2_SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        //SimpleDateFormat:
        //y: year
        //M: Month
        //d: day
        //H: Hour (0-24)
        //h: hour (0-12)
        //m: minute
        //s: second
        //E: Day of the week
        //a: a.m./p.m.
        SimpleDateFormat sdf1 = new SimpleDateFormat("y-M-d H:m:s (a) E");



        //1.Date ---> String
        Date d = new Date();
        long d_ms = d.getTime();

        String str1 = sdf1.format(d);
        System.out.println(str1);
        String str2 = sdf1.format(d_ms);
        System.out.println(str2);



        System.out.println("==========");



        //2.String ---> Date
        String str3 = "2025-01-01 00:00:00";

        SimpleDateFormat sdf2 = new SimpleDateFormat("y-M-d H:m:s");
        Date d2 = sdf2.parse(str3);
        System.out.println(d2);
    }
}
