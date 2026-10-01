package S3_Arrays;

public class P47_S2_CallArrays {
    public static void main(String[] args) {
        int[] arrayOfInt = new int[] {1, 2, 3};
        String[] arrayOfString = {"San Zhang", "Si Li", "Wu Wang"};
        double arrayOfDouble[] = {1.0, 2.0, 3.0};

        //call an array: nameOfArray[indexNumber]
        System.out.println(arrayOfInt[0]);
        System.out.println(arrayOfString[1]);
        System.out.println(arrayOfDouble[2]);



        System.out.println("--------------------");



        //access the length property of an array (now humber of elements inside the array): nameOfArray.length
        int lengthOfArray = arrayOfInt.length;
        System.out.println(lengthOfArray);
        System.out.println(arrayOfInt.length);



        System.out.println("--------------------");



        //modify the elements inside the array: nameOfArray[indexNumber] = newElement:
        arrayOfString[2] = "I am not Wu Wang!";
        System.out.println(arrayOfString[2]);



        System.out.println("--------------------");



        //access the max index number of an array: ONLY IF NUMBER OF ELEMENTS > 0!!!
        //if number of elements == 0:
        int[] array1 = {};
        System.out.println(array1.length);
        //System.out.println(array[0]); //errors occurs

        //if number of elements > 0:
        int[] array2 = {1, 2, 3};
        int maxIndexNumber = array2.length - 1;
        System.out.println(array2[maxIndexNumber]);

    }
}
