package P117_S2_WrapperClass;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //wrapper class 包装类: wrap primitive data type into objects
        
        //1. constructor
        Integer i1 = Integer.valueOf(6661);
        System.out.println(i1); //6661

        //Auto-boxing(自动装箱) & Auto-unboxing(自动拆箱)
        Integer i2 = 6662;
        System.out.println(i2); //6662
        Integer i3 = i2;
        System.out.println(i3); //6662



        System.out.println("==========");



        //2. casting
        //cast primitive data type data to String
        Character c1 = 'a';
        System.out.println(c1 + 'a'); //194
        System.out.println(Character.toString(c1) + 'a'); //aa
        //however: same function as and less elegant to:
        System.out.println(c1 + "" + c1); //aa

        System.out.println("-----");

        //cast String to primitive data type data
        String scoreString = "99.5";
        double scoreDouble1 = Double.parseDouble(scoreString);
        double scoreDouble2 = Double.valueOf(scoreString);
        System.out.println(scoreString + 0.5); //99.50.5
        System.out.println(scoreDouble1 + 0.5); //100.0
        System.out.println(scoreDouble2 + 0.5); //100.0



        System.out.println("==========");



        //3. usage: in generics
        ArrayList<Integer> AL = new ArrayList<>();
        AL.add(123);
        System.out.println(AL.get(0)); //123
    }
}
