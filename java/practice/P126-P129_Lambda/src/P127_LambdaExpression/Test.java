package P127_LambdaExpression;

public class Test {
    public static void main(String[] args) {
        //use Lambda Expression to simplify the statements of anonymous inner class
        //only available for "Functional Interface (函数式接口)" (An interface with only 1 abstract method inside)

        //Original
        Swim s1 = new Swim() {
            @Override
            public String swim(String name) {
                return name + " can swim well!";
            }
        };
        System.out.println(s1.swim("San.Zhang"));

        //Lambda Expression: (parameters) -> {...};
        Swim s2 = (name) -> {
            return name + " can swim well!";
        };
        System.out.println(s2.swim("Si.Li"));

        //Further simplify

        //1. type of parameter can be left out
        //2. if there's only one parameter, "()" can be left out
        //3. if the method body only have one line, "{}" can be left out, also need to leave out ";" OF THE ANONYMOUS INNER CLASS
        //4. in case 3, if the line is "return ...", "return" must be left out
        Swim s3 = name -> name + " can swim well!";
        System.out.println(s3.swim("Wu.Wang"));
    }
}