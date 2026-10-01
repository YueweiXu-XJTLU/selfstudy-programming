package S3_Arrays;

public class P50_ReferencePassing {
    public static void main(String[] args) {
        //Reference Passing (引用传递): multiple array variables point to a same array
        int[] array1 = {1, 2, 3};
        int [] array2 = array1; //the value of array1 (the address) is assigned to array2
        System.out.println(array1);
        System.out.println(array2);

        array2[0] = 111; //the element inside the array is changed wile the address not
        System.out.println(array1[0]); //111



        System.out.println("--------------------");



        //if an array variable is "null", it does not point to any array
        int[] arrayNull = null;
        System.out.println(arrayNull); //it can still be output as "null";
        //System.out.println(arrayNull.length); //we can't access to any array as it does not point to any array
        //System.out.println(arrayNull[0]); //we can't access to any array as it does not point to any array
        
    }
}
