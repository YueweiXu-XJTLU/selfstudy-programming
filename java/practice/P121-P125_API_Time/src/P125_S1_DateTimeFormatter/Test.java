package P125_S1_DateTimeFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class  Test {
    public static void main(String[] args) {
        //Constructor (create a format)
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");



        //Formatting (格式化) data
        //method1: call method of DateTimeFormatter, use DataTimeObject as parameter
        LocalDateTime ldt = LocalDateTime.now();
        String str1 = dtf.format(ldt);
        System.out.println(str1);
        //method2: call method of DateTimeObject, use a DateTimeFormatter as parameter
        String str2 = ldt.format(dtf);
        System.out.println(str2);



        //parse the LocalDateTime (call method of LocalDateTime)
        LocalDateTime ldt2 = LocalDateTime.parse("2077-12-30 23:59:59", dtf);
        System.out.println(ldt2);
    }
}
