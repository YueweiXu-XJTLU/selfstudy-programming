package P154_S2_Case_Factorial;

public class Test {
    public static void main(String[] args) {
        //factorial 阶乘
        System.out.println(factorial(5));
    }

    //use logic of recursion: f(n) = n * f(n - 1)
public static int factorial(int n) {
    if (n == 1) {
        return 1; //termination to prevent dead loop
    } else {
        return factorial(n - 1) * n;
    }
}




}
