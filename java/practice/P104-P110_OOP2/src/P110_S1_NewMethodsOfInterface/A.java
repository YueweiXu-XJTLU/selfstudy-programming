package P110_S1_NewMethodsOfInterface;

public interface A {
    //methods inside interface are "public" by default, as interface is designed for exposure so that users can use them
    //1. default method: must use "default", no need other modifiers as it will be modified with "public" by default
    //can have method bodies
    //no need to be overridden
    //it is an instance_method, only accessible for implement classes objects
    default void print1() {
        System.out.println("===default method inside interface===");
        print2();
    }

    //2. private method: must use "private"
    //can have method bodies
    //no need to be overridden
    //it is a private instance_method, only accessible inside this interface
    private void print2() {
        System.out.println("===private method inside interface===");
    }

    //3. static method: must use "static", no need other modifiers as it will be modified with "public" by default
    //can have method bodies
    //no need to be overridden
    //it is a static instance_method, it is available to directly use the interface to call it
    static void print3() {
        System.out.println("===static method inside interface===");
    }
}