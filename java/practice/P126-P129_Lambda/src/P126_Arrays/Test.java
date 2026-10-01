package P126_Arrays;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntToDoubleFunction;

public class Test {
    public static void main(String[] args) {
        //1. return contains of an array
        int[] arr1 = new int[] {0, 10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(arr1)); //[0, 10, 20, 30, 40, 50]



        //2. copy part of an array
        int[] arr2 = Arrays.copyOfRange(arr1, 1, 4); //[from, to)
        System.out.println(Arrays.toString(arr2)); //[10, 20, 30]



        //3. array expansion (数组扩容)
        int[] arr3 = Arrays.copyOf(arr1, 10);
        System.out.println(Arrays.toString(arr3)); //[0, 10, 20, 30, 40, 50, 0, 0, 0, 0]

        int[] arr4 = Arrays. copyOf(arr1, 1);



        //4. change contains of an array //returnType of Arrays.setAll() is VOID!!!
        double[] price = {500.0, 100.0, 200.0, 300.0};
        Arrays.setAll(price, new IntToDoubleFunction() {
            @Override
            public double applyAsDouble(int value) {
                //value here is the iterated indices in the array(price here)
                BigDecimal bd1 = BigDecimal.valueOf(price[value]);
                BigDecimal bd2 = BigDecimal.valueOf(0.8);
                return bd1.multiply(bd2).doubleValue() ;
            }
        } ); //Anonymous Inner Class

        System.out.println(Arrays.toString(price)); //[400.0, 80.0, 160.0, 240.0]



        //5. sort data in array by ascending order (from small to large)
        Arrays.sort(price);
        System.out.println(Arrays.toString(price)); //[80.0, 160.0, 240.0, 400.0]

        //compare between objects:
        Students s1 = new Students("s1", 12);
        Students s2 = new Students("s2", 19);
        Students s3 = new Students("s3", 11);
        Students[] students = {s1, s2, s3};

        //method1: implement Comparable<T> then override the compare rules
        Arrays.sort(students);
        System.out.println(Arrays.toString(students)); //descending order

        //method2: use anonymous inner class of an interface "Comparator"
//        Arrays.sort(students, new Comparator<Students>() {
//            @Override
//            public int compare(Students o1, Students o2) {
//                //if we are comparing double type data, the compare or the Comparable interface in method1 are not suitable as the methods use int as return type
//                //we can use: return Double.compare(o1.getHeight, o2.getHeight)
//                //or just write manually (ascending order)
//                if (o1.age > o2.age) {return 1;}
//                if (o1.age < o2.age) {return -1;}
//                return 0;
//            }
//        });
        Arrays.sort(students, (o1, o2) -> o1.age -o2.age);
        System.out.println(Arrays.toString(students)); //ascending order
    }
}
