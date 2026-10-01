package P130_S1_BubbleSortAlgorithm;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 3, 1};

        //Bubble Sort Algorithm: 冒泡排序算法
        //for ascending:
        int temp;

        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - j - 1; i++) { //"arr.length - j - 1" as every turn, a position (last onr in the latest loop) can be determined
                if (arr[i] > arr[i + 1]) {
                 temp = arr[i];
                 arr[i] = arr[i + 1];
                 arr[i + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
