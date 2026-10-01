package S4_Methods;

public class P56_S2_Case_OddOrEvenAdjust {
    public static void main(String[] args) {
    OddOrEven(0);
    OddOrEven(1);
    }

    public static void OddOrEven(int number) {
        if (number % 2 == 1) {
            System.out.println(number + " is odd.");
        } else {
            System.out.println(number + " is even.");
        }
    }

}
