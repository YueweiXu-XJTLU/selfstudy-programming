package P94_Static_StaticMethod;

public class Student {
    public static void printStaticMethod() {
        System.out.println("This is a static method, shared by all objects");
    }

    public void printInstanceMethod() {
        System.out.println("This is a instance method, only access to objects.");
    }
}
