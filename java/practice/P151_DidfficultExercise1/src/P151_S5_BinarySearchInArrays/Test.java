package P151_S5_BinarySearchInArrays;

public class Test {
    public static void main(String[] args) {
        //ascending array
        int[] nums = {5, 7, 7, 8, 8, 10, 10, 11};
        int target = 10;

        //binary search for most LEFT index of target
        int leftIndex = getIndex(nums, target, true);

        //binary search for most RIGHT index of target
        int rightIndex = getIndex(nums, target, false);

        //output
        System.out.println("[" + leftIndex + ", " + rightIndex + "]");
    }


    public static int getIndex(int[] nums, int target, boolean left) {
        int tempTargetIndex = -1;
        int minIndex = 0;
        int maxIndex = nums.length - 1;
        while (minIndex <= maxIndex) {
            int middleIndex = (minIndex + maxIndex) / 2;
            if (target > nums[middleIndex]) {
                minIndex = middleIndex + 1;
            } else if (target < nums[middleIndex]) {
                maxIndex = middleIndex - 1;
            } else {
                tempTargetIndex = middleIndex;

                //further searching
                if (left) {
                    maxIndex = middleIndex - 1; //666666
                } else {
                    minIndex = middleIndex + 1; //666666
                }
            }
        }
        return tempTargetIndex;
    }

}
