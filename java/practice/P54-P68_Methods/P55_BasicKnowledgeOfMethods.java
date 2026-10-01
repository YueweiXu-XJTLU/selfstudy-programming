package S4_Methods;

public class P55_BasicKnowledgeOfMethods {
    public static void main(String[] args) {
        //call a method: nameOfMethod(parameters)
        int d = sumCalculation1(1, 2);
        System.out.println(d);

        sumCalculation2(1, 2);

        methodWithoutParameters();
    }

    public static int sumCalculation1(int a, int b) { //nameOfMethod must start with NON-capital letter
        int c = a + b;
        return c; //"return" is ALWAYS PERMITTED without "void"
        //there MUST NOT be codes below "return" statement (unreachable!)
    }

    public static void sumCalculation2(int a, int b) { //use returnType "void", do not return certain data, just run the codes inside the method
        int c = a + b;
        System.out.println(c);
    }

    public static void methodWithoutParameters() { //This is a method without parameters, when calling, just run the codes inside the method without giving of parameters.
        System.out.println("This is a method without parameters.");
        //"return" is NEVER PERMITTED with "void"
    }
}
