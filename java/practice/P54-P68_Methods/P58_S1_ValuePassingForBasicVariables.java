package S4_Methods;

public class P58_S1_ValuePassingForBasicVariables {
    public static void main(String[] args) {
        //Parameter passing 参数传递
        int a = 10; //parameter a (defined inside a method): an actual parameter/an argument 实参 (实际参数)
        valueChange(a); //When call a method using an argument: just passing a copy of the VALUE OF ARGUMENT to parameter
        System.out.println("--------------------");
        System.out.println("Value of a after the method is: " + a);
        System.out.println("--------------------");
        a = valueChange(a); //Use assignment to change the value of an argument
        System.out.println("--------------------");
        System.out.println("Value of a is changed to: " + a);
    }

    public static int valueChange(int b) { //parameter c (defined in the beginning of a method): a formal parameter/a parameter 形参 (形式参数)
        System.out.println("The origin value is " + b);
        b = 20;
        System.out.println("Change value of the parameter to " + b);
        return b;
    }

}
