package P131_BinarySearchAlgorithm;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //Binary Search Algorithm: 二分法查找算法
        int[] arr = {45, 31, 465, 51, 132, 98};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); //[31, 45, 51, 98, 132, 465]

        int aim = 132;
        int indexOfAim = -1;
        int minIndex = 0;
        int maxIndex = arr.length - 1;

        while (true) {
            if (minIndex > maxIndex) {
                System.out.println("The aim: " + aim + "; Can not found!");
                break;
            }
            int middleIndex = (minIndex + maxIndex) / 2;
            if (aim > arr[middleIndex]) {
                minIndex = middleIndex + 1;
            } else if (aim < arr[middleIndex]) {
                maxIndex = middleIndex - 1;
            } else {
                indexOfAim = middleIndex;
                break;
            }
        }
        System.out.println("The aim: " + aim + "; The aim's index: " + indexOfAim);

        //Java has its own Binary Search Algorithm
        System.out.println(Arrays.binarySearch(arr, aim)); //more elegant codes inside source code
    }
}
