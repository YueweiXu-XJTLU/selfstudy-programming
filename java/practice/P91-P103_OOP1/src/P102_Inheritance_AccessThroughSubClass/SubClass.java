package P102_Inheritance_AccessThroughSubClass;

public class SubClass extends SuperClass {
    public String name = "nameInSubClass";

    @Override
    public void print() {
        System.out.println("Method in SubClass");
    }

    public void accessVariablesInSubClass() {
        String name = "nameInLocal";
        System.out.println(name); //directly use variableName to access local variables
        System.out.println(this.name); //use "this." to access variables in this (Sub)Class
        System.out.println(super.name); //use "super." to access variables in SuperClass
    }


    public void accessMethodsInSubClass() {
        print(); //use "this." to access methods (overridden) in this (Sub)Class
        super.print(); //use "super." to access methods in SuperClass
    }
}