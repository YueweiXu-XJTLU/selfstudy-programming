package P130_S2_SelectionSortAlgorithm;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0, 5, 4, 2, 3, 1};

        //Selection Sort Algorithm: 选择排序算法
        //for ascending:
        int minIndex;
        int temp;

        for (int j = 0; j < arr.length - 1; j++) {
            minIndex = j;

            for (int i = j + 1; i < arr.length; i++) {
                if (arr[minIndex] > arr[i]) {
                    minIndex = i;
                }
            }

            if (minIndex != j) {
                temp = arr[minIndex];
                arr[minIndex] = arr[j];
                arr[j] = temp;
            }

        }

        System.out.println(Arrays.toString(arr));
    }
}
