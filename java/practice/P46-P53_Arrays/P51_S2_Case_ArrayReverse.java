package S3_Arrays;

public class P51_S2_Case_ArrayReverse {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        for (int i = 0 , j = (array.length - 1) ; i < j ; i++ , j--) { //define a loop with 2 variables (MUST BE THE SAME TYPE!!!)
            int tempI = array[i];
            array[i] = array[j];
            array[j] = tempI;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
