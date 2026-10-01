package P106_AbstractClass;

public class Test {
    public static void main(String[] args) {
//        A a = new A(); //abstract class cannot create object
        B b = new B(); //it can only be used as SuperClass for inheritance
        b.print();
    }
}
