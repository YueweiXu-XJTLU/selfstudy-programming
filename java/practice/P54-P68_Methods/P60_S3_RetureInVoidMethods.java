package S4_Methods;

public class P60_S3_RetureInVoidMethods {
    public static void main(String[] args) {
        DivisionCalculator(4, 0);
    }

    public static void DivisionCalculator(double a, double b) {
        if (b != 0.0) {
            double c = a / b;
            System.out.println("The quotient of " + a  + " and " + b + " is " + c);
        } else {
            System.out.println("Invalid value!");
            return; //Quit the method
        }
    }

}
