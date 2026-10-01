package P154_S5_Case_HouZiChiTao;

public class Test {
    public static void main(String[] args) {
        //1.recursion formula: f(n + 1) + 1 = f(n) / 2
        //2. termination: f(10) = 1
        //3. to approaching termination:在f(n)里递归，一定要f(n)占方程的一边，方法体出先向termination逼近的f(f(n+1) or f(n-1)): f(n) = 2 * f(n + 1) + 2
        System.out.println(f(1));
    }

    private static int f(int n) {
        if (n == 10) {
            return 1;
        } else {
            return 2 * f(n + 1) + 2;
        }
    }
}
