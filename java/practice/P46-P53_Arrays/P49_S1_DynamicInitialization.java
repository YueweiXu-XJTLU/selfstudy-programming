package S3_Arrays;

public class P49_S1_DynamicInitialization {
    public static void main(String[] args) {
        //Dynamic Initialization 动态初始化: don't store elements, only store dataType and LengthOfArray
        //dataType[] nameOfTheArray = new dataType[LengthOfArray];
        int[] arrayOfInt = new int[3]; //for dynamic initialization, the elements are filled as default value of the corresponding data type
        System.out.println(arrayOfInt[0]); //output default element: 0
        //default element value:
        //byte/short/int/long/char : 0 //for char, the default element value is 0, but when casting to char automatically, it output as a strange character
        //double/float : 0.0
        //boolean : false
        //String : null
        char[] arrayOfChar = new char[3];
        System.out.println(arrayOfChar[1]); //a strange character
        System.out.println((arrayOfChar[1]) * 1); //0 (default element value)



        System.out.println("--------------------");



        arrayOfInt[0] = 10;
        System.out.println(arrayOfInt[0]);


    }
}
