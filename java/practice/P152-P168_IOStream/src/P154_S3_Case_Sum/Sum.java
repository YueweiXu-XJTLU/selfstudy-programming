package P154_S3_Case_Sum;

public class Sum {
    public static void main(String[] args) {
        //calculate sum of 1 ~ n
        System.out.println(sum(100));
    }

    //sum(n) = n + sum(n - 1)
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    //key point of recursion:
    //1. a recursion formula
    //2. a termination
    //3. a progress approaching termination
}
