package P103_Inheritance_S1_ConstructorOfSubClass;

public class Sub extends Super {
    public int age;

    public Sub() {
        super(); //this can be automatically added by java, to call NO_PARAMETER constructor in super class (if NO_PARAMETER constructor in super class exist)
        System.out.println("Sub constructor has been run (no parameters)");
    }

    public Sub(String name, int age) {
        super(name); //If we need to use constructor with parameters in super class, we need to write this line manually
        this.age = age;
        System.out.println("Sub constructor has been run (with parameters)");
    }
}
