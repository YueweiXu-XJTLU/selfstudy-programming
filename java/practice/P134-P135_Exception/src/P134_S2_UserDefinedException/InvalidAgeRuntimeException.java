package P134_S2_UserDefinedException;

public class InvalidAgeRuntimeException extends RuntimeException {
    //define a RuntimeException class:
    //1. create a class extends RuntimeException

    //2. rewrite constructors
    public InvalidAgeRuntimeException() {
    }

    public InvalidAgeRuntimeException(String message) {
        super(message); //If we need to use constructor with parameters in super class, we need to write this line manually
    }
}
