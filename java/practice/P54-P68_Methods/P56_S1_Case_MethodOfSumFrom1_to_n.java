package S4_Methods;

public class P56_S1_Case_MethodOfSumFrom1_to_n {
    public static void main(String[] args) {
        System.out.println(sumFrom1_to_n(100));
    }

    //when writing a method, consider:
    //whether input (parameters) are needed?
    //whether return is needed?
    //How to write the method?
    public static int sumFrom1_to_n(int n) {
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            sum += i;
        }
        return sum;
    }

}
