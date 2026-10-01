package S3_Arrays;

public class P47_S1_StaticInitializing {
    public static void main(String[] args) {
        //Static Initialization 静态初始化
        //dataType[] nameOfTheArray = new dataType[] {element1, element2, element3}; // "dataType nameOfTheArray[]" is also available
        //dataType[] nameOfTheArray = {element1, element2, element3}; //"new dataType[]" can be omitted
        int[] arrayOfInt = new int[] {1, 2, 3};
        String[] arrayOfString = {"San Zhang", "Si Li", "Wu Wang"};
        double arrayOfDouble[] = {1.0, 2.0, 3.0};



        System.out.println("--------------------");




        //"nameOfTheArray" is an array_variable which store the ADDRESS of the array where the elements are stored: array is a "Reference Data Type" (引用数据类型), which differs from "Basic Data Type" (int, char, ...)
        System.out.println(arrayOfInt); //[I@b4c966a //"[":is an address of array; "I":data type of int; "@b4c966a":the address of array
        System.out.println(arrayOfString);
        System.out.println(arrayOfDouble);

    }
}
