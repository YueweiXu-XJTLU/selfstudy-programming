package S4_Methods;

public class P59_S2_Case_CompareTwoArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {1, 2, 4};
        int[] array4 = {1, 2};
        int[] array5 = null;
        int[] array6 = null;

        System.out.println(compareTwoArrays(array1, array2));
        System.out.println(compareTwoArrays(array1, array3));
        System.out.println(compareTwoArrays(array1, array4));
        System.out.println(compareTwoArrays(array1, array5));
        System.out.println(compareTwoArrays(array1, array6));
        System.out.println(compareTwoArrays(array5, array6));
    }

    public static boolean compareTwoArrays(int[] array1, int[] array2) {
/*
        if ((array1 == null) && (array2 == null)) {
            return true;
        } else if ((array1 == null) || (array2 == null)) {
            return false;
        } else {
            if (array1.length != array2.length) {
                return false;
            } else {
                for (int i = 0; i < array1.length; i++) {
                    if (array1[i] != array2[i]) {
                        return false; //stop running here: codes after "return xxx" will not run
                    }
                }
                return true;
            }
        }
*/
        //a much more concise way
        if ((array1 == null) && (array2 == null)) {
            return true;
        }

        if ((array1 == null) || (array2 == null)) {
            return false;
        }

        if (array1.length != array2.length) {
                return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;

    }

}