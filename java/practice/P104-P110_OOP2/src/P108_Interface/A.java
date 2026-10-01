package P108_Interface;

public interface A {
    //interface: 接口
    //inside interface, variables are set to be constants by default
    //variable modified by "static final" is called "constant (常量)" (name with all-upper-cased-words, link using "_") (more readable, more resource-saving(when compiling, they are automatically convert in to primitive-variables instead of complex-typed-variables))
    String Name_Of_Student = "San.Zhang";

    //inside interface, methods are set to be abstract methods by default
    //if abstract method exists, the class must be abstract, hence can create objects from it
    //public/private/protected/~ are also unnecessary here: they are public by default
    void printA();

    //inside interface, other components (e.g. constructors/codeBlocks) are not allowed
}
