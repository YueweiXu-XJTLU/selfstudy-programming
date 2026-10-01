package P134_S2_UserDefinedException;

public class Test {
    public static void main(String[] args) {
        //1.define a RuntimeException (using with not serious exception)
        try {
            saveAge1(180);
            System.out.println("the method was successfully executed!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("the method was failed!");
        } finally {
            System.out.println("try/catch/finally block has been run");
            // finally block will always be executed no matter whether the exception is caught or not
        }

        //2.define a (CompileTime)Exception (using with serious exception)
        try {
            saveAge2(180);
            System.out.println("the method was successfully executed!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("the method was failed!");
        } finally {
            System.out.println("try/catch/finally block has been run");
            // finally block will always be executed no matter whether the exception is caught or not
        }
    }

    public static void saveAge1(int age) throws InvalidAgeRuntimeException {
        if (age > 0 && age < 150) {
            System.out.println("Age is saved");
        } else {
//            System.out.println("Invalid age"); //only print this line when exception occurs is very unprofessional
            //we need to define our own exception objects
            //1.define a RuntimeException
            //use "throw" to throw an exception to its caller above
            throw new InvalidAgeRuntimeException("/your age is illegal!");
        }
    }

    public static void saveAge2(int age) throws InvalidAgeException {
        if (age > 0 && age < 150) {
            System.out.println("Age is saved");
        } else {
//            System.out.println("Invalid age"); //only print this line when exception occurs is very unprofessional
            //we need to define our own exception objects
            //2.define a (CompileTime)Exception
            //use "throw" to throw an exception to its caller above
            throw new InvalidAgeException("/your age is illegal!");
            //exception occurs, here we chose "throws" after className
        }
    }
}
