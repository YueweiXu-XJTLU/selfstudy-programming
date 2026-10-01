package P134_S1_Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        //java.lang.Throwable -> error + exception (we only use exception to encapsulate wrong-objects)
        //Exception -> RuntimeException (occur when running instead of compiling) + (CompilingTime)Exceptions (occur when compiling)

        //RuntimeException
//        int[] array = {1, 2, 3};
//        System.out.println(array[3]);

        //OtherExceptions
        //Method 1: try/catch
//        try {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date d = simpleDateFormat.parse("2018-11-11 10:24");
//            System.out.println(d);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        //method 2: main(String[] args) throws parseException {} : throw the exception to the upper level (for main-method is JVM) for processing
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = simpleDateFormat.parse("2018-11-11 10:24");
        System.out.println(d);
    }
}
