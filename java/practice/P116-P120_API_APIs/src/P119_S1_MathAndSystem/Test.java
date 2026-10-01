package P119_S1_MathAndSystem;

public class Test {
    public static void main(String[] args) {
        //1. Math
        System.out.println(Math.ceil(1.1)); //向上取整 //return double //2.0
        System.out.println(Math.floor(3.9)); //向下取整 //return double //3.0
        System.out.println(Math.round(4.4)); //四舍五入 //return long //4



        //2. System

        //2.1
//        System.exit(0);
//        System.out.println("Close the JVM, \"0\" represent manually call this method (!!!Do not use this code!!!!!)" );

        //2.2
        long time = System.currentTimeMillis(); //return long type time in millisecond (1/1000s) from 1970-01-01:00:00:00 till now)
        System.out.println(time);

        //usage: performance testing (性能测试)
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
        }
        System.out.println("The loop cost " + ((System.currentTimeMillis() - time) / 1000.0) + "s");


    }
}
