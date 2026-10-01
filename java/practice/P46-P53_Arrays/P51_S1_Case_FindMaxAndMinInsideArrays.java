package S3_Arrays;

public class P51_S1_Case_FindMaxAndMinInsideArrays {
    public static void main(String[] args) {
        int[] array = {1, 10, 100, 1000, 1000};

        int max = Integer.MIN_VALUE; //"int max = array[0]" is also a wise initializing
        int min = Integer.MAX_VALUE; //"int min = array[0]" is also a wise initializing

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {max = array[i];}
            if (array[i] < min) {min = array[i];}
        }

        System.out.println("The max element inside the array is: " + max);
        System.out.println("The min element inside the array is: " + min);
    }
}
