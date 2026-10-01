package P134_S2_UserDefinedException;

public class InvalidAgeException extends Exception {
    //define a CompileTimeException class:
    //1. create a class extends Exception

    //2. rewrite constructors
    public InvalidAgeException() {
    }

    public InvalidAgeException(String message) {
        super(message); //If we need to use constructor with parameters in super class, we need to write this line manually

    //3. in tst class, use "new XXXXXException("Message to be printed")"
    }
}
