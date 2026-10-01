package P94_Static_StaticMethod;

public class Test {
    public static void main(String[] args) { //main method is also a class method, when run a file, JVM run "className.main(String[] args)"
        Student.printStaticMethod();

        Student s1 = new Student();
        s1.printInstanceMethod();
    }
}
