package S3_Arrays;

public class P48_IterateOverArrays {
    public static void main(String[] args) {
        //Iterate over arrays (遍历数组)：access the data inside arrays one by one
        int[] array = {1, 2, 3, 4, 5};
        //just type "nameOfArray.fori" + Enter
        for (int i = 0; i < array.length; i++) { //"i < nameOfArray.length": if there is 0 elements in =side the array, the for-loop stop without any output
            System.out.println(array[i]);
        }



        System.out.println("--------------------");


        
        //case: calculate sum of elements inside an array
        int[] arrayTobeSummedUp = {16, 26, 36, 6, 100};
        int sum = 0;
        for (int i = 0; i < arrayTobeSummedUp.length; i++) {
            sum += arrayTobeSummedUp[i];
        }
        System.out.println("Sum of elements inside the array: " + sum);






    }
}
