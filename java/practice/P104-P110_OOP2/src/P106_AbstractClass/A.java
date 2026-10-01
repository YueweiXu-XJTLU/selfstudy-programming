package P106_AbstractClass;

public abstract class A {
    //abstract class cannot create object
    //it can only be used as SuperClass for inheritance

    //abstract class can have no abstract method
    //if abstract methods exist, the class must be abstract class

    public abstract void print(); //abstract method only have signature, no method body

    //Advantage of abstractClass: ENFORCING all subclass to override all abstract methods, to enhances polymorphism
}
