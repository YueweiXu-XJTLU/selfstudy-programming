package P135_DealWithExceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        //ways to deal with exceptions
        //Firstly: throw to upper level (level by level); try-catch in the highest level(class/method)
        //Then: 1. record; and response proper messages to users
/*
        try {
            test1();
        } catch (ParseException e) {
            System.out.println("Date format error");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Other exceptions");
        } //"try{} catch {} catch {} ..." for multiple exceptions
        //slope of Exceptions must from small -> large (SpecificException -> Exception)
*/

        //better to directly use "Exception" here:
        try {
            test1();
        } catch (Exception e) {
            System.out.println("Other exceptions");
        }


    }

//    public static void test1() throws ParseException, FileNotFoundException, Exception { //throw 2 exceptions to main //slope of Exceptions must from small -> large (SpecificException -> Exception)
      public static void test1() throws Exception { //better to directly use "Exception" here
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = simpleDateFormat.parse("2018-11-11 10:24");
        System.out.println(d);
        //when an exception occurs, the method will "throws" it and RETURN
        //so,if the data format here is:
        //right: we get "FileNotFoundException"
        //wrong: we get "ParseException"

        test2();
    }

//    private static void test2() throws FileNotFoundException, Exception { //throw 1 exception to test1 //slope of Exceptions must from small -> large (SpecificException -> Exception)
      public static void test2() throws Exception { //better to directly use "Exception" here
        InputStream is = new FileInputStream("D:/test.txt");
    }
}
