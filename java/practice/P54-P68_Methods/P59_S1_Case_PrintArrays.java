package S4_Methods;

public class P59_S1_Case_PrintArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        printArrays(arr1);
        int[] arr2 = null; //empty array with no address
        printArrays(arr2);
        int[] arr3 = {}; //empty array with no elements
        printArrays(arr3);
    }

    public static void printArrays(int[] arrayToBePrinted) {
        if (arrayToBePrinted == null) {
            System.out.println("Invalid array!");
        } else {
            System.out.print("{");
            for (int i = 0; i < arrayToBePrinted.length; i++) {
                if (i != (arrayToBePrinted.length - 1)) {
                    System.out.print(arrayToBePrinted[i] + ", ");
                } else {
                    System.out.print(arrayToBePrinted[i]);
                }
            }
            System.out.println("}");
        }
    }

}

